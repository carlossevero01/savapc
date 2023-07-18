package com.ifsul.savapc.service;

import java.util.List;

import com.ifsul.savapc.model.teste;
import com.ifsul.savapc.model.turma;

public interface testeService {
    List<teste> findByTurmas(turma turma);
    void atualizarVisibilidades();
}
