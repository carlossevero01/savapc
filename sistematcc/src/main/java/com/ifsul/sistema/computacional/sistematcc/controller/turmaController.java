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

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.turmaForm;
import com.ifsul.sistema.computacional.sistematcc.model.turmaQuestsForm;
import com.ifsul.sistema.computacional.sistematcc.model.turmaTestesForm;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.questionarioinicialService;
import com.ifsul.sistema.computacional.sistematcc.service.testeService;

import jakarta.validation.Valid;

@Controller
public class turmaController {
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    testeRepository testeRepository;
    @Autowired
    testeService testeService;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    questionarioinicialService questionarioinicialService;

    /* Listar turmas que tenham a visibilidade true */
    @GetMapping(value = "/turmas")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("turmasAluno");
        List<turma> lturma = turmaRepository.findByVisibilidade(true);

        mv.addObject("turmas", lturma);
        return mv;
    }

    /* Delete uma turma por id */
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

    /* Salva uma nova turma */
    @PostMapping("/index/saveTurma")
    public String saveTurma(@Valid turmaForm t, BindingResult result, RedirectAttributes attributes) {

        List<teste> testes = new ArrayList<>();
        testes.clear();
        turma turma = new turma();

        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTurma";
        }
        try {
            if (t.getTestes() != null) {
                if (t.getTestes().size() > 0) {
                    for (teste test : t.getTestes()) {
                        if (testeRepository.existsById(test.getTesteId())) {
                            teste te = testeRepository.findById(test.getTesteId()).orElseThrow(null);
                            System.out.println("\n TESTE:" + te.getNome());
                            testes.add(te);
                        }
                    }
                    turma.setNome(t.getNome());
                    turma.setTestes(testes);
                    turma.setVisibilidade(t.isVisibilidade());

                }
            } else {

                turma.setNome(t.getNome());
                turma.setVisibilidade(t.isVisibilidade());

            }
            turmaRepository.save(turma);
            attributes.addFlashAttribute("sucesso", "Turma Cadastrada com Sucesso" + t.getNome());
            return "redirect:/index/turmas";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Não foi possível cadastrar a turma" + e.toString());
            return "redirect:/index/turmas";
        }
    }

    /* Lista todas as turmas */
    @GetMapping(value = "/index/turmas")
    public ModelAndView listarTurmas() {
        ModelAndView mv = new ModelAndView("turma");
        List<turma> list = turmaRepository.findAll();
        mv.addObject("turmas", list);
        List<teste> testes = testeRepository.findAll();
        mv.addObject("testes", testes);
        return mv;
    }

    /* Inscrive um aluno na turma por id */
    @PostMapping("/index/cadAlunoTurma/{id}")
    public String cadAlunoTurma(@PathVariable("id") int turmaId, @RequestParam("username") String username,
            RedirectAttributes redirectAttributes) {
        if (username.equalsIgnoreCase("")) {
            redirectAttributes.addFlashAttribute("erro", "identificador não encontrado");
            return "redirect:/turmas";
        } else {
            turma t = turmaRepository.findById(turmaId).orElseThrow(null);
            List<usuario> listUsuarios = t.getUsuarios();

            if (usuarioRepository.findByUsername(username) == null) {
                redirectAttributes.addFlashAttribute("erro", "usuario não encontrado");
                return "redirect:/turmas";
            }
            usuario usu = usuarioRepository.findByUsername(username);
            if (listUsuarios.contains(usu)) {
                redirectAttributes.addFlashAttribute("erro", "usuario já inscrito");
                return "redirect:/turmas";
            }
            t.getUsuarios().add(usu);
            turmaRepository.save(t);
            redirectAttributes.addFlashAttribute("sucesso", "Inscrição realizada com sucesso");
            return "redirect:/turmas";
        }
    }

    /* Atualizar turma */
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

    /* Exibir interior da turma */
    @GetMapping("/index/turma/{id}")
    public ModelAndView insideTurma(@PathVariable("id") int turmaId, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("insideTurma");
        if (turmaRepository.findById(turmaId) != null) {
            turma t = turmaRepository.findById(turmaId).get();
            try {
                testeService.atualizarVisibilidades(); /* Teste de disponibilidade */
                questionarioinicialService.atualizarVisibilidade();
                List<teste> tests = t.getTestes();
                List<teste> testes = new ArrayList<>();
                for (teste test : tests) {
                    if (test.getVisibilidade()) {
                        testes.add(test);
                    }
                }
                List<questionarioinicial> questionarios = t.getQuestionarios();
                List<questionarioinicial> quest = new ArrayList<>();
                for (questionarioinicial q : questionarios) {
                    if (q.isVisibilidade()) {
                        quest.add(q);
                    }
                }
                mv.addObject("testes", testes);
                mv.addObject("turma", t);
                mv.addObject("questionarios", quest);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("erro", "Erro na busca dos testes ou questionarios da turma");
            }

        } else {
            redirectAttributes.addFlashAttribute("erro", "Turma não encontrada");

        }
        return mv;
    }

    /* Mostra os testes da turma */
    @GetMapping("/index/turma/{turmaId}/testes")
    public ModelAndView getTestesTurma(@PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("testesTurma");
        try {
            testeService.atualizarVisibilidades(); /* Teste de disponibilidade */
            List<teste> testes = testeRepository.findAll();
            List<teste> testesTurma = testeRepository.findByTurmas(turmaRepository.findById(turmaId).get());
            mv.addObject("testesAll", testes);
            mv.addObject("testesTurma", testesTurma);
            mv.addObject("turmaId", turmaId);
        } catch (Exception e) {

        }
        return mv;
    }

    /* Inclui os testes selecionados na turma */
    @PostMapping("/index/turma/{turmaId}/testes")
    public String setTestesTurma(@PathVariable("turmaId") int turmaId, turmaTestesForm testesTurma,
            RedirectAttributes redirectAttributes) {
        try {

            turma turma = turmaRepository.findById(turmaId).get();
            turma.getTestes().clear();
            if (testesTurma.getTestes() != null && testesTurma.getTestes().size() > 0) {
                for (teste test : testesTurma.getTestes()) {
                    if (test.getTesteId() > 0) {
                        turma.getTestes().add(testeRepository.findById(test.getTesteId()).get());
                    }
                }
            }
            turmaRepository.save(turma);
            redirectAttributes.addFlashAttribute("sucesso", "Testes Alterados da turma!");
            return "redirect:/index/turma/{turmaId}/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro",
                    "Ocorreu um erro e os testes não foram alterados: " + e.toString());
            return "redirect:/index/turmas";
        }
    }

    /* Listar os questionarios da turma */
    @GetMapping("/index/turma/{turmaId}/questionarios")
    public ModelAndView getQuestionariosTurma(@PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("questionariosTurma");
        try {
            questionarioinicialService.atualizarVisibilidade();
            List<questionarioinicial> quests = questionarioinicialRepository.findAll();
            List<questionarioinicial> questsTurma = questionarioinicialRepository
                    .findByTurmas(turmaRepository.findById(turmaId).get());
            mv.addObject("questsAll", quests);
            mv.addObject("questsTurma", questsTurma);
            mv.addObject("turmaId", turmaId);
        } catch (Exception e) {

        }
        return mv;
    }

    /* Inclui os questionarios selecionados na turma */
    @PostMapping("/index/turma/{turmaId}/questionarios")
    public String setQuestionariosTurma(@PathVariable("turmaId") int turmaId, turmaQuestsForm questsTurma,
            RedirectAttributes redirectAttributes) {
        try {
            turma turma = turmaRepository.findById(turmaId).get();
            turma.getQuestionarios().clear();
            if (questsTurma.getQuestionarios() != null && questsTurma.getQuestionarios().size() > 0) {
                for (questionarioinicial quest : questsTurma.getQuestionarios()) {
                    if (quest.getQuestionarioId() > 0) {

                        turma.getQuestionarios()
                                .add(questionarioinicialRepository.findById(quest.getQuestionarioId()).get());
                    }
                }
            }
            turmaRepository.save(turma);
            redirectAttributes.addFlashAttribute("sucesso", "Questionarios da turma alterados!");
            return "redirect:/index/turma/{turmaId}/questionarios";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro",
                    "Ocorreu um erro e os questionarios não foram alterados: " + e.toString());
            return "redirect:/index/turma/{turmaId}/questionarios";
        }

    }
}
