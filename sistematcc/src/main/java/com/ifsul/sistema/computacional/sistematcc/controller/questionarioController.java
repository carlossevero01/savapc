package com.ifsul.sistema.computacional.sistematcc.controller;

import java.util.ArrayList;
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

import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.perguntasQuestForm;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;
import com.ifsul.sistema.computacional.sistematcc.model.respostaQuestionarios;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaQuestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regQuestionariosRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.questionarioinicialService;

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
            List<respostaQuestionarios> ListRespostas = new ArrayList<>();
            regQuestionarios reg = new regQuestionarios();
            if (usuarioRepository.findByUsername(lresp.getUsername()) != null) {
                for (perguntaquestionario Pergunta : lresp.getPerguntas()) {
                    respostaQuestionarios resposta = new respostaQuestionarios();
                        perguntaquestionario p = perguntaQuestionarioRepository
                            .findById(Pergunta.getPerguntaQuestionarioId()).orElseThrow(null);
                         resposta.setPerguntaQuestionario(p);
                         resposta.setTipo(Pergunta.getTipo());
                         if (Pergunta.getTipo().equalsIgnoreCase("multipla escolha")) {
                            if(Pergunta.getOpRespostaId()!=null){
                                resposta.setOpRespostaId(Integer.valueOf(Pergunta.getOpRespostaId()));   
                                ListRespostas.add(resposta);
                            } 
                            else{
                                resposta.setOpRespostaId(0);   
                                ListRespostas.add(resposta);
                            }
                        }
                        if (Pergunta.getTipo().equalsIgnoreCase("dissertativa")) {
                            if(!Pergunta.getResposta().isEmpty()){
                                resposta.setResposta(Pergunta.getResposta());
                            ListRespostas.add(resposta);
                            }else{
                                resposta.setResposta(" Em branco");
                            ListRespostas.add(resposta);
                            }
                            
                        }
                    
                    
                }
                reg.setUsuario(usuarioRepository.findByUsername(lresp.getUsername()));
                reg.setQuestionario(quest);
                reg.setTurma(turma);
                reg.setRespostasQuestionario(ListRespostas);
                regQuestionariosRepository.save(reg);
                attributes.addFlashAttribute("sucesso", "Questionario respondido com sucesso!");
                return "redirect:/index/turma/{turmaId}";
            } else {
                attributes.addFlashAttribute("erro", "Matricula não encontrada");
                return "redirect:/index/inicial";
            }
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Questionario não foi respondido com sucesso" + e);
            return "redirect:/index/inicial";
        }
    }

}
