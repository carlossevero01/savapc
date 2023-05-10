package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.turma;

public interface turmaService {
    List<turma> findByVisibilidade(boolean visibilidade);
}
