package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;

@Service
public interface opcaorespostaService {
    List<opcaoresposta> findByVerdadeira(boolean verdadeira);
    List<opcaoresposta> findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(perguntaTeste p,boolean verdadeira);
}
