package com.ifsul.sistema.computacional.sistematcc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.turmaForm;
import com.ifsul.sistema.computacional.sistematcc.model.turmaQuestsForm;
import com.ifsul.sistema.computacional.sistematcc.model.turmaTestesForm;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;


import jakarta.validation.Valid;

@Controller
public class turmaController {
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    
    /*Listar turmas que tenham a visibilidade true */
    @GetMapping(value = "/turmas")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("turmasAluno");
        List<turma> lturma = turmaRepository.findByVisibilidade(true);
        mv.addObject("turmas", lturma);
        return mv;
    }

    /*Delete uma turma por id */
    @GetMapping(value = "/index/deleteturma/{id}")
    public String deleteTurma(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            turmaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Turma deletada");
            return "redirect:/index/turmas";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/turmas";
        }
    }
    /*Salva uma nova turma */
    @GetMapping("/index/saveTurma")
    public ModelAndView getSaveTurma() {
        ModelAndView mv = new ModelAndView("saveTurma");
        List<teste> testes = testeRepository.findAll();
        mv.addObject("testes", testes);
        return mv;
    }
    /*Salva uma nova turma */
    @PostMapping("/index/saveTurma")
    public String saveTurma(@Valid turmaForm t, BindingResult result, RedirectAttributes attributes) {
        List<teste> testes = new ArrayList<>();
        turma turma = new turma();
        
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTurma";
        }
        try {
            if(t.getTestes()!=null){
                for (teste test : t.getTestes()) {
                    if(testeRepository.existsById(test.getTesteId())){
                        teste te = testeRepository.findById(test.getTesteId()).orElseThrow(null);
                        testes.add(te);
                    }
                }
                turma = new turma(t.getNome(), t.isVisibilidade(), testes);
            }else{
                turma = new turma(t.getNome(), t.isVisibilidade(), null);
            }
            
            turmaRepository.save(turma);
            attributes.addFlashAttribute("sucesso", "Turma Cadastrada com Sucesso");
            return "redirect:/index/turmas";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Não foi possível cadastrar a turma"+e.toString());
        return "redirect:/index/turmas";
        }
      }
    

    /*Lista todas as turmas */
    @GetMapping(value = "/index/turmas")
    public ModelAndView listarTurmas() {
        ModelAndView mv = new ModelAndView("turma");
        List<turma> list = turmaRepository.findAll();
        mv.addObject("turmas", list);
        List<teste> testes = testeRepository.findAll();
        mv.addObject("testes", testes);
        return mv;
    }
    /*Inscrive um aluno pela matricula na turma por id */
    @PostMapping("/index/cadAlunoTurma/{id}")
    public String cadAlunoTurma(@PathVariable("id") int turmaId, @RequestParam("matricula") String matricula,
            RedirectAttributes redirectAttributes) {
        if (matricula.equalsIgnoreCase("")) {
            redirectAttributes.addFlashAttribute("erro", "insira a sua matricula");
            return "redirect:/turmas";
        } else {
            turma t = turmaRepository.findById(turmaId).orElseThrow(null);
            if(alunoRepository.findByMatricula(matricula).isEmpty()){
                redirectAttributes.addFlashAttribute("erro", "Matricula não encontrada");
                return "redirect:/turmas";
            }
            t.getAlunos().add(alunoRepository.findByMatricula(matricula).get(0));
            turmaRepository.save(t);
            redirectAttributes.addFlashAttribute("sucesso", "Inscrição realizada com sucesso");
            return "redirect:/turmas";
        }
    }

    @GetMapping("/index/updateturma/{id}")
    @ResponseBody
    public ModelAndView getTurmaUpdate(@PathVariable("id") int turmaId, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("updateTurma");
        try {
            if(turmaRepository.findById(turmaId).isPresent()){
                turma turm = turmaRepository.findById(turmaId).get();
                mv.addObject("turma", turm);
            }else{
                redirectAttributes.addFlashAttribute("erro", "Turma não encontrada");
                return mv;
            }
        
        } catch (Exception e) {
            System.out.println("ERRO" + e);
        }
        return mv;
    }

    @PostMapping("/index/updateturma/{id}")
    public String setTurmaUpdate(@PathVariable("id") int turmaId, @Valid turma novaturma,
            RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            turma turmaExistente = turmaRepository.findById(turmaId).get();
            turmaExistente.setNome(novaturma.getNome());
            turmaExistente.setVisibilidade(novaturma.isVisibilidade());
            turmaRepository.save(turmaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Turma editada com sucesso");
            return "redirect:/index/turmas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/turmas";

        }
    }

    @GetMapping("/index/turma/{id}")
    public ModelAndView insideTurma(@PathVariable("id") int turmaId, RedirectAttributes redirectAttributes){
        ModelAndView mv = new ModelAndView("insideTurma");
        if(turmaRepository.findById(turmaId)!=null){
            turma t = turmaRepository.findById(turmaId).get();
            try {
                List<teste> tests = t.getTestes();
                List<teste> testes = new ArrayList<>();
                for (teste test : tests) {
                    if(test.getVisibilidade()){
                        testes.add(test);
                    }
                }
                List<questionarioinicial> questionarios = t.getQuestionarios();
                List<questionarioinicial> quest = new ArrayList<>();
                for (questionarioinicial q : questionarios) {
                    if(q.isVisibilidade()){
                        quest.add(q);
                    }
                }
                mv.addObject("testes", testes);
                mv.addObject("turma", t);   
                mv.addObject("questionarios", quest); 
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("erro", "Erro na busca dos testes ou questionarios da turma");
            }
            
        }
        else{
            redirectAttributes.addFlashAttribute("erro", "Turma não encontrada");
           
        }
        return mv;
    }
    /*Mostra os testes da turma */
    @GetMapping("/index/turma/{turmaId}/testes")
    public ModelAndView getTestesTurma(@PathVariable("turmaId") int turmaId){
        ModelAndView mv = new ModelAndView("testesTurma");
        try {
            List<teste> testes = testeRepository.findAll();
            List<teste> testesTurma = testeRepository.findByTurmas(turmaRepository.findById(turmaId).get());
            mv.addObject("testesAll", testes);
            mv.addObject("testesTurma", testesTurma);
            mv.addObject("turmaId", turmaId);
        } catch (Exception e) {
            
        }
        return mv;
    }
    /*Inclui os testes selecionados na turma*/
    @PostMapping("/index/turma/{turmaId}/testes")
    public String setTestesTurma(@PathVariable("turmaId") int turmaId, turmaTestesForm testesTurma, RedirectAttributes redirectAttributes){
        try {
            
            turma turma = turmaRepository.findById(turmaId).get();
            turma.getTestes().clear();
            if(testesTurma.getTestes() != null && testesTurma.getTestes().size()>0){
            for (teste test : testesTurma.getTestes()) {
                if(test.getTesteId()>0){
                    turma.getTestes().add(testeRepository.findById(test.getTesteId()).get());    
                }
            }
            }
            turmaRepository.save(turma);
           redirectAttributes.addFlashAttribute("sucesso","Testes Alterados da turma!");
           return "redirect:/index/turma/{turmaId}/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro","Ocorreu um erro e os testes não foram alterados: " + e.toString());
            return "redirect:/index/turmas";
        }
    }
    @GetMapping("/index/turma/{turmaId}/questionarios")
    public ModelAndView getQuestionariosTurma(@PathVariable("turmaId") int turmaId){
        ModelAndView mv = new ModelAndView("questionariosTurma");
        try {
            List<questionarioinicial> quests = questionarioinicialRepository.findAll();
            List<questionarioinicial> questsTurma = questionarioinicialRepository.findByTurmas(turmaRepository.findById(turmaId).get());
            mv.addObject("questsAll", quests);
            mv.addObject("questsTurma", questsTurma);
            mv.addObject("turmaId", turmaId);
        } catch (Exception e) {
            
        }
        return mv;
    }
    @PostMapping("/index/turma/{turmaId}/questionarios")
    public String setQuestionariosTurma(@PathVariable("turmaId") int turmaId, turmaQuestsForm questsTurma, RedirectAttributes redirectAttributes){
        try {  
            turma turma = turmaRepository.findById(turmaId).get();
            turma.getQuestionarios().clear();
            if(questsTurma.getQuestionarios() != null && questsTurma.getQuestionarios().size()>0){
            for (questionarioinicial quest : questsTurma.getQuestionarios()) {
                if(quest.getQuestionarioId()>0){
                    
                    turma.getQuestionarios().add(questionarioinicialRepository.findById(quest.getQuestionarioId()).get());    
                }
            }
            }
            turmaRepository.save(turma);
           redirectAttributes.addFlashAttribute("sucesso","Questionarios da turma alterados!");
           return "redirect:/index/turma/{turmaId}/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro","Ocorreu um erro e os questionarios não foram alterados: " + e.toString());
            return "redirect:/index/turma/{turmaId}/questionarios";
        }
        
    }
}
