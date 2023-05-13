package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.opcaorespostaService;

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
