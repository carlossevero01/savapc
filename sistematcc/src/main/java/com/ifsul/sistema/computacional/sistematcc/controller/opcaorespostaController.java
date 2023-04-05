package com.ifsul.sistema.computacional.sistematcc.controller;

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

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;

import jakarta.validation.Valid;

@Controller
public class opcaorespostaController {
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    perguntaRepository perguntaRepository;

    @GetMapping("/index/updateopcaoresposta/{id}")
    @ResponseBody
    public ModelAndView getOpcaoRespostaUpdate(@PathVariable("id") int opcaoRespostaId) {
        ModelAndView mv = new ModelAndView("updateOpcaoresposta");
        try {
            opcaoresposta op = opcaorespostaRepository.findById(opcaoRespostaId).orElseThrow(null);
            mv.addObject("opcaoresposta", op);
        } catch (Exception e) {
            System.out.println("ERRO:" + e);
        }
        return mv;
    }

    @PostMapping("/index/updateopcaoresposta/{id}")
    public String setOpcaoRespostaUpdate(@PathVariable("id") int opcaoRespostaId,
            @Valid opcaoresposta novaOpcaoresposta, RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            opcaoresposta opcaorespostaExistente = opcaorespostaRepository.findById(opcaoRespostaId).orElseThrow(null);
            opcaorespostaExistente.setTipo(novaOpcaoresposta.getTipo());
            opcaorespostaExistente.setDescricao(novaOpcaoresposta.getDescricao());
            opcaorespostaExistente.setVerdadeira(novaOpcaoresposta.isVerdadeira());
            opcaorespostaRepository.save(opcaorespostaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "OpcaoResposta Editada com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/testes";

        }
    }

    @GetMapping(value = "/index/pergunta/opcoesresposta/{id}")
    public ModelAndView getOpcoesRespostaPergunta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("opcaoresposta");
        pergunta p = perguntaRepository.findById(id).orElseThrow(null);
        List<opcaoresposta> opR = p.getOpcoesResposta();
        mv.addObject("opcoesrespostas", opR);
        mv.addObject("perguntaId", p.getPerguntaId());
        return mv;
    }

    @GetMapping("/index/pergunta/saveopcaoresposta/{id}")
    public ModelAndView getSaveOpcaoResposta(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("saveOpcaoresposta");
        mv.addObject("perguntaId", id);
        return mv;
    }

    @PostMapping("/index/pergunta/saveopcaoresposta/{id}")
    public String saveOpcaoResposta(@PathVariable("id") int id, @Valid opcaoresposta or, BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + or.toString());
            return "redirect:/index/pergunta/saveopcaoresposta/{id}";
        }
        opcaorespostaRepository.save(or);
        pergunta p = perguntaRepository.findById(id).orElseThrow(null);
        List<opcaoresposta> listOR = p.getOpcoesResposta();
        listOR.add(or);
        p.setOpcoesResposta(listOR);
        perguntaRepository.save(p);
        attributes.addFlashAttribute("sucesso", "Turma cadastrada");
        return "redirect:/index/pergunta/opcoesresposta/{id}";
    }

    @GetMapping(value = "/index/pergunta/deleteopcaoresposta/{id}")
    public String deleteOpcaoResposta(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            opcaorespostaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Opção-Resposta deletada");
            return "redirect:/index/pergunta/opcoesresposta/{id}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/pergunta/opcoesresposta/{id}";
        }
    }
}
