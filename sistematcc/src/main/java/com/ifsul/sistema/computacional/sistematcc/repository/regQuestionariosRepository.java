package com.ifsul.sistema.computacional.sistematcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;


import com.ifsul.sistema.computacional.sistematcc.model.turma;

import java.util.List;

public interface regQuestionariosRepository extends JpaRepository<regQuestionarios,Integer>{
     
     List<regQuestionarios> findByTurma(turma turma);
}
