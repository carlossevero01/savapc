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

import jakarta.validation.Valid;

@Controller 
public class usuarioController {
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    testeRepository testeRepository;

     /* DELETAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping(value = "/index/deletealuno/{id}")
    public String deleteUsuario(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            usuario a = usuarioRepository.findById(id).get();
            usuarioRepository.delete(a);
            
            attributes.addFlashAttribute("sucesso", "Usuário deletado");
            return "redirect:/index/alunos";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", e.toString());
            return "redirect:/index/alunos";
       }
    }

    
     /* DELETAR UNIDADE(PROFESSORES/ADMIN) */

    /* CADASTRAR UNIDADE(PROFESSORES/ADMIN) */
    @GetMapping("/index/saveAluno")
    public String getSaveAluno() {
        return "saveAluno";
    }

    @PostMapping("/index/saveAluno")
    public String saveAluno(@Valid usuario a, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + a.toString());
            return "redirect:/index/saveAluno";
        }
        usuarioRepository.save(a);
        attributes.addFlashAttribute("sucesso", "Aluno cadastrado");
        return "redirect:/index/alunos";
    }

    
    /* CADASTRAR UNIDADE(PROFESSORES/ADMIN) */

    /* LISTAR DADOS(PROFESSORES/ADMIN) */
    @GetMapping(value = "/index/alunos")
    public ModelAndView listarAlunos() {
        ModelAndView mv = new ModelAndView("aluno");
        List<usuario> list = usuarioRepository.findByTipoLike("aluno");
        mv.addObject("alunos", list);
        return mv;
    } 

    
    
    /* LISTAR DADOS(PROFESSORES/ADMIN) */
    
    @GetMapping("/index/updatealuno/{id}")
    public ModelAndView getUpdateAluno(@PathVariable("id") int alunoId){
        ModelAndView mv = new ModelAndView("updateAluno");
        if(usuarioRepository.existsById(alunoId)){
            usuario a = usuarioRepository.findById(alunoId).get();
            mv.addObject("aluno", a);
        }
        return mv;
    }
    @PostMapping("/index/updatealuno/{id}")
    public String setUpdateAluno(@PathVariable("id") int alunoId, @Valid usuario novoAluno, RedirectAttributes redirectAttributes,@RequestParam("file") MultipartFile img){
        if(usuarioRepository.existsById(alunoId)){
            if(!img.isEmpty()){
            try {
                byte[] bytes = img.getBytes();
                Path caminho = Paths.get("./src/main/resources/static/images/"+img.getOriginalFilename());
                Files.write(caminho,bytes);
                novoAluno.setImg(img.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            novoAluno.setImg("não selecionado");
        }
            usuario alunoExistente = usuarioRepository.findById(alunoId).get();
            alunoExistente.setNome(novoAluno.getNome());
            alunoExistente.setTipo(novoAluno.getTipo());
            alunoExistente.setIdentificador(novoAluno.getIdentificador());
            alunoExistente.setEmail(novoAluno.getEmail());
            alunoExistente.setDataNascimento(novoAluno.getDataNascimento());
            alunoExistente.setTelefone(novoAluno.getTelefone());
            alunoExistente.setUsername(novoAluno.getUsername());
            alunoExistente.setPassword(new BCryptPasswordEncoder().encode(novoAluno.getPassword()));
            usuarioRepository.save(alunoExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Aluno editado com sucesso");
            return "redirect:/index/alunos";
        }
        redirectAttributes.addFlashAttribute("erro", "Não foi possivel salvar");
        return "redirect:/index/alunos";
    }

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
}
