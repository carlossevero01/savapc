package com.ifsul.savapc.service;

import java.util.List;

import com.ifsul.savapc.model.turma;

public interface turmaService {
    List<turma> findByVisibilidade(boolean visibilidade);
}
