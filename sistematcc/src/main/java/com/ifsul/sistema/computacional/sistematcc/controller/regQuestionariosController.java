package com.ifsul.sistema.computacional.sistematcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaQuestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regQuestionariosRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;

@Controller
public class regQuestionariosController {
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    perguntaQuestionarioRepository perguntaQuestionarioRepository;
    @Autowired
    regQuestionariosRepository regQuestionariosRepository;
    @Autowired
    turmaRepository turmaRepository;

    /* Listar registros de questionarios de uma turma */
    @GetMapping("/index/relatorioQuestionario/{turmaId}")
    public ModelAndView getRelatorioQuestionario(@PathVariable("turmaId") int turmaId) {
        ModelAndView mv = new ModelAndView("registroquestionario");
        try {
            turma turma = turmaRepository.findById(turmaId).get();
            List<regQuestionarios> regquest = regQuestionariosRepository.findByTurma(turma);
            mv.addObject("turma", turma);
            if (regquest.size() > 0 && regquest.get(0).getQuestionario() != null
                    && regquest.get(0).getUsuario() != null) {
                mv.addObject("registros", regquest);

            }

        } catch (Exception e) {
            return mv;
        }
        return mv;
    }

}
