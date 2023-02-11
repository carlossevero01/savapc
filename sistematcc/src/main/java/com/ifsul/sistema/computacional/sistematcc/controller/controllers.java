package com.ifsul.sistema.computacional.sistematcc.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;

import jakarta.transaction.Transactional;

@Controller
public class controllers {
    @Autowired
    alunoRepository alunoRepository;
    @Transactional      // Colocar caso de Cannot Remove em deleteByturnoNome(String)
        @GetMapping (value="/cadastrarAluno")     //@RequestMapping(value = "/listarCandidatos", method = RequestMethod.GET)
        @ResponseBody                               //@ResponseBody permite retornar um texto
        public String getCandidatos(){
            System.out.println("cadastrar aluno");
            aluno a = new aluno("carlos","0285") ;
            alunoRepository.save(a);
            return "";
        } 
        
}
