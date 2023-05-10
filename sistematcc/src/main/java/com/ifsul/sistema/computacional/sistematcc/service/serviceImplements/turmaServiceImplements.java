package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.turmaService;

public class turmaServiceImplements implements turmaService{
    @Autowired
    turmaRepository turmaRepository;

    @Override
    public List<turma> findByVisibilidade(boolean visibilidade) {
        return turmaRepository.findByVisibilidade(visibilidade);
    }
    
}
