package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;

public interface testeService {
    List<teste> findByTurmas(turma turma);
    void atualizarVisibilidades();
}
