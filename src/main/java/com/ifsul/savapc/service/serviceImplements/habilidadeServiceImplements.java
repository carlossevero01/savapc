package com.ifsul.savapc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.savapc.model.habilidade;
import com.ifsul.savapc.model.perguntaTeste;
import com.ifsul.savapc.repository.habilidadeRepository;
import com.ifsul.savapc.service.habilidadeService;

public class habilidadeServiceImplements implements habilidadeService{
    @Autowired
    habilidadeRepository habilidadeRepository;
    
    @Override
    public List<habilidade> findByPerguntasTeste(perguntaTeste pergunta) {
        return habilidadeRepository.findByPerguntasTeste(pergunta);
    }
    
}
