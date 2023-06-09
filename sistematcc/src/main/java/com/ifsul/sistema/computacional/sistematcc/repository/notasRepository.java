package com.ifsul.sistema.computacional.sistematcc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.notas;
import com.ifsul.sistema.computacional.sistematcc.model.turma;


public interface notasRepository extends JpaRepository<notas,Integer> {
    List<notas> findByAluno(aluno aluno);
    List<notas> findByTurma(turma turma);
    List<notas> findByAlunoAndTurmaOrderByAluno(aluno aluno, turma turma);
    
    
    
}
