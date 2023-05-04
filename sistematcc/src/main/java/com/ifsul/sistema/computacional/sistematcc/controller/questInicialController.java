package com.ifsul.sistema.computacional.sistematcc.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaquestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;

import jakarta.validation.Valid;

@Controller
public class questInicialController {
    @Autowired
    perguntaquestionarioRepository perguntaquestionarioRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    alunoRepository alunoRepository;

    @GetMapping(value = "/index/questionarios")
    public ModelAndView listarQuestionarios() {
        ModelAndView mv = new ModelAndView("questionarioinicial");
        List<questionarioinicial> list = questionarioinicialRepository.findAll();
        mv.addObject("questionarios", list);
        return mv;
    }

    @GetMapping("/index/saveQuestInicial")
    public ModelAndView getSaveQuestInicial(){
        ModelAndView mv = new ModelAndView("saveQuestInicial");
        return mv;
    } 
    @PostMapping("/index/saveQuestInicial") 
    public String setSaveQuestInicial(@Valid questionarioinicial qi,RedirectAttributes redirectAttributes, BindingResult result){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("erro", "confira os campos obrigatórios"+result.toString());
            return "redirect:/index/saveQuestInicial";
        }
        
        try {
           questionarioinicialRepository.save(qi); 
           redirectAttributes.addFlashAttribute("sucesso", "Questionario salvo");
           return "redirect:/index/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "não foi possivel salvar:"+e.toString());
            return "redirect:/index/saveQuestInicial";
        }
        
    }

    @GetMapping(value = "/CadPerguntasQuestInicial") // @RequestMapping(value = "/listarCandidatos", method =  // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<questionarioinicial> setPerguntasQuestInicial() {
        System.out.println("cadastrar perguntas no questionario inicial");
        perguntaquestionario pq = new perguntaquestionario("pergunta 1 do questionario", "discursiva");
        questionarioinicial qi = new questionarioinicial(LocalDate.of(2022, 8, 10), false, "questionario inicial 1");
        perguntaquestionarioRepository.save(pq);
        qi.setPerguntasQuestionario(perguntaquestionarioRepository.findAll());
        questionarioinicialRepository.save(qi);

        return questionarioinicialRepository.findAll();
    }

    @GetMapping(value = "/CadAlunoQuestionario") // @RequestMapping(value = "/listarCandidatos", method = // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<questionarioinicial> setAlunoQuestInicial() {
        System.out.println("cadastrar aluno no Questionario inicial");

        questionarioinicial qin = questionarioinicialRepository.findAll().get(0);
        qin.setAlunos(alunoRepository.findAll());
        questionarioinicialRepository.save(qin);
        return questionarioinicialRepository.findAll();
    }
}
