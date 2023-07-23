package com.ifsul.savapc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.savapc.model.perguntaquestionario;
import com.ifsul.savapc.model.perguntasQuestForm;
import com.ifsul.savapc.model.questionarioinicial;

import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.repository.perguntaQuestionarioRepository;
import com.ifsul.savapc.repository.questionarioinicialRepository;
import com.ifsul.savapc.repository.regQuestionariosRepository;
import com.ifsul.savapc.repository.turmaRepository;
import com.ifsul.savapc.repository.usuarioRepository;
import com.ifsul.savapc.service.questionarioinicialService;
import com.ifsul.savapc.service.serviceImplements.questionarioinicialServiceImplements;

import jakarta.validation.Valid;

@Controller
public class questionarioController {
    @Autowired
    perguntaQuestionarioRepository perguntaQuestionarioRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    questionarioinicialService questionarioinicialService;
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    regQuestionariosRepository regQuestionariosRepository;
    @Autowired
    questionarioinicialServiceImplements questImplements;

    /* Listar Questionarios */
    @GetMapping(value = "/index/questionarios")
    public ModelAndView listarQuestionarios() {
        ModelAndView mv = new ModelAndView("questionarioinicial");
        try {
            questionarioinicialService.atualizarVisibilidade();
            List<questionarioinicial> list = questionarioinicialRepository.findAll();
            mv.addObject("questionarios", list);
        } catch (Exception e) {
            System.err.println(e);
        }
        return mv;
    }

    /* Salvar questionario */
    @PostMapping("/index/saveQuestInicial")
    public String setSaveQuestInicial(@Valid questionarioinicial qi, RedirectAttributes redirectAttributes,
            BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "confira os campos obrigatórios" + result.toString());
            return "redirect:/index/saveQuestInicial";
        }

        try {
            questionarioinicialRepository.save(qi);
            redirectAttributes.addFlashAttribute("sucesso", "Questionario salvo");
            return "redirect:/index/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "não foi possivel salvar:" + e.toString());
            return "redirect:/index/saveQuestInicial";
        }

    }

    /* Salvar questionario em uma turma */
    @PostMapping("/index/turma/{turmaId}/saveQuestInicial")
    public String setSaveQuestInicial_turma(@Valid questionarioinicial qi, RedirectAttributes redirectAttributes,
            BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "confira os campos obrigatórios" + result.toString());
            return "redirect:/index/turma/{turmaId}/questionarios";
        }

        try {
            questionarioinicialRepository.save(qi);
            redirectAttributes.addFlashAttribute("sucesso", "Questionario salvo");
            return "redirect:/index/turma/{turmaId}/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "não foi possivel salvar:" + e.toString());
            return "redirect:/index/turma/{turmaId}/questionarios";
        }

    }

    /* Atualizar questionario */
    @PostMapping("/index/updatequestionario/{id}")
    public String setUpdateQuestionario(@PathVariable("id") int questionarioId, questionarioinicial novoQ,
            RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "Confira os campos");
            return "redirect:/index/updatequestionario/{id}";
        }
        try {
            questionarioinicial qi = questionarioinicialRepository.findById(questionarioId).get();
            qi.setDisponibilidade(novoQ.getDisponibilidade());
            qi.setNome(novoQ.getNome());
            qi.setVisibilidade(novoQ.isVisibilidade());
            questionarioinicialRepository.save(qi);
            redirectAttributes.addFlashAttribute("sucesso", "Questionario atualizado com sucesso!");
            return "redirect:/index/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Questionario não foi atualizado com sucesso!");
            return "redirect:/index/questionarios";
        }
    }

    /* Atualizar questionario em uma turma */
    @PostMapping("/index/updatequestionario/{id}/{turmaId}")
    public String setUpdateQuestionario_turma(@PathVariable("id") int questionarioId, questionarioinicial novoQ,
            RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "Confira os campos");
            return "redirect:/index/turma/{turmaId}/questionarios";
        }
        try {
            questionarioinicial qi = questionarioinicialRepository.findById(questionarioId).get();
            qi.setDisponibilidade(novoQ.getDisponibilidade());
            qi.setNome(novoQ.getNome());
            qi.setVisibilidade(novoQ.isVisibilidade());
            questionarioinicialRepository.save(qi);
            redirectAttributes.addFlashAttribute("sucesso", "Questionario atualizado com sucesso!");
            return "redirect:/index/turma/{turmaId}/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Questionario não foi atualizado com sucesso!");
            return "redirect:/index/turma/{turmaId}/questionarios";
        }
    }

    /* Deletar questionario */
    @GetMapping("/index/deletequestionario/{id}")
    public String deleteQuestionario(@PathVariable("id") int questionarioId, RedirectAttributes redirectAttributes) {
        try {
            questionarioinicialRepository.deleteById(questionarioId);
            redirectAttributes.addFlashAttribute("sucesso", "Questionario deletado com sucesso!");
            return "redirect:/index/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Questionario não foi deletado com sucesso");
            return "redirect:/index/questionarios";
        }
    }

    /* Aplicar questionario */
    @GetMapping(value = "/index/aplicacaoquest/{turmaId}/{questionarioId}")
    public ModelAndView getQuestionarioAplication(@PathVariable("questionarioId") int qId,
            @PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("aplicacaoQuestionario");

        questionarioinicial q = questionarioinicialRepository.findById(qId).get();
        turma turma = turmaRepository.findById(turmaId).get();
        List<perguntaquestionario> perguntas = q.getPerguntasQuestionario();
        mv.addObject("perguntas", perguntas);
        mv.addObject("nomeQuest", q.getNome());
        mv.addObject("questionarioId", q.getQuestionarioId());
        mv.addObject("turmaId", turma.getTurmaId());
        return mv;

    }

    /* Aplicar questionario */
    @PostMapping(value = "/index/aplicacaoquest/{turmaId}/{questionarioId}")
    public String setQuestionarioAplication(@PathVariable("questionarioId") int questionarioId,
            @PathVariable("turmaId") int turmaId, @ModelAttribute perguntasQuestForm lresp,
            RedirectAttributes attributes) {
        try {
            turma turma = turmaRepository.findById(turmaId).get();
            questionarioinicial quest = questionarioinicialRepository.findById(questionarioId).orElseThrow(null);
            for (perguntaquestionario perg : lresp.getPerguntas()) {
                 if(perg.isObrigatorio()){
                    if((perg.getTipo().equalsIgnoreCase("multipla escolha") && perg.getOpRespostaId()==null) || (perg.getTipo().equalsIgnoreCase("dissertativa") && perg.getResposta().isEmpty())){
                        attributes.addFlashAttribute("erro", "Confira e responda os campos obrigatórios!");
                        return "redirect:/index/aplicacaoquest/{turmaId}/{questionarioId}";
                    }
                    
                }
            }
        
            
           
            if(questImplements.salvarRespostasQuest(turma, quest, lresp)){
                attributes.addFlashAttribute("sucesso", "Questionario respondido com sucesso!");
                return "redirect:/index/turma/{turmaId}";
            } else {
                attributes.addFlashAttribute("erro", "A resposta não pôde ser salva!");
                return "redirect:/index/turma/{turmaId}";
            }
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Questionario não foi respondido com sucesso" + e);
            return "redirect:/index/inicial";
        }
    }

}
