package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.contabilizacao;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.registro;
import com.ifsul.sistema.computacional.sistematcc.model.resposta;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.registroRepository;
import com.ifsul.sistema.computacional.sistematcc.service.registroService;

@Controller
public class registroController {
    @Autowired
    registroRepository registroRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    registroService registroService;

    @GetMapping("/index/relatorio")
    @ResponseBody
    public ModelAndView getRelatorio( ) {
        List<registro> regs = registroRepository.findAll();
        for(int i=0;i<regs.size();i++){
            if(regs.get(i).getAluno().getAlunoId()==-1
                || regs.get(i).getTeste().getTesteId()==-1){
                    regs.remove(i);  
            }
            if(regs.get(i).getRespostas().size()>0){
                for(int j=0;j<regs.get(i).getRespostas().size();j++){
                    if(regs.get(i).getRespostas().get(j).getPergunta()==null){
                        regs.get(i).getRespostas().remove(j);
                    }
                }
            }
        }
        
        
        ModelAndView mv = new ModelAndView("relatorioTeste");

        List<correcoesAluno> correcaoList = new ArrayList<>();
        List<contabilizacao> contabilizacaoList = new ArrayList<>();
        int nQcorretas = 0;
        int nQChab1 = 0;
        int nQChab2 = 0;
        int nQChab3 = 0;
        int nQChab4 = 0;
        int nQChab5 = 0;
        int nQ = 0;
        for (registro r : regs) {
            nQcorretas = 0;
            nQChab1 = 0;
            nQChab2 = 0;
            nQChab3 = 0;
            nQChab4 = 0;
            nQChab5 = 0;
            nQ = r.getTeste().getPerguntas().size();
            for (resposta resp : r.getRespostas()) {

                if (resp.getOpRespostaId() == opcaorespostaRepository
                        .findOpcaoRespostaIdByPerguntasAndVerdadeira(resp.getPergunta(), true).get(0)
                        .getOpcaoRespostaId()) {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPergunta().getPerguntaId(), resp.getOpRespostaId(), true);

                    nQcorretas++;
                    for (habilidade h : resp.getPergunta().getHabilidades()) {
                        switch (h.getNome()) {
                            case "compreensao":
                                nQChab1++;
                                break;
                            case "abstracao":
                                nQChab2++;
                                break;
                            case "resolucao de problemas":
                                nQChab3++;
                                break;
                            case "resolucao algoritmica":
                                nQChab4++;
                                break;
                            case "avaliacao":
                                nQChab5++;
                                break;
                            default:
                                break;
                        }
                    }
                    correcaoList.add(cA);
                } else {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPergunta().getPerguntaId(), resp.getOpRespostaId(), false);
                    correcaoList.add(cA);
                }
            }
            var contQH = new contabilizacao(r.getAluno().getAlunoId(), r.getTeste().getTesteId(), nQcorretas, nQChab1,
                    nQChab2, nQChab3, nQChab4, nQChab5, nQ);
            contabilizacaoList.add(contQH);
        }

        
        mv.addObject("contabilizacoes", contabilizacaoList);

       
        

        return mv;
    }

    @GetMapping("/index/exportarRelatorio")
    public String exportRelatorio(RedirectAttributes redirectAttributes){
        try {
            String csvFilePath = "Reviews-export.csv";
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            fileWriter.write("alunoId, testeId, nQcorretas, nQ,H1,H2,H3,H4,H5, valorTotal, recomendacao");
           
           // linhas.add(new String[]{"alunoId", "testeId", "nQcorretas","nQ","valorTotal","recomendacao" });
           List<contabilizacao> contabilizacaoList = registroService.contabilizartudo(); 
           for (contabilizacao cL : contabilizacaoList) {
                String line = String.format("\"%s\",%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                            cL.getAlunoId(), cL.getTesteId(), cL.getnQcorretas(), cL.getnQ(),cL.getnQChab1(),cL.getnQChab2(),cL.getnQChab3(),cL.getnQChab4(),cL.getnQChab5(),cL.getValorTotal(),cL.getRecomendacao());
                     
                    fileWriter.newLine();
                    fileWriter.write(line); 
              //  linhas.add(new String[]{cL.getAlunoId()+"",cL.getTesteId()+"",cL.getnQcorretas()+"",cL.getnQ()+"",cL.getValorTotal()+"",cL.getRecomendacao()+""});
                System.out.println(cL.getAlunoId()+"|"+cL.getTesteId()+"|"+cL.getnQcorretas()+"|"+cL.getnQ()+"|"+cL.getValorTotal()+"|"+cL.getRecomendacao());
            }
            fileWriter.close();

            redirectAttributes.addFlashAttribute("sucesso", "Dados exportados com sucesso");
            return "redirect:/index/inicial";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel exportar os dados");
            return "redirect:/index/inicial";    
        }
    }

    @GetMapping(value = "/index/resultadosTeste")
    public ModelAndView getResultadosTeste() {
        ModelAndView mv = new ModelAndView("resultTeste");
        List<registro> lreg = registroRepository.findAll();
        System.out.println(lreg.toString());
        mv.addObject("registros", lreg);
        return mv;
    }
}
