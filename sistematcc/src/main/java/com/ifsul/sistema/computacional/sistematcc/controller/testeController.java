package com.ifsul.sistema.computacional.sistematcc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntasForm;
import com.ifsul.sistema.computacional.sistematcc.model.registro;
import com.ifsul.sistema.computacional.sistematcc.model.resposta;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.testeForm;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.registroRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;

import jakarta.validation.Valid;

@Controller
public class testeController {
    @Autowired
    testeRepository testeRepository;
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    perguntaRepository perguntaRepository;
    @Autowired
    registroRepository registroRepository;

    /*Atualizar teste por id */
    @GetMapping("/index/updateteste/{id}")
    @ResponseBody
    public ModelAndView getTesteUpdate(@PathVariable("id") int testeId) {
        ModelAndView mv = new ModelAndView("updateTeste");
        try {
            teste testeExistente = testeRepository.findById(testeId).orElseThrow(null);
            mv.addObject("teste", testeExistente);
        } catch (Exception e) {
            System.out.println("ERRO SISTEMA:" + e);
        }
        return mv;
    }
    /*Atualizar teste por id */
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
            testeExistente.setPeso(Double.valueOf(novoteste.getPeso()));
            testeRepository.save(testeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Teste alterado com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel executar" + e);
            return "redirect:/index/testes";
        }
    }
    /*Aplicar teste por id */
    @GetMapping(value = "/index/aplicacaoteste/{id}")
    public ModelAndView getTesteAplication(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("aplicacaoTeste");

        teste t = testeRepository.findById(id).orElseThrow(null);

        List<pergunta> perguntas = t.getPerguntas();
        mv.addObject("perguntas", perguntas);
        mv.addObject("testeNome", t.getNome());
        mv.addObject("testeId", t.getTesteId());
        return mv;

    }
    /*Aplicar teste por id */
    @PostMapping(value = "/index/aplicacaoteste/{id}")
    public String setTesteAplication(@PathVariable("id") int testeId, @ModelAttribute perguntasForm lresp,
            RedirectAttributes attributes) {
        try {
            teste t = testeRepository.findById(testeId).orElseThrow(null);
        List<resposta> ListRespostas = new ArrayList<>();
        registro reg = new registro();
        if (alunoRepository.findByMatricula(lresp.getMatricula().trim()).size()>0) {
            for (pergunta Pergunta : lresp.getPerguntas()) {
                resposta resposta = new resposta();
                pergunta p = perguntaRepository.findById(Pergunta.getPerguntaId()).orElseThrow(null);
                resposta.setPergunta(p);
                resposta.setOpRespostaId(Integer.valueOf(Pergunta.getOpRespostaId()));
                ListRespostas.add(resposta);
            }
            reg.setAluno(alunoRepository.findByMatricula(lresp.getMatricula()).get(0));
            reg.setTeste(t);
            reg.setRespostas(ListRespostas);
            registroRepository.save(reg);
            attributes.addFlashAttribute("sucesso", "Teste Respondido com sucesso");
            return "redirect:/index/inicial";
        }else{ 
            attributes.addFlashAttribute("erro", "Matricula não encontrada");
            return "redirect:/index/inicial";
        }
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Teste não foi respondido com sucesso"+e);
            return "redirect:/index/inicial";
        }
    }
    /*Listar testes */
    @GetMapping(value = "/index/testes")
    public ModelAndView listarTestes() {
        ModelAndView mv = new ModelAndView("teste");
        List<teste> list = testeRepository.findAll();
        mv.addObject("testes", list);
        return mv;
    }
    /*Salvar um novo teste */
    @GetMapping("/index/saveTeste")
    public ModelAndView getSaveTeste() {
        ModelAndView mv = new ModelAndView("saveTeste");
        List<pergunta> lperguntas = perguntaRepository.findAll();
        mv.addObject("perguntas", lperguntas);
        return mv;
    }
    /*Salvar um novo teste */
    @PostMapping("/index/saveTeste")
    public String saveTeste(@Valid testeForm t, BindingResult result, RedirectAttributes attributes) {
        List<pergunta> ListPerguntas = new ArrayList<>();
        teste test = new teste();
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTeste";
        }else{
        try {
            if(t.getPerguntas()!=null){
                for (pergunta perg : t.getPerguntas()) {
                    if(perguntaRepository.existsById(perg.getPerguntaId())){
                        pergunta p = perguntaRepository.findById(perg.getPerguntaId()).orElseThrow(null);
                        ListPerguntas.add(p);
                    }
                }
                test = new teste(t.isVisibilidade(), t.getNome(),t.getDisponibilidade(),ListPerguntas);
            }else{
               test = new teste(t.isVisibilidade(), t.getNome(),t.getDisponibilidade(),null);
            }
            
            testeRepository.save(test);
            attributes.addFlashAttribute("sucesso", "Teste cadastrado");
            return "redirect:/index/testes";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Não foi possível cadastrar essas perguntas"+e.toString());
        return "redirect:/index/testes";
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
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido"+ e.toString());
            return "redirect:/index/testes";
        }
    }
}