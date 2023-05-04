package com.ifsul.sistema.computacional.sistematcc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;

import jakarta.validation.Valid;

@Controller
public class perguntaController {
    @Autowired
    perguntaRepository perguntaRepository;
    @Autowired
    testeRepository testeRepository;
    /* Listar perguntas */
    @GetMapping(value = "/index/perguntas")
    public ModelAndView listarPerguntas() {
        ModelAndView mv = new ModelAndView("pergunta");
        List<pergunta> list = perguntaRepository.findAll();
        mv.addObject("perguntas", list);
        return mv;
    }
    /*Salvar Pergunta por teste id */
    @GetMapping("/index/teste/savePergunta/{id}")
    public ModelAndView getSavePergunta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("savePergunta");
        mv.addObject("testeId", id);
        return mv;
    }
    /*Salvar pergunta por teste id */
    @PostMapping("/index/teste/savePergunta/{id}")
    // @Transactional
    public String savePergunta(@PathVariable("id") int testeId, @Valid pergunta pergunta,
            @RequestParam("file") MultipartFile img, RedirectAttributes attributes, BindingResult result) {
        teste t = testeRepository.findById(testeId).orElseThrow(null);
        List<pergunta> lperg = t.getPerguntas();
        System.out.println(pergunta.getDescricao());

        try {
            if (!img.isEmpty()) {
                try {
                    byte[] bytes = img.getBytes();
                    Path caminho = Paths.get("./src/main/resources/static/images/" + img.getOriginalFilename());
                    Files.write(caminho, bytes);
                    pergunta.setImg(img.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                pergunta.setImg(null);
            }
            perguntaRepository.save(pergunta);
            lperg.add(pergunta);
            t.setPerguntas(lperg);
            testeRepository.save(t);
            attributes.addFlashAttribute("sucesso", "Pergunta cadastrada");
            return "redirect:/index/teste/perguntas/{id}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", e.toString());
            return "redirect:/index/teste/perguntas/{id}";
        }
    }
    /*Deletar pergunta por id */
    @GetMapping(value = "/index/deletepergunta/{testeId}/{perguntaId}")
    public String deletePergunta(@PathVariable("testeId") int testeId, @PathVariable("perguntaId") int perguntaId, RedirectAttributes attributes) {
        try {
            if(testeRepository.existsById(testeId)){ //Deletar da tabela perguntasteste
                if(perguntaRepository.existsById(perguntaId)){
                    teste t = testeRepository.findById(testeId).get();
                    List<pergunta> lp = t.getPerguntas();
                    for(int i=0;i<lp.size();i++){
                        if(lp.get(i).getPerguntaId()==perguntaId){
                            lp.remove(i);
                        }
                    }
                    t.setPerguntas(lp);
                    testeRepository.save(t);
                    attributes.addFlashAttribute("sucesso", "Pergunta deletada");
                return "redirect:/index/teste/perguntas/{testeId}";
                }else{
                    attributes.addFlashAttribute("erro","Pergunta não encontrada");
                    return "redirect:/index/teste/perguntas/{testeId}";
                }
            }else{ //Deletar do repository
                perguntaRepository.deleteById(perguntaId);
                attributes.addFlashAttribute("sucesso", "Pergunta deletada");
                return "redirect:/index/perguntas";
            }
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/perguntas";
        }
    }

    /*Perguntas por teste */
    @GetMapping(value = "/index/teste/perguntas/{id}")
    public ModelAndView getPerguntasPorTeste(@PathVariable("id") int testeId) {
        ModelAndView mv = new ModelAndView("pergunta");
        teste t = testeRepository.findById(testeId).orElseThrow(null);
        mv.addObject("testeId", t.getTesteId());
        mv.addObject("testeNome", t.getNome());
        mv.addObject("perguntas", t.getPerguntas());
        return mv;
    }
    
    @GetMapping("/index/updatepergunta/{id}")
    @ResponseBody
    public ModelAndView getPerguntaUpdate(@PathVariable("id") int perguntaId) {
        ModelAndView mv = new ModelAndView("updatePergunta");
        try {
            pergunta perguntaExistente = perguntaRepository.findById(perguntaId).orElseThrow(null);
            mv.addObject("pergunta", perguntaExistente);
        } catch (Exception e) {
            System.out.println("ERRO SISTEMA:" + e);
        }
        return mv;
    }

    @PostMapping("/index/updatepergunta/{id}")
    public String setPerguntaUpdate(@PathVariable("id") int perguntaId, @Valid pergunta novaPergunta,
            RedirectAttributes redirectAttributes, BindingResult result, @RequestParam("file") MultipartFile img) {
        try {
            pergunta perguntaExistente = perguntaRepository.findById(perguntaId).orElseThrow(null);
            perguntaExistente.setDescricao(novaPergunta.getDescricao());

            if (img.isEmpty()) {
                novaPergunta.setImg(null);
            } else {
                byte[] bytes = img.getBytes();
                Path caminho = Paths.get("./src/main/resources/static/images/" + img.getOriginalFilename());
                Files.write(caminho, bytes);
                perguntaExistente.setImg(img.getOriginalFilename());
            }
            perguntaRepository.save(perguntaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Pergunta Editada com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/testes";

        }
    }
}