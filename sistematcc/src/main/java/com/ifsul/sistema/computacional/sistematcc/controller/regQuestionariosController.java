package com.ifsul.sistema.computacional.sistematcc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;
import com.ifsul.sistema.computacional.sistematcc.repository.perguntaQuestionarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regQuestionariosRepository;

@Controller
public class regQuestionariosController {
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Autowired
    perguntaQuestionarioRepository perguntaQuestionarioRepository;
    @Autowired
    regQuestionariosRepository regQuestionariosRepository;

    @GetMapping("/index/relatorioQuestionario")
    public ModelAndView getRelatorioQuestionario(){
        ModelAndView mv = new ModelAndView("registroquestionario");
        try {
            List<regQuestionarios> regquest = regQuestionariosRepository.findAll();
            if(regquest.size()>0 && regquest.get(0).getQuestionario()!=null && regquest.get(0).getAluno() !=null ){
                mv.addObject("registros", regquest);
            }
            
        } catch (Exception e) {
            return mv;
        }
        return mv;
    }

}
