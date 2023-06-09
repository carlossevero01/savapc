package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.questionarioinicial;
import com.ifsul.sistema.computacional.sistematcc.model.turma;


public interface questionarioinicialService {
    List<questionarioinicial> findByTurmas(turma turma);
    void atualizarVisibilidade();
}
