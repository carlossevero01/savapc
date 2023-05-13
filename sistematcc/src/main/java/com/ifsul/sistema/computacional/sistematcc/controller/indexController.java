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
import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaTesteRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaquestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.professorRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.respostaTesteRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;
import jakarta.validation.Valid;

@Controller
public class indexController {
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    professorRepository professorRepository;
    @Autowired
    habilidadeRepository habilidadeRepository;
    @Autowired
    perguntaTesteRepository perguntaTesteRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    perguntaquestionarioRepository perguntaquestionarioRepository;
    @Autowired
    regTestesRepository registroRepository;
    @Autowired
    respostaTesteRepository respostaTesteRepository;
    @Autowired
    regTestesService regTestesService;

    

    /* LOGIN */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index/inicial";
    }
    /* LOGIN */
    /* PAGINA INICIAL(TODOS) */
    @GetMapping(value = "/index/inicial")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    /* PAGINA INICIAL(TODOS) */

    /* DELETAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping(value = "/index/deletealuno/{id}")
    public String deleteAluno(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            alunoRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Aluno deletado");
            return "redirect:/index/alunos";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "id inexistente ou erro desconhecido");
            return "redirect:/index/alunos";
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
     /* DELETAR UNIDADE(PROFESSORES/ADMIN) */

    /* CADASTRAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping("/index/saveAluno")
    public String getSaveAluno() {
        return "saveAluno";
    }

    @PostMapping("/index/saveAluno")
    public String saveAluno(@Valid aluno a, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + a.toString());
            return "redirect:/index/saveAluno";
        }
        alunoRepository.save(a);
        attributes.addFlashAttribute("sucesso", "Aluno cadastrado");
        return "redirect:/index/alunos";
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
    /* CADASTRAR UNIDADE(PROFESSORES/ADMIN) */

    /* LISTAR DADOS(PROFESSORES/ADMIN) */
    @GetMapping(value = "/index/alunos")
    public ModelAndView listarAlunos() {
        ModelAndView mv = new ModelAndView("aluno");
        List<aluno> list = alunoRepository.findAll();
        mv.addObject("alunos", list);
        return mv;
    } 

    @GetMapping(value = "/index/professores")
    public ModelAndView listarProfessores() {
        ModelAndView mv = new ModelAndView("professor");
        List<professor> list = professorRepository.findAll();
        mv.addObject("professores", list);
        return mv;
    }

    
    /* LISTAR DADOS(PROFESSORES/ADMIN) */
    
    @GetMapping("/index/updatealuno/{id}")
    public ModelAndView getUpdateAluno(@PathVariable("id") int alunoId){
        ModelAndView mv = new ModelAndView("updateAluno");
        if(alunoRepository.existsById(alunoId)){
            aluno a = alunoRepository.findById(alunoId).get();
            mv.addObject("aluno", a);
        }
        return mv;
    }
    @PostMapping("/index/updatealuno/{id}")
    public String setUpdateAluno(@PathVariable("id") int alunoId, @Valid aluno novoAluno, RedirectAttributes redirectAttributes){
        if(alunoRepository.existsById(alunoId)){
            aluno alunoExistente = alunoRepository.findById(alunoId).get();
            alunoExistente.setNome(novoAluno.getNome());
            alunoExistente.setMatricula(novoAluno.getMatricula());
            alunoRepository.save(alunoExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Aluno editado com sucesso");
            return "redirect:/index/alunos";
        }
        redirectAttributes.addFlashAttribute("erro", "Não foi possivel salvar");
        return "redirect:/index/alunos";
    }
}
