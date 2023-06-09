package com.ifsul.sistema.computacional.sistematcc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ifsul.sistema.computacional.sistematcc.model.turma;
public interface turmaRepository extends JpaRepository<turma,Integer>{
    
     List<turma> findByVisibilidade(boolean visibilidade);
     
}