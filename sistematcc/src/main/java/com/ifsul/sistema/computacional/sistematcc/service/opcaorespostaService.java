package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.pergunta;

@Service
public interface opcaorespostaService {
    List<opcaoresposta> findByVerdadeira(boolean verdadeira);
    List<opcaoresposta> findOpcaoRespostaIdByPerguntasAndVerdadeira(pergunta p,boolean verdadeira);
}
