package com.ifsul.sistema.computacional.sistematcc.controller;

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

import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;


import jakarta.validation.Valid;

@Controller
public class turmaController {
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    alunoRepository alunoRepository;
    
    
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
    public String getSaveTurma() {
        return "saveTurma";
    }
    /*Salva uma nova turma */
    @PostMapping("/index/saveTurma")
    public String saveTurma(@Valid turma t, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTurma";
        }
        turmaRepository.save(t);
        attributes.addFlashAttribute("sucesso", "Turma cadastrada");
        return "redirect:/index/turmas";
    }
    /*Lista todas as turmas */
    @GetMapping(value = "/index/turmas")
    public ModelAndView listarTurmas() {
        ModelAndView mv = new ModelAndView("turma");
        List<turma> list = turmaRepository.findAll();
        mv.addObject("turmas", list);
        return mv;
    }
    /*Inscrive um aluno pela matricula na turma por id */
    @PostMapping("/index/cadAlunoTurma/{id}")
    public String cadAlunoTurma(@PathVariable("id") int turmaId, @RequestParam("matricula") String matricula,
            RedirectAttributes redirectAttributes) {
        if (matricula.equalsIgnoreCase("")) {
            redirectAttributes.addFlashAttribute("erro", "insira a sua matricula");
            return "redirect:/index/inicial";
        } else {
            turma t = turmaRepository.findById(turmaId).orElseThrow(null);
            t.getAlunos().add(alunoRepository.findByMatricula(matricula).get(0));
            turmaRepository.save(t);
            redirectAttributes.addFlashAttribute("sucesso", "Inscrição realizada com sucesso");
            return "redirect:/index/inicial";
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
            turmaRepository.save(turmaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Turma editada com sucesso");
            return "redirect:/index/turmas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/turmas";

        }
    }
    
}
