package com.ifsul.savapc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.savapc.model.opcaoresposta;
import com.ifsul.savapc.model.perguntaTeste;
import com.ifsul.savapc.repository.opcaorespostaRepository;
import com.ifsul.savapc.service.opcaorespostaService;

public class opcaorespostaServiceImplements implements opcaorespostaService{
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;

    @Override
    public List<opcaoresposta> findByVerdadeira(boolean verdadeira) {
        return opcaorespostaRepository.findByVerdadeira(verdadeira);
    }

    @Override
    public List<opcaoresposta> findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(perguntaTeste p, boolean verdadeira) {
        return opcaorespostaRepository.findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(p, verdadeira);
    }
    
}
