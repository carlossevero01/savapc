package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.service.testeService;

public class testeServiceImplements implements testeService{
    @Autowired
    testeRepository testeRepository;

    @Override
    public List<teste> findByTurmas(turma turma) {
        
        return testeRepository.findByTurmas(turma);
    }
    
}
