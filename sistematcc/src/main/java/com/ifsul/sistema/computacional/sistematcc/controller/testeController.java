package com.ifsul.sistema.computacional.sistematcc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.perguntasForm;
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.respostaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.testeForm;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaTesteRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.testeService;

import jakarta.validation.Valid;

@Controller
public class testeController {
    @Autowired
    testeRepository testeRepository;
    @Autowired
    testeService testeService;
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    perguntaTesteRepository perguntaTesteRepository;
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    turmaRepository turmaRepository;

    /* Atualiza teste */
    @PostMapping("/index/updateteste/{id}")
    public String setTesteUpdate(@PathVariable("id") int testeId, @Valid teste novoteste,
            RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "Confira os campos obrigatórios" + result);
            return "redirect:/index/updateteste/{id}";
        }
        try {
            teste testeExistente = testeRepository.findById(testeId).orElseThrow(null);
            testeExistente.setDisponibilidade(novoteste.getDisponibilidade());
            testeExistente.setNome(novoteste.getNome());
            testeExistente.setVisibilidade(novoteste.getVisibilidade());
            testeRepository.save(testeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Teste alterado com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel executar" + e);
            return "redirect:/index/testes";
        }
    }

    /* Atualiza teste na turma */
    @PostMapping("/index/updateteste/{id}/{turmaId}")
    public String setTesteUpdate_turma(@PathVariable("id") int testeId, @Valid teste novoteste,
            RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("erro", "Confira os campos obrigatórios" + result);
            return "redirect:/index/turma/{turmaId}/testes";
        }
        try {
            teste testeExistente = testeRepository.findById(testeId).orElseThrow(null);
            testeExistente.setDisponibilidade(novoteste.getDisponibilidade());
            testeExistente.setNome(novoteste.getNome());
            testeExistente.setVisibilidade(novoteste.getVisibilidade());
            testeRepository.save(testeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Teste alterado com sucesso");
            return "redirect:/index/turma/{turmaId}/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel executar" + e);
            return "redirect:/index/turma/{turmaId}/testes";
        }
    }

    /* Verifica se o aluno já respondeu ao teste */
    @PostMapping(value = "/index/aplicacao/{turmaId}/{testeId}")
    public String verificarAplicacao(@RequestParam("username") String username, @PathVariable("testeId") int tId,
            @PathVariable("turmaId") int turmaId, RedirectAttributes redirectAttributes) {
        try {
            usuario u = usuarioRepository.findByUsername(username);
            teste t = testeRepository.findById(tId).get();
            turma tu = turmaRepository.findById(turmaId).get();
            if (regTestesRepository.findByTesteAndTurmaAndUsuario(t, tu, u).isEmpty()) {
                return "redirect:/index/aplicacaoteste/{turmaId}/{testeId}";
            } else {
                redirectAttributes.addFlashAttribute("erro", "Tentativa já realizada");
                return "redirect:/index/turma/{turmaId}";
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro desconhecido:" + e.toString());
            return "redirect:/index/turma/{turmaId}";
        }
    }

    /* Aplicar teste */
    @GetMapping(value = "/index/aplicacaoteste/{turmaId}/{testeId}")
    public ModelAndView getTesteAplication(@PathVariable("testeId") int tId, @PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("aplicacaoTeste");

        teste t = testeRepository.findById(tId).get();
        turma turma = turmaRepository.findById(turmaId).get();
        List<perguntaTeste> perguntas = t.getPerguntasTeste();
        mv.addObject("perguntas", perguntas);
        mv.addObject("testeNome", t.getNome());
        mv.addObject("testeId", t.getTesteId());
        mv.addObject("turmaId", turma.getTurmaId());
        return mv;

    }

    /* Aplicar teste por id */
    @PostMapping(value = "/index/aplicacaoteste/{turmaId}/{testeId}")
    public String setTesteAplication(@PathVariable("testeId") int testeId, @PathVariable("turmaId") int turmaId,
            @ModelAttribute perguntasForm lresp,
            RedirectAttributes attributes) {
        // try {
        turma turma = turmaRepository.findById(turmaId).get();
        teste t = testeRepository.findById(testeId).orElseThrow(null);
        LocalDate agora = LocalDate.now();
        if (agora.isAfter(t.getDisponibilidade())) {
            attributes.addFlashAttribute("erro", "O teste não está mais disponível para responder");
            return "redirect:/index/turma/{turmaId}";
        }
        usuario u = usuarioRepository.findByUsername(lresp.getUsername());
        List<respostaTeste> ListRespostas = new ArrayList<>();
        regTestes reg = new regTestes();
        if (u != null) {
            for (perguntaTeste Pergunta : lresp.getPerguntas()) {

                respostaTeste resposta = new respostaTeste();
                perguntaTeste p = perguntaTesteRepository.findById(Pergunta.getPerguntaTesteId()).orElseThrow(null);
                resposta.setperguntaTeste(p);
                if (Pergunta.getOpRespostaId() != null) {
                    resposta.setOpRespostaId(Integer.valueOf(Pergunta.getOpRespostaId()));
                } else {
                    resposta.setOpRespostaId(0);
                }

                ListRespostas.add(resposta);
            }
            reg.setUsuario(u);
            reg.setTeste(t);
            reg.setTurma(turma);
            reg.setRespostasTeste(ListRespostas);
            if (regTestesRepository.findByTesteAndTurmaAndUsuario(t, turma, u).size() <= 0) {
                regTestesRepository.save(reg);
            } else {
                attributes.addFlashAttribute("erro", "O usuario ja realizou uma tentativa");
                return "redirect:/index/turma/{turmaId}";
            }

            attributes.addFlashAttribute("sucesso", "Teste Respondido com sucesso");
            return "redirect:/index/turma/{turmaId}";
        } else {
            attributes.addFlashAttribute("erro", "Matricula não encontrada");
            return "redirect:/index/turma/{turmaId}";
        }
        // } catch (Exception e) {
        // attributes.addFlashAttribute("erro", "erro desconhecido"+e);
        // return "redirect:/index/turma/{turmaId}";
        // }
    }

    /* Listar testes */
    @GetMapping(value = "/index/testes")
    public ModelAndView listarTestes() {
        ModelAndView mv = new ModelAndView("teste");
        try {
            testeService.atualizarVisibilidades(); /* Teste de disponibilidade */
        } catch (Exception e) {

        }
        List<teste> list = testeRepository.findAll();
        mv.addObject("testes", list);
        List<perguntaTeste> lperguntas = perguntaTesteRepository.findAll();
        mv.addObject("perguntas", lperguntas);
        return mv;
    }

    /* Salvar um novo teste */
    @PostMapping("/index/saveTeste")
    public String saveTeste(@Valid testeForm t, BindingResult result, RedirectAttributes attributes) {
        List<perguntaTeste> ListPerguntas = new ArrayList<>();
        teste test = new teste();
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTeste";
        } else {
            try {
                if (t.getPerguntas() != null) {
                    for (perguntaTeste perg : t.getPerguntas()) {
                        if (perguntaTesteRepository.existsById(perg.getPerguntaTesteId())) {
                            perguntaTeste p = perguntaTesteRepository.findById(perg.getPerguntaTesteId())
                                    .orElseThrow(null);
                            ListPerguntas.add(p);
                        }
                    }
                    test = new teste(t.isVisibilidade(), t.getNome(), t.getDisponibilidade(), ListPerguntas);

                } else {
                    test = new teste(t.isVisibilidade(), t.getNome(), t.getDisponibilidade(), null);
                }

                testeRepository.save(test);
                attributes.addFlashAttribute("sucesso", "Teste cadastrado");
                return "redirect:/index/testes";
            } catch (Exception e) {
                attributes.addFlashAttribute("erro", "Não foi possível cadastrar essas perguntas" + e.toString());
                return "redirect:/index/testes";
            }
        }
    }

    /* Salvar um novo teste na turma */
    @PostMapping("/index/turma/{turmaId}/saveTeste")
    public String saveTeste_turma(@Valid testeForm t, BindingResult result, RedirectAttributes attributes) {
        List<perguntaTeste> ListPerguntas = new ArrayList<>();
        teste test = new teste();
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/turma/{turmaId}/testes";
        } else {
            try {
                if (t.getPerguntas() != null) {
                    for (perguntaTeste perg : t.getPerguntas()) {
                        if (perguntaTesteRepository.existsById(perg.getPerguntaTesteId())) {
                            perguntaTeste p = perguntaTesteRepository.findById(perg.getPerguntaTesteId())
                                    .orElseThrow(null);
                            ListPerguntas.add(p);
                        }
                    }
                    test = new teste(t.isVisibilidade(), t.getNome(), t.getDisponibilidade(), ListPerguntas);
                } else {
                    test = new teste(t.isVisibilidade(), t.getNome(), t.getDisponibilidade(), null);
                }
                testeRepository.save(test);
                attributes.addFlashAttribute("sucesso", "Teste cadastrado");
                return "redirect:/index/turma/{turmaId}/testes";
            } catch (Exception e) {
                attributes.addFlashAttribute("erro", "Não foi possível cadastrar essas perguntas" + e.toString());
                return "redirect:/index/turma/{turmaId}/testes";
            }
        }
    }

    /* Deletar teste por id */
    @GetMapping(value = "/index/deleteteste/{id}")
    public String deleteTeste(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            testeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Teste deletado");
            return "redirect:/index/testes";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido" + e.toString());
            return "redirect:/index/testes";
        }
    }

}
