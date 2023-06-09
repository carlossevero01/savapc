package com.ifsul.sistema.computacional.sistematcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;




public interface testeRepository extends JpaRepository<teste,Integer>{
    List<teste> findByTurmas(turma turma);
    
}
