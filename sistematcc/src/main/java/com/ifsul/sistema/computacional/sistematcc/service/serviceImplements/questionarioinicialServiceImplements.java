package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.service.questionarioinicialService;

public class questionarioinicialServiceImplements implements questionarioinicialService{
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Override
    public List<questionarioinicial> findByTurmas(turma turma) {
        return questionarioinicialRepository.findByTurmas(turma);
    }
    
}
