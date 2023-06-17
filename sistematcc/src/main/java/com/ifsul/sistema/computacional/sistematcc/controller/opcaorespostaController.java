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

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaTesteRepository;

import jakarta.validation.Valid;

@Controller
public class opcaorespostaController {
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    perguntaTesteRepository perguntaTesteRepository;

    /* Atualiza uma opção resposta de uma perguntaTeste */
    @PostMapping("/index/{perguntaId}/updateopcaoresposta/{id}")
    public String setOpcaoRespostaUpdate(@PathVariable("id") int opcaoRespostaId,
            @PathVariable("perguntaId") int perguntaTesteId,
            @Valid opcaoresposta novaOpcaoresposta, RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            opcaoresposta opcaorespostaExistente = opcaorespostaRepository.findById(opcaoRespostaId).orElseThrow(null);
            opcaorespostaExistente.setTipo(novaOpcaoresposta.getTipo());
            opcaorespostaExistente.setDescricao(novaOpcaoresposta.getDescricao());
            opcaorespostaExistente.setVerdadeira(novaOpcaoresposta.isVerdadeira());
            opcaorespostaRepository.save(opcaorespostaExistente);
            redirectAttributes.addFlashAttribute("sucesso", "OpcaoResposta Editada com sucesso");

            return "redirect:/index/perguntaTeste/opcoesresposta/{perguntaId}";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/updateopcaoresposta/{id}";

        }
    }

    /* Lista as opções resposta de uma perguntaTeste */
    @GetMapping(value = "/index/turma/{turmaId}/perguntaTeste/opcoesresposta/{id}")
    public ModelAndView getOpcoesRespostaPergunta(@PathVariable("id") int id,@PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("opcaoresposta");
        perguntaTeste p = perguntaTesteRepository.findById(id).orElseThrow(null);
        List<opcaoresposta> opR = p.getOpcoesResposta();
        mv.addObject("opcoesrespostas", opR);
        mv.addObject("perguntaId", p.getPerguntaTesteId());
        mv.addObject("turmaId", turmaId);
        return mv;
    }

    /* Salva uma opção resposta em uma perguntaTeste */
    @PostMapping("/index/perguntaTeste/saveopcaoresposta/{id}")
    public String saveOpcaoResposta(@PathVariable("id") int id, @Valid opcaoresposta or, BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + or.toString());
            return "redirect:/index/perguntaTeste/saveopcaoresposta/{id}";
        }
        opcaorespostaRepository.save(or);
        perguntaTeste p = perguntaTesteRepository.findById(id).orElseThrow(null);
        List<opcaoresposta> listOR = p.getOpcoesResposta();
        listOR.add(or);
        p.setOpcoesResposta(listOR);
        perguntaTesteRepository.save(p);
        attributes.addFlashAttribute("sucesso", "Opção resposta cadastrada");
        return "redirect:/index/perguntaTeste/opcoesresposta/{id}";
    }

    /* Deletar opçãoResposta de uma perguntaTeste */
    @GetMapping(value = "/index/perguntaTeste/{perguntaTesteId}/deleteopcaoresposta/{id}")
    public String deleteOpcaoResposta(@PathVariable("id") int id, @PathVariable("perguntaTesteId") int perguntaTesteId,
            RedirectAttributes attributes) {
        try {
            opcaorespostaRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Opção-Resposta deletada");
            return "redirect:/index/perguntaTeste/opcoesresposta/{perguntaTesteId}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "ID inexistente ou erro desconhecido");
            return "redirect:/index/perguntaTeste/opcoesresposta/{perguntaTesteId}";
        }
    }
}
