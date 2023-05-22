package com.ifsul.sistema.computacional.sistematcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.projetoFinal;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.projetoFinalRespository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;

@Controller
public class projetoFinalController {
    @Autowired
    projetoFinalRespository projetoFinalRespository;
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    turmaRepository turmaRepository;
    
    @GetMapping("/projetofinal")
    @ResponseBody
    public String setProjetoFinal(){
        turma t = turmaRepository.findAll().get(0);
        aluno a = alunoRepository.findAll().get(0);
        projetoFinal pf = new projetoFinal( a, t, 2);
        projetoFinalRespository.save(pf);
        return "Adicionado ao banco";
    }
}
