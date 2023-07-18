package com.ifsul.savapc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.repository.turmaRepository;
import com.ifsul.savapc.service.turmaService;

public class turmaServiceImplements implements turmaService{
    @Autowired
    turmaRepository turmaRepository;

    @Override
    public List<turma> findByVisibilidade(boolean visibilidade) {
        return turmaRepository.findByVisibilidade(visibilidade);
    }
    
}
