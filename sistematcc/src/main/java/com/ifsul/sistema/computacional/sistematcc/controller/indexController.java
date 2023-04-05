package com.ifsul.sistema.computacional.sistematcc.controller;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaquestionario;
import com.ifsul.sistema.computacional.sistematcc.model.professor;
import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaquestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.professorRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.registroRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.respostasRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.registroService;

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
    perguntaRepository perguntaRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    perguntaquestionarioRepository perguntaquestionarioRepository;
    @Autowired
    registroRepository registroRepository;
    @Autowired
    respostasRepository respostasRepository;
    @Autowired
    registroService registroService;

    @GetMapping(value = "/CadPerguntasQuestInicial") // @RequestMapping(value = "/listarCandidatos", method =
                                                     // RequestMethod.GET)
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

    @GetMapping(value = "/CadAlunoQuestionario") // @RequestMapping(value = "/listarCandidatos", method =
                                                 // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<questionarioinicial> setAlunoQuestInicial() {
        System.out.println("cadastrar aluno no Questionario inicial");

        questionarioinicial qin = questionarioinicialRepository.findAll().get(0);
        qin.setAlunos(alunoRepository.findAll());
        questionarioinicialRepository.save(qin);
        return questionarioinicialRepository.findAll();
    }

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
        List<turma> lturma = turmaRepository.findAll();
        mv.addObject("turmas", lturma);
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

    @GetMapping(value = "/index/questionarios")
    public ModelAndView listarQuestionarios() {
        ModelAndView mv = new ModelAndView("questionarioinicial");
        List<questionarioinicial> list = questionarioinicialRepository.findAll();
        mv.addObject("questionarios", list);
        return mv;
    }
    /* LISTAR DADOS(PROFESSORES/ADMIN) */
 
}
