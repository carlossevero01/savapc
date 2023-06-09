package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;



import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.notas;

import com.ifsul.sistema.computacional.sistematcc.model.turma;


public interface notasService {
    void SalvarNotas(turma turma);
    List<notas> findByAluno(aluno aluno);
    List<notas> findByTurma(turma turma);
    List<notas> findByAlunoAndTurmaOrderByAluno(aluno aluno, turma turma);
    
    
}
