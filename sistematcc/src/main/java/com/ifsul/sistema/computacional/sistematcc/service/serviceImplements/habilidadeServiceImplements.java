package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;
import com.ifsul.sistema.computacional.sistematcc.repository.habilidadeRepository;
import com.ifsul.sistema.computacional.sistematcc.service.habilidadeService;

public class habilidadeServiceImplements implements habilidadeService{
    @Autowired
    habilidadeRepository habilidadeRepository;
    
    @Override
    public List<habilidade> findByPerguntas(pergunta pergunta) {
        return habilidadeRepository.findByPerguntas(pergunta);
    }
    
}
