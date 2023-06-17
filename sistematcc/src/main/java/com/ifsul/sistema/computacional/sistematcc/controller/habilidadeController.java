package com.ifsul.sistema.computacional.sistematcc.controller;

import java.util.ArrayList;
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

import com.ifsul.sistema.computacional.sistematcc.model.habForm;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaTesteRepository;

import jakarta.validation.Valid;

@Controller
public class habilidadeController {
    @Autowired
    habilidadeRepository habilidadeRepository;
    @Autowired
    perguntaTesteRepository perguntaTesteRepository;

    /* Listar Habilidades */
    @GetMapping(value = "/index/habilidades")
    public ModelAndView listarHabilidades() {
        ModelAndView mv = new ModelAndView("habilidade");
        try {
            List<habilidade> list = habilidadeRepository.findAll();
            mv.addObject("habilidades", list);
            return mv;
        } catch (Exception e) {
            return mv;
        }
    }

    /* Deletar habilidade */
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

    /* Deletar Habilidade dentro de uma pergunta */
    @GetMapping(value = "/index/teste/{testeId}/pergunta/{perguntaId}/deletehabilidade/{id}")
    public String deleteHabilidade_Pergunta(@PathVariable("id") int id, RedirectAttributes attributes) {
        try {
            habilidadeRepository.deleteById(id);
            attributes.addFlashAttribute("sucesso", "Habilidade deletada");
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "id inexistente ou erro desconhecido");
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        }
    }

    /* Salvar uma nova habilidade */
    @PostMapping("/index/saveHabilidade")
    public String saveHabilidade(@Valid habilidade h, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + h.toString());
            return "redirect:/index/saveHabilidade";
        }
        try {
            habilidadeRepository.save(h);
            attributes.addFlashAttribute("sucesso", "Habilidade cadastrada");
            return "redirect:/index/habilidades";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Erro desconhecido!" + e.toString());
            return "redirect:/index/habilidades";// TODO: handle exception
        }
    }

    /* Salvar uma nova habilidade dentro de uma pergunta */
    @PostMapping("/index/{testeId}/{perguntaId}/saveHabilidade")
    public String saveHabilidade_Pergunta(@Valid habilidade h, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + h.toString());
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        }
        try {
            habilidadeRepository.save(h);
            attributes.addFlashAttribute("sucesso", "Habilidade cadastrada");
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Erro desconhecido!" + e.toString());
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";// TODO: handle exception
        }
    }

    /* Atualizar uma habilidade */
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

    /* Atualizar uma habilidade de dentro de uma pergunta */
    @PostMapping("/index/teste/{testeId}/pergunta/{perguntaId}/updatehabilidade/{id}")
    public String setHabilidadeUpdate_Pergunta(@PathVariable("id") int habilidadeId, @Valid habilidade novahabilidade,
            RedirectAttributes redirectAttributes, BindingResult result) {
        try {
            habilidade habilidadeExistente = habilidadeRepository.findById(habilidadeId).orElseThrow(null);
            habilidadeExistente.setNome(novahabilidade.getNome());
            habilidadeRepository.save(habilidadeExistente);
            redirectAttributes.addFlashAttribute("sucesso", "Habilidade Editada com sucesso");
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possivel editar" + e);
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";

        }
    }

    /* Ver habilidades de uma pergunta */
    @GetMapping("/index/turma/{turmaId}/pergunta/habilidades/{perguntaId}/{testeId}")
    @ResponseBody
    public ModelAndView getHabilidadesPergunta(@PathVariable("perguntaId") int perguntaId,
            @PathVariable("testeId") int testeId, @PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("habilidadePerguntaTeste");
        try {
            perguntaTeste p = perguntaTesteRepository.findById(perguntaId).get();
            List<habilidade> habilidadesAll = habilidadeRepository.findAll();
            List<habilidade> habilidadePergunta = habilidadeRepository.findByPerguntasTeste(p);
            mv.addObject("habilidades", habilidadesAll);
            mv.addObject("perguntaId", perguntaId);
            mv.addObject("testeId", testeId);
            mv.addObject("turmaId", turmaId);
            mv.addObject("habilidadesPergunta", habilidadePergunta);
            return mv;
        } catch (Exception e) {
            return mv;
        }
    }

    /* Incluir habilidades em uma pergunta */
    @PostMapping("/index/pergunta/habilidades/{perguntaId}/{testeId}")
    public String setHabilidadePergunta(@PathVariable("perguntaId") int perguntaId,
            @PathVariable("testeId") int testeId, habForm lhab, RedirectAttributes attributes) {
        try {
            perguntaTeste p = perguntaTesteRepository.findById(perguntaId).get();
            List<habilidade> habpergunta = new ArrayList<>();
            p.getHabilidades().clear();
            if (lhab.getHabilidades() != null) {
                for (habilidade h : lhab.getHabilidades()) {
                    if (h.getHabilidadeId() > 0) {
                        habpergunta.add(habilidadeRepository.findById(h.getHabilidadeId()).get());
                        System.out.println("TESTEEEEEEEEE: " + h.getHabilidadeId());
                    }
                }
                p.setHabilidades(habpergunta);
            }
            perguntaTesteRepository.save(p);
            attributes.addFlashAttribute("sucesso", "habilidades do teste atualizado!");
            return "redirect:/index/pergunta/habilidades/{perguntaId}/{testeId}";
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Nao foi possivel alterar as habilidades" + e.toString());
            return "redirect:/index/teste/perguntas/{testeId}";
        }
    }
}
