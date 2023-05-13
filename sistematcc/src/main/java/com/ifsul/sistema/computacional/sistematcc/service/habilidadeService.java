package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;

public interface habilidadeService {
    List<habilidade> findByPerguntasTeste(perguntaTeste pergunta);
}
