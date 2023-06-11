package com.ifsul.sistema.computacional.sistematcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsul.sistema.computacional.sistematcc.model.correcoesUsuario;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;


public interface correcoesUsuarioRepository extends JpaRepository<correcoesUsuario,Integer>{
    List<correcoesUsuario> findByUsuario (usuario a);
    List<correcoesUsuario> findByUsuarioAndTurmaAndTesteAndPerguntaTeste(usuario a, turma t, teste test, perguntaTeste perguntaTeste);
    List<correcoesUsuario> findByTurmaOrderByUsuario(turma turma);
    List<correcoesUsuario> findByUsuarioAndTurma(usuario a, turma t);
}
