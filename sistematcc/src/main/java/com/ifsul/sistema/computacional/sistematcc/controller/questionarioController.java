package com.ifsul.sistema.computacional.sistematcc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaQuestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;

import jakarta.validation.Valid;

@Controller
public class questionarioController {
    @Autowired
    perguntaQuestionarioRepository perguntaQuestionarioRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    turmaRepository turmaRepository;
    /*Listar Questionarios */
    @GetMapping(value = "/index/questionarios")
    public ModelAndView listarQuestionarios() {
        ModelAndView mv = new ModelAndView("questionarioinicial");
        List<questionarioinicial> list = questionarioinicialRepository.findAll();
        mv.addObject("questionarios", list);
        return mv;
    }

    
    /*Enviar formulario de cadastro de questionario */
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
    /*Enviar formulario de cadastro de questionario em uma turma */
    @PostMapping("/index/turma/{turmaId}/saveQuestInicial") 
    public String setSaveQuestInicial_turma(@Valid questionarioinicial qi,RedirectAttributes redirectAttributes, BindingResult result){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("erro", "confira os campos obrigatórios"+result.toString());
            return "redirect:/index/turma/{turmaId}/questionarios";
        }
        
        try {
           questionarioinicialRepository.save(qi); 
           redirectAttributes.addFlashAttribute("sucesso", "Questionario salvo");
           return "redirect:/index/turma/{turmaId}/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "não foi possivel salvar:"+e.toString());
            return "redirect:/index/turma/{turmaId}/questionarios";
        }
        
    }

    @PostMapping("/index/updatequestionario/{id}")
    public String setUpdateQuestionario(@PathVariable("id") int questionarioId, questionarioinicial novoQ, 
            RedirectAttributes redirectAttributes, BindingResult result){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("erro", "Confira os campos");
            return "redirect:/index/updatequestionario/{id}";
        }
        try {
            questionarioinicial qi = questionarioinicialRepository.findById(questionarioId).get();
            qi.setDisponibilidade(novoQ.getDisponibilidade());
            qi.setNome(novoQ.getNome());
            qi.setVisibilidade(novoQ.isVisibilidade());
            questionarioinicialRepository.save(qi);
            redirectAttributes.addFlashAttribute("sucesso","Questionario atualizado com sucesso!");           
            return "redirect:/index/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro","Questionario não foi atualizado com sucesso!");           
            return "redirect:/index/questionarios";
        }
    }
    @PostMapping("/index/updatequestionario/{id}/{turmaId}")
    public String setUpdateQuestionario_turma(@PathVariable("id") int questionarioId, questionarioinicial novoQ, 
            RedirectAttributes redirectAttributes, BindingResult result){
                if(result.hasErrors()){
                    redirectAttributes.addFlashAttribute("erro", "Confira os campos");
                    return "redirect:/index/turma/{turmaId}/questionarios";
                }
                try {
                    questionarioinicial qi = questionarioinicialRepository.findById(questionarioId).get();
                    qi.setDisponibilidade(novoQ.getDisponibilidade());
                    qi.setNome(novoQ.getNome());
                    qi.setVisibilidade(novoQ.isVisibilidade());
                    questionarioinicialRepository.save(qi);
                    redirectAttributes.addFlashAttribute("sucesso","Questionario atualizado com sucesso!");           
                    return "redirect:/index/turma/{turmaId}/questionarios";
                } catch (Exception e) {
                    redirectAttributes.addFlashAttribute("erro","Questionario não foi atualizado com sucesso!");           
                    return "redirect:/index/turma/{turmaId}/questionarios";
                }
    }

    @GetMapping("/index/deletequestionario/{id}")
    public String deleteQuestionario(@PathVariable("id") int questionarioId, RedirectAttributes redirectAttributes){
        try {
            questionarioinicialRepository.deleteById(questionarioId);
            redirectAttributes.addFlashAttribute("sucesso", "Questionario deletado com sucesso!");
            return "redirect:/index/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Questionario não foi deletado com sucesso");
            return "redirect:/index/questionarios";
        }
    }



     /*Aplicar teste por id */
     @GetMapping(value = "/index/aplicacaoquest/{turmaId}/{questionarioId}")
     public ModelAndView getTesteAplication(@PathVariable("questionarioId") int qId,@PathVariable("turmaId") int turmaId) {
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
     /*Aplicar teste por id */
    //  @PostMapping(value = "/index/aplicacaoteste/{turmaId}/{testeId}")
    //  public String setTesteAplication(@PathVariable("testeId") int testeId,@PathVariable("turmaId") int turmaId, @ModelAttribute perguntasForm lresp,
    //          RedirectAttributes attributes) {
    //      try {
    //          turma turma = turmaRepository.findById(turmaId).get();
    //          teste t = testeRepository.findById(testeId).orElseThrow(null);
    //      List<respostaTeste> ListRespostas = new ArrayList<>();
    //      regTestes reg = new regTestes();
    //      if (alunoRepository.findByMatricula(lresp.getMatricula().trim()).size()>0) {
    //          for (perguntaTeste Pergunta : lresp.getPerguntas()) {
                 
    //              respostaTeste resposta = new respostaTeste();
    //              perguntaTeste p = perguntaTesteRepository.findById(Pergunta.getPerguntaTesteId()).orElseThrow(null);
    //              resposta.setperguntaTeste(p);
    //              resposta.setOpRespostaId(Integer.valueOf(Pergunta.getOpRespostaId()));
    //              ListRespostas.add(resposta);
    //          }
    //          reg.setAluno(alunoRepository.findByMatricula(lresp.getMatricula()).get(0));
    //          reg.setTeste(t);
    //          reg.setTurma(turma);
    //          reg.setRespostasTeste(ListRespostas);
    //          regTestesRepository.save(reg);
    //          attributes.addFlashAttribute("sucesso", "Teste Respondido com sucesso");
    //          return "redirect:/index/inicial";
    //      }else{ 
    //          attributes.addFlashAttribute("erro", "Matricula não encontrada");
    //          return "redirect:/index/inicial";
    //      }
    //      } catch (Exception e) {
    //          attributes.addFlashAttribute("erro", "Teste não foi respondido com sucesso"+e);
    //          return "redirect:/index/inicial";
    //      }
    //  }

    
}
