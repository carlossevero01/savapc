package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;


public interface correcoesAlunoService {
    List<correcoesAluno> findByAluno(aluno a);
    List<correcoesAluno> findByTurmaOrderByAluno(turma t);
    List<correcoesAluno> findByAlunoAndTurmaAndTesteAndPerguntaTeste(aluno a, turma t, teste test, perguntaTeste perguntaTeste);
    List<correcoesAluno> findByAlunoAndTurma(aluno a, turma t);
}
