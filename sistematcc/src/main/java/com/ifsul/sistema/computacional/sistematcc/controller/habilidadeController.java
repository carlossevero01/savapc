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

import com.ifsul.sistema.computacional.sistematcc.model.habForm;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaRepository;

import jakarta.validation.Valid;

@Controller
public class habilidadeController {
    @Autowired
    habilidadeRepository habilidadeRepository;
    @Autowired
    perguntaRepository perguntaRepository;

    @GetMapping(value = "/listarHabilidades") // @RequestMapping(value = "/listarCandidatos", method = // RequestMethod.GET)
    @ResponseBody // @ResponseBody permite retornar um texto
    public List<habilidade> getHabilidades() {
        System.out.println("listar habilidades ");
        return habilidadeRepository.findAll();
    }

    @GetMapping(value = "/index/deletehabilidade/{id}")
    public String deleteHabilidade(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            habilidadeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Habilidade deletada");
            return "redirect:/index/habilidades";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "id inexistente ou erro desconhecido");
            return "redirect:/index/habilidades";
        }
    }
    
    @GetMapping("/index/saveHabilidade")
    public String getSaveHabilidade() {
        return "saveHabilidade";
    }

    @PostMapping("/index/saveHabilidade")
    public String saveHabilidade(@Valid habilidade h, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + h.toString());
            return "redirect:/index/saveHabilidade";
        }
        habilidadeRepository.save(h);
        attributes.addFlashAttribute("sucesso", "Habilidade cadastrada");
        return "redirect:/index/habilidades";
    }

    @GetMapping(value = "/index/habilidades")
    public ModelAndView listarHabilidades() {
        ModelAndView mv = new ModelAndView("habilidade");
        List<habilidade> list = habilidadeRepository.findAll();
        mv.addObject("habilidades", list);
        return mv;
    }

    @GetMapping("/index/updatehabilidade/{id}")
    @ResponseBody
    public ModelAndView getHabilidadeUpdate(@PathVariable("id") int habilidadeId) {
        ModelAndView mv = new ModelAndView("updateHabilidade");
        try {
            habilidade hab = habilidadeRepository.findById(habilidadeId).orElseThrow(null);
            mv.addObject("habilidade", hab);
        } catch (Exception e) {
            System.out.println("ERRO" + e);
        }
        return mv;
    }

    @PostMapping("/index/updatehabilidade/{id}")
    public String setHabilidadeUpdate(@PathVariable("id") int habilidadeId, @Valid habilidade novahabilidade,
            RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            habilidade habilidadeExistente = habilidadeRepository.findById(habilidadeId).orElseThrow(null);
            habilidadeExistente.setNome(novahabilidade.getNome());
            habilidadeRepository.save(habilidadeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Habilidade Editada com sucesso");
            return "redirect:/index/testes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/testes";

        }
    }

    @GetMapping("/index/pergunta/habilidades/{perguntaId}/{testeId}")
    @ResponseBody
    public ModelAndView getHabilidadesPergunta(@PathVariable("perguntaId") int perguntaId,
            @PathVariable("testeId") int testeId) {
        ModelAndView mv = new ModelAndView("habilidade");
        List<habilidade> habilidadesAll = habilidadeRepository.findAll();
        mv.addObject("habilidades", habilidadesAll);
        mv.addObject("perguntaId", perguntaId);
        mv.addObject("testeId", testeId);
        return mv;
    }

    @PostMapping("/index/pergunta/habilidades/{perguntaId}/{testeId}")
    public String setHabilidadePergunta(@PathVariable("perguntaId") int perguntaId,
            @PathVariable("testeId") int testeId, habForm lhab, RedirectAttributes attributes) {
        try {
            pergunta p = perguntaRepository.findById(perguntaId).get();
            List<habilidade> habpergunta = new ArrayList<>();
            p.getHabilidades().clear();
            if(lhab.getHabilidades()!=null){
                for (habilidade h : lhab.getHabilidades()) {
                    if(h.getHabilidadeId()>0) {
                        habpergunta.add(habilidadeRepository.findById(h.getHabilidadeId()).get());
                        System.out.println("TESTEEEEEEEEE: "+ h.getHabilidadeId());
                    }
                
                }
                p.setHabilidades(habpergunta);
            }
            
            perguntaRepository.save(p);
            attributes.addFlashAttribute("sucesso", "habilidades do teste atualizado!");
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Nao foi possivel alterar as habilidades"+e.toString());
            return "redirect:/index/teste/perguntas/{testeId}";
        }
    }
}
