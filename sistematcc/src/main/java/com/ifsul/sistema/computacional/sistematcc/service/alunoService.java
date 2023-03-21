package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;

public interface alunoService {
    List<aluno> findByMatricula(String matricula);
}
