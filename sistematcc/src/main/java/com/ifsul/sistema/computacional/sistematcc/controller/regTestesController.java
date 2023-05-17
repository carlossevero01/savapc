package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.contabilizacaoPorHabilidade;

import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.serviceImplements.regTestesServiceImplements;


@Controller
public class regTestesController {
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    regTestesServiceImplements regTestesServiceImplements;
    @Autowired
    turmaRepository turmaRepository;

    @GetMapping("/index/relatorioTeste")
    @ResponseBody
    public ModelAndView getRelatorio( ) {
         ModelAndView mv = new ModelAndView("relatorioTeste");
         List<contabilizacaoPorHabilidade> contabilizacaoList = regTestesServiceImplements.contabilizartudo();
         mv.addObject("contabilizacoes", contabilizacaoList);
         return mv;
    }
    @GetMapping("/index/relatorioTeste/{turmaId}")
    @ResponseBody
    public ModelAndView getRelatorioTurma(@PathVariable("turmaId") int turmaId ) {
         ModelAndView mv = new ModelAndView("relatorioTestePorTurma");
         turma turma = turmaRepository.findById(turmaId).get();
         List<contabilizacaoPorHabilidade> contabilizacaoListTurma = regTestesServiceImplements.contabilizarTestesPorTurma(turma);
         mv.addObject("contabilizacoes", contabilizacaoListTurma);
         mv.addObject("turma", turma);
         return mv;
    }

    @GetMapping("/index/exportarRelatorio/{turmaId}")
    public String exportRelatorioTurma(@PathVariable("turmaId") int turmaId,RedirectAttributes redirectAttributes){
        try {
            String csvFilePath = "Reviews-export.csv";
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            fileWriter.write("teste,turma,aluno,nQuestoes,nQcorretas,H1,H2,H3,H4,H5,peso, valorTotal, recomendacao");
           
            turma turma = turmaRepository.findById(turmaId).get();
            List<contabilizacaoPorHabilidade> contabilizacaoListTurma = regTestesServiceImplements.contabilizarTestesPorTurma(turma);
           for (contabilizacaoPorHabilidade cL : contabilizacaoListTurma) {
            String line = String.format("\"%s\",%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                    cL.getTeste(), cL.getTurma(), cL.getAluno() , cL.getnQ(), cL.getnQcorretas(),cL.getnQChab1(),cL.getnQChab2(),cL.getnQChab3(),cL.getnQChab4(),cL.getnQChab5(), cL.getPeso(), cL.getValorTotal(),cL.getRecomendacao());
   
                    fileWriter.newLine();
                    fileWriter.write(line); 
              
                
            }
            fileWriter.close();

            redirectAttributes.addFlashAttribute("sucesso", "Dados exportados com sucesso");
            return "redirect:/index/relatorioTeste/{turmaId}";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel exportar os dados");
            return "redirect:/index/relatorioTeste/{turmaId}";    
        }
    }

    @GetMapping("/index/exportarRelatorio")
    public String exportRelatorio(RedirectAttributes redirectAttributes){
        try {
            String csvFilePath = "Reviews-export.csv";
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            fileWriter.write("teste,turma,aluno,nQuestoes,nQcorretas,H1,H2,H3,H4,H5,peso, valorTotal, recomendacao");
           
           
           List<contabilizacaoPorHabilidade> contabilizacaoList = regTestesServiceImplements.contabilizartudo(); 
           for (contabilizacaoPorHabilidade cL : contabilizacaoList) {
                String line = String.format("\"%s\",%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                    cL.getTeste(), cL.getTurma(), cL.getAluno() , cL.getnQ(), cL.getnQcorretas(),cL.getnQChab1(),cL.getnQChab2(),cL.getnQChab3(),cL.getnQChab4(),cL.getnQChab5(), cL.getPeso(), cL.getValorTotal(),cL.getRecomendacao());
        
                    fileWriter.newLine();
                    fileWriter.write(line); 
              
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
