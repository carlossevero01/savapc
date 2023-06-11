package com.ifsul.sistema.computacional.sistematcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;

import java.util.List;

public interface regTestesRepository extends JpaRepository<regTestes,Integer>{
     
     List<regTestes> findByTurma(turma turma);
     List<regTestes> findByTesteAndTurmaAndUsuario(teste t, turma tu, usuario u);
     List<regTestes> findRegTestesByTurmaAndUsuario(turma t,usuario a);
}
