package com.ifsul.sistema.computacional.sistematcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;


public interface correcoesAlunoRepository extends JpaRepository<correcoesAluno,Integer>{
    List<correcoesAluno> findByAluno (aluno a);
    List<correcoesAluno> findByAlunoAndTurmaAndTesteAndPerguntaTeste(aluno a, turma t, teste test, perguntaTeste perguntaTeste);
    List<correcoesAluno> findByTurmaOrderByAluno(turma turma);
    List<correcoesAluno> findByAlunoAndTurma(aluno a, turma t);
}
