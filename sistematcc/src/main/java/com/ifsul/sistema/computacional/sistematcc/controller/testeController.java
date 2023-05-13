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

import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.perguntasForm;
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.respostaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.testeForm;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaTesteRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;

import jakarta.validation.Valid;

@Controller
public class testeController {
    @Autowired
    testeRepository testeRepository;
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    perguntaTesteRepository perguntaTesteRepository;
    @Autowired
    regTestesRepository regTestesRepository;

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

        List<perguntaTeste> perguntas = t.getPerguntasTeste();
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
        List<respostaTeste> ListRespostas = new ArrayList<>();
        regTestes reg = new regTestes();
        if (alunoRepository.findByMatricula(lresp.getMatricula().trim()).size()>0) {
            for (perguntaTeste Pergunta : lresp.getPerguntas()) {
                respostaTeste resposta = new respostaTeste();
                perguntaTeste p = perguntaTesteRepository.findById(Pergunta.getPerguntaTesteId()).orElseThrow(null);
                resposta.setperguntaTeste(p);
                resposta.setOpRespostaId(Integer.valueOf(Pergunta.getOpRespostaId()));
                ListRespostas.add(resposta);
            }
            reg.setAluno(alunoRepository.findByMatricula(lresp.getMatricula()).get(0));
            reg.setTeste(t);
            reg.setRespostasTeste(ListRespostas);
            regTestesRepository.save(reg);
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
        List<perguntaTeste> lperguntas = perguntaTesteRepository.findAll();
        mv.addObject("perguntas", lperguntas);
        return mv;
    }
    /*Salvar um novo teste */
    @PostMapping("/index/saveTeste")
    public String saveTeste(@Valid testeForm t, BindingResult result, RedirectAttributes attributes) {
        List<perguntaTeste> ListPerguntas = new ArrayList<>();
        teste test = new teste();
        if (result.hasErrors()) {
            attributes.addFlashAttribute("erro", "Verifique os campos obrigatórios:" + t.toString());
            return "redirect:/index/saveTeste";
        }else{
        try {
            if(t.getPerguntas()!=null){
                for (perguntaTeste perg : t.getPerguntas()) {
                    if(perguntaTesteRepository.existsById(perg.getPerguntaTesteId())){
                        perguntaTeste p = perguntaTesteRepository.findById(perg.getPerguntaTesteId()).orElseThrow(null);
                        ListPerguntas.add(p);
                    }
                }
                if(t.getPeso()==0){
                    test = new teste(t.isVisibilidade(), t.getNome(),t.getDisponibilidade(),ListPerguntas,0);
                }else{
                    test = new teste(t.isVisibilidade(), t.getNome(),t.getDisponibilidade(),ListPerguntas,t.getPeso());
                }
                
            }else{
                if(t.getPeso()==0){test = new teste(t.isVisibilidade(), t.getNome(),t.getDisponibilidade(),null,0);}
                else{test = new teste(t.isVisibilidade(), t.getNome(),t.getDisponibilidade(),null,t.getPeso());}
               
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
