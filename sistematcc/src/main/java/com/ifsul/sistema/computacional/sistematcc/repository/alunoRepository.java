package com.ifsul.sistema.computacional.sistematcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
public interface alunoRepository extends JpaRepository<aluno,Integer>{
    List<aluno> findByMatricula(String matricula);
     
}
