package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.service.usuarioService;

import jakarta.validation.Valid;

@Controller
public class usuarioController {
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    usuarioService usuarioService;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    testeRepository testeRepository;

    /* DELETAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping(value = "/index/deleteusuario/{id}")
    public String deleteUsuario(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            usuario a = usuarioRepository.findById(id).get();
            usuarioRepository.delete(a);
            if (a.getTipo().equalsIgnoreCase("aluno")) {
                attributes.addFlashAttribute("sucesso", "Usuário deletado");
                return "redirect:/index/alunos";
            } else {
                attributes.addFlashAttribute("sucesso", "Usuário deletado");
                return "redirect:/index/professores";
            }
        } catch (Exception e) {
            usuario a = usuarioRepository.findById(id).get();
            if (a.getTipo().equalsIgnoreCase("aluno")) {
                attributes.addFlashAttribute("erro", e.toString());
                return "redirect:/index/alunos";
            } else {
                attributes.addFlashAttribute("erro", e.toString());
                return "redirect:/index/professores";
            }

        }
    }

    /* CADASTRAR (PROFESSORES/ADMIN) */
    @PostMapping("/index/saveUsuario")
    public String saveAluno(@Valid usuario a, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            if (a.getTipo().equalsIgnoreCase("aluno")) {
                attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + a.toString());
                return "redirect:/index/alunos";
            } else {
                attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + a.toString());
                return "redirect:/index/professores";
            }

        }
        usuarioService.save(a);
        if (a.getTipo().equalsIgnoreCase("aluno")) {
            attributes.addFlashAttribute("sucesso", "Aluno cadastrado");
            return "redirect:/index/alunos";
        } else {
            attributes.addFlashAttribute("sucesso", "Professor cadastrado");
            return "redirect:/index/professores";
        }

    }

    /* LISTAR (PROFESSORES/ALUNOS) */
    @GetMapping(value = "/index/alunos")
    public ModelAndView listarAlunos() {
        ModelAndView mv = new ModelAndView("aluno");
        List<usuario> list = usuarioRepository.findByTipoLike("aluno");
        mv.addObject("alunos", list);
        return mv;
    }

    @GetMapping(value = "/index/professores")
    public ModelAndView listarProfessores() {
        ModelAndView mv = new ModelAndView("professor");
        List<usuario> list = usuarioRepository.findByTipoLike("prof");
        mv.addObject("profs", list);
        return mv;
    }

    /* Atualizar usuario */
    @PostMapping("/index/updateusuario/{id}")
    public String setUpdateAluno(@PathVariable("id") int usuarioId, @Valid usuario novo,
            RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile img) {
        if (usuarioRepository.existsById(usuarioId)) {
            if (!img.isEmpty()) {
                try {
                    byte[] bytes = img.getBytes();
                    Path caminho = Paths.get("./src/main/resources/static/images/" + img.getOriginalFilename());
                    Files.write(caminho, bytes);
                    novo.setImg(img.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                novo.setImg("não selecionado");
            }
            usuario Existente = usuarioRepository.findById(usuarioId).get();
            Existente.setNome(novo.getNome());
            Existente.setTipo(novo.getTipo());
            Existente.setIdentificador(novo.getIdentificador());
            Existente.setEmail(novo.getEmail());
            Existente.setDataNascimento(novo.getDataNascimento());
            Existente.setTelefone(novo.getTelefone());
            Existente.setUsername(novo.getUsername());
            Existente.setPassword(new BCryptPasswordEncoder().encode(novo.getPassword()));
            usuarioService.save(Existente);
            if (Existente.getTipo().equalsIgnoreCase("aluno")) {
                redirectAttributes.addFlashAttribute("sucesso", "Aluno editado com sucesso");
                return "redirect:/index/alunos";
            } else {
                redirectAttributes.addFlashAttribute("sucesso", "Professor editado com sucesso");
                return "redirect:/index/professores";
            }

        }
        redirectAttributes.addFlashAttribute("erro", "Não foi possivel salvar");
        if (novo.getTipo().equalsIgnoreCase("aluno")) {
            return "redirect:/index/alunos";
        } else {
            return "redirect:/index/professores";
        }

    }

    /* Exibir painel do professor */
    @GetMapping("/painelgeral")
    public ModelAndView getPainelGeral() {
        ModelAndView mv = new ModelAndView("PainelGeral");
        try {
            if (turmaRepository.count() > 0) {
                List<turma> turmas = turmaRepository.findAll();
                mv.addObject("turmas", turmas);
            }
            if (testeRepository.count() > 0) {
                List<teste> testes = testeRepository.findAll();
                mv.addObject("testes", testes);
            }

            return mv;
        } catch (Exception e) {
            return mv;
        }
    }
}
