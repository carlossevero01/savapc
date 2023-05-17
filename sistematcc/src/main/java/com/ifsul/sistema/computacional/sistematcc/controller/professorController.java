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

import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.professorRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;

import jakarta.validation.Valid;

@Controller
public class professorController {
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    professorRepository professorRepository;

    @GetMapping("/painelgeral")
    public ModelAndView getPainelGeral(){
        ModelAndView mv = new ModelAndView("PainelGeral");
        try {
            if(turmaRepository.count()>0){
                List<turma> turmas = turmaRepository.findAll();
                mv.addObject("turmas", turmas);
            }
            if(testeRepository.count()>0){
                List<teste> testes = testeRepository.findAll();
                mv.addObject("testes", testes);
            }

            return mv;
        } catch (Exception e) {
            return mv;
        }
    }

    @GetMapping(value = "/index/deleteprofessor/{id}")
    public String deleteProfessor(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            professorRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Professor deletado");
            return "redirect:/index/professores";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/professores";
        }
    }

    @GetMapping(value = "/index/professores")
    public ModelAndView listarProfessores() {
        ModelAndView mv = new ModelAndView("professor");
        List<professor> list = professorRepository.findAll();
        mv.addObject("professores", list);
        return mv;
    }

    @GetMapping("/index/saveProfessor")
    public String getSaveProfessor() {
        return "saveProfessor";
    }

    @PostMapping("/index/saveProfessor")
    public String saveProfessor(@Valid professor p, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + p.toString());
            return "redirect:/index/saveProfessor";
        }
        professorRepository.save(p);
        attributes.addFlashAttribute("sucesso", "Professor cadastrado");
        return "redirect:/index/professores";
    }
    @PostMapping("/index/updateprofessor/{id}")
    public String setUpdateProfessor(@PathVariable("id") int professorId, @Valid professor novoprofessor, RedirectAttributes redirectAttributes){
        if(professorRepository.existsById(professorId)){
            professor p = professorRepository.findById(professorId).get();
            p.setNome(novoprofessor.getNome());
            professorRepository.save(p);
            redirectAttributes.addFlashAttribute("sucesso", "Professor editado com sucesso");
            return "redirect:/index/professores";
        }
        redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar");
        return "redirect:/index/professores";
    }
}
