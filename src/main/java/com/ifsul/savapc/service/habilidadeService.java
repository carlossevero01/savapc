package com.ifsul.savapc.service;

import java.util.List;

import com.ifsul.savapc.model.habilidade;
import com.ifsul.savapc.model.perguntaTeste;

public interface habilidadeService {
    List<habilidade> findByPerguntasTeste(perguntaTeste pergunta);
}
