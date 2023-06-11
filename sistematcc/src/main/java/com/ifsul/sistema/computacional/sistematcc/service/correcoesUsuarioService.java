package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.correcoesUsuario;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;


public interface correcoesUsuarioService {
    List<correcoesUsuario> findByUsuario(usuario a);
    List<correcoesUsuario> findByTurmaOrderByUsuario(turma t);
    List<correcoesUsuario> findByUsuarioAndTurmaAndTesteAndPerguntaTeste(usuario a, turma t, teste test, perguntaTeste perguntaTeste);
    List<correcoesUsuario> findByUsuarioAndTurma(usuario a, turma t);
}
