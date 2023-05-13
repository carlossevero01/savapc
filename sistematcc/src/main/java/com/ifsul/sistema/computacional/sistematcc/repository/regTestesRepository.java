package com.ifsul.sistema.computacional.sistematcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.regTestes;

import com.ifsul.sistema.computacional.sistematcc.model.turma;

import java.util.List;

public interface regTestesRepository extends JpaRepository<regTestes,Integer>{
     
     List<regTestes> findByTurma(turma turma);
}