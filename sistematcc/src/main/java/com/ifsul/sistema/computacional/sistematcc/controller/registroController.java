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
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.respostaTeste;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;

@Controller
public class registroController {
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    regTestesService regTestesService;

    @GetMapping("/index/relatorio")
    @ResponseBody
    public ModelAndView getRelatorio( ) {
        List<regTestes> regs = regTestesRepository.findAll();
        for(int i=0;i<regs.size();i++){
            if(regs.get(i).getAluno().getAlunoId()==-1
                || regs.get(i).getTeste().getTesteId()==-1){
                    regs.remove(i);  
            }
            if(regs.get(i).getRespostasTeste().size()>0){
                for(int j=0;j<regs.get(i).getRespostasTeste().size();j++){
                    if(regs.get(i).getRespostasTeste().get(j).getPerguntaTeste()==null){
                        regs.get(i).getRespostasTeste().remove(j);
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
        for (regTestes r : regs) {
            nQcorretas = 0;
            nQChab1 = 0;
            nQChab2 = 0;
            nQChab3 = 0;
            nQChab4 = 0;
            nQChab5 = 0;
            nQ = r.getTeste().getPerguntasTeste().size();
            for (respostaTeste resp : r.getRespostasTeste()) {

                if (resp.getOpRespostaId() == opcaorespostaRepository
                        .findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(resp.getPerguntaTeste(), true).get(0)
                        .getOpcaoRespostaId()) {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPerguntaTeste().getPerguntaTesteId(), resp.getOpRespostaId(), true);

                    nQcorretas++;
                    for (habilidade h : resp.getPerguntaTeste().getHabilidades()) {
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
                            r.getTeste().getNome(), resp.getPerguntaTeste().getPerguntaTesteId(), resp.getOpRespostaId(), false);
                    correcaoList.add(cA);
                }
            }
            var contQH = new contabilizacao(r.getAluno().getAlunoId(), r.getTeste().getTesteId(), nQcorretas, nQChab1,
                    nQChab2, nQChab3, nQChab4, nQChab5, nQ, r.getTeste().getPeso());
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
           List<contabilizacao> contabilizacaoList = regTestesService.contabilizartudo(); 
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
        List<regTestes> lreg = regTestesRepository.findAll();
        System.out.println(lreg.toString());
        mv.addObject("registros", lreg);
        return mv;
    }
}
