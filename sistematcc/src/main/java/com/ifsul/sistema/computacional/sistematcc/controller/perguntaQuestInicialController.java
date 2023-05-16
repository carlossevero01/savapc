package com.ifsul.sistema.computacional.sistematcc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaQuestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;

import jakarta.validation.Valid;

@Controller
public class perguntaQuestInicialController {
    @Autowired
    perguntaQuestionarioRepository perguntaquestionarioRepository;
    @Autowired
    questionarioinicialRepository questionarioRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;

    @GetMapping("/index/perguntasquestinicial")
    public ModelAndView getPerguntas(){
        ModelAndView mv = new ModelAndView("perguntaquestionario");
        List<perguntaquestionario> perguntas = perguntaquestionarioRepository.findAll();
        mv.addObject("perguntas", perguntas);
        return mv;
    }
    @GetMapping("/index/perguntasquest/{id}") // Perguntas de um Questionario 
    public ModelAndView getPerguntasdeQuest(@PathVariable("id") int questionarioId){
        ModelAndView mv = new ModelAndView("perguntaquestionario");
        questionarioinicial qi = new questionarioinicial();
        try {
            if(questionarioRepository.existsById(questionarioId)){
                qi = questionarioRepository.findById(questionarioId).get();
                mv.addObject("questionarioId", questionarioId);
                List<perguntaquestionario> perguntas = qi.getPerguntasQuestionario();
                mv.addObject("perguntas", perguntas);
                return mv;
            }else{
                return mv;
            }
           
        } catch (Exception e) {
            return mv;
        }
    }

    
    @GetMapping("/index/saveperguntaquestionario/{id}")
    public ModelAndView getSavePerguntaQuestionario(@PathVariable("id") int questionarioId){
        ModelAndView mv = new ModelAndView("savePerguntaQuestionario");
        if(questionarioRepository.existsById(questionarioId)){
            mv.addObject("questionarioId", questionarioId);
        }
        return mv;
    }
    @PostMapping("/index/saveperguntaquestionario/{id}")
    public String setSavePerguntaQuestionario(@PathVariable("id") int questionarioId, @Valid perguntaquestionario pq, RedirectAttributes redirectAttributes, BindingResult result){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("erro", "Verifique os campos obrigatórios"+ result.toString());
            return "redirect:/index/saveperguntaquestionario/"+questionarioId;
        }
        try {
            questionarioinicial qi = new questionarioinicial();
            List<perguntaquestionario> perguntas = new ArrayList<>();
            if(questionarioRepository.existsById(questionarioId)){
                qi = questionarioRepository.findById(questionarioId).get();
                perguntas.addAll(qi.getPerguntasQuestionario());
                perguntas.add(pq);
                perguntaquestionarioRepository.save(pq);
                qi.setPerguntasQuestionario(perguntas);
                questionarioRepository.save(qi);
            }
            redirectAttributes.addFlashAttribute("sucesso", "Pergunta de Questionario Salva!");
            return "redirect:/index/perguntasquest/" + questionarioId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro:"+e.toString());
            return "redirect:/index/saveperguntaquestionario/{id}";
        }
    }
    
    @GetMapping("/index/{questionarioId}/deleteperguntaquest/{id}")
    public String deletePerguntaQuest(@PathVariable("questionarioId") int questionarioId,@PathVariable("id") int perguntaQuestId, RedirectAttributes redirectAttributes){
        try {
            perguntaquestionarioRepository.deleteById(perguntaQuestId);
            redirectAttributes.addFlashAttribute("sucesso","Pergunta excluida com sucesso!");
            return "redirect:/index/perguntasquest/"+questionarioId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel excluir pergunta!"+e.toString());
            return "redirect:/index/perguntasquest/"+questionarioId;
        }
    }

    @GetMapping("/index/{questionarioId}/updateperguntaquest/{id}")
    public ModelAndView getUpdatePerguntaQuest(@PathVariable("questionarioId") int questionarioId, @PathVariable("id") int perguntaQuestId){
        ModelAndView mv = new ModelAndView("updatePerguntaQuest");
        perguntaquestionario pqExistente = new perguntaquestionario();  
        if(perguntaquestionarioRepository.existsById(perguntaQuestId)){
            pqExistente = perguntaquestionarioRepository.findById(perguntaQuestId).get();
            mv.addObject("pergunta", pqExistente);
            mv.addObject("questionarioId", questionarioId);
        }
        return mv;
      }
      @PostMapping("/index/{questionarioId}/updateperguntaquest/{id}")
      public String setUpdatePerguntaQuest(@PathVariable("questionarioId") int questionarioId, @PathVariable("id") int perguntaQuestId, 
                    @Valid perguntaquestionario novaPergunta, RedirectAttributes redirectAttributes,BindingResult result){
            if(result.hasErrors()){
                redirectAttributes.addFlashAttribute("erro", "confira os campos obrigatórios "+result.toString());
                return "redirect:/index/{questionarioId}/updateperguntaquest/{id}";
            }
            try {
                if(perguntaquestionarioRepository.existsById(perguntaQuestId)){
                   perguntaquestionario perguntaExistente = perguntaquestionarioRepository.findById(perguntaQuestId).get();
                   perguntaExistente.setDescricao(novaPergunta.getDescricao());
                   perguntaExistente.setTipo(novaPergunta.getTipo());
                   perguntaquestionarioRepository.save(perguntaExistente); 
                    redirectAttributes.addFlashAttribute("sucesso", "Pergunta Alterada com sucesso!");
                    return "redirect:/index/perguntasquest/{questionarioId}";
                }else{
                    redirectAttributes.addFlashAttribute("erro", "Questionario ou pergunta não encontrada");
                    return "redirect:/index/perguntasquest/{questionarioId}";
                }
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro!: "+e.toString());
                return "redirect:/index/{questionarioId}/updateperguntaquest/{id}";
            }
                       
      }

      @GetMapping(value = "/index/perguntaquestionario/opcoesresposta/{id}")
    public ModelAndView getOpcoesRespostaPerguntaQuestionario(@PathVariable("id") int perguntaquestionarioId) {
        ModelAndView mv = new ModelAndView("opcaorespostaPergQuest");
        perguntaquestionario p = perguntaquestionarioRepository.findById(perguntaquestionarioId).get();
        List<opcaoresposta> opR = p.getOpcoesResposta();
        mv.addObject("opcoesrespostas", opR);
        mv.addObject("perguntaQuestionarioId", p.getPerguntaQuestionarioId());
        return mv;
    }

    @GetMapping("/index/perguntaquestionario/saveopcaoresposta/{id}")
    public ModelAndView getSaveOpcaoResposta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("saveOpcaorespostaPergQuest");
        mv.addObject("perguntaQuestionarioId", id);
        return mv;
    }

    @PostMapping("/index/perguntaquestionario/saveopcaoresposta/{id}")
    public String saveOpcaoResposta(@PathVariable("id") int id, @Valid opcaoresposta or, BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + or.toString());
            return "redirect:/index/perguntaquestionario/saveopcaoresposta/{id}";
        }
        opcaorespostaRepository.save(or);
        perguntaquestionario p = perguntaquestionarioRepository.findById(id).get();
        List<opcaoresposta> listOR = p.getOpcoesResposta();
        listOR.add(or);
        p.setOpcoesResposta(listOR);
        perguntaquestionarioRepository.save(p);
        attributes.addFlashAttribute("sucesso", "Opcao Resposta cadastrada");
        return "redirect:/index/perguntaquestionario/opcoesresposta/{id}";
    }

    @GetMapping(value = "/index/perguntaquestionario/deleteopcaoresposta/{id}")
    public String deleteOpcaoResposta(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            opcaorespostaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Opção-Resposta deletada");
            return "redirect:/index/perguntaquestionario/opcoesresposta/{id}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/perguntaquestionario/opcoesresposta/{id}";
        }
    }

    ///index/perguntaquestionario/opcoesresposta/{id}


}
