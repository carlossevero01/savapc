package com.ifsul.savapc.service;

import java.util.List;

import com.ifsul.savapc.model.correcoesUsuario;
import com.ifsul.savapc.model.perguntaTeste;
import com.ifsul.savapc.model.teste;
import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.model.usuario;


public interface correcoesUsuarioService {
    List<correcoesUsuario> findByUsuario(usuario a);
    List<correcoesUsuario> findByTurmaOrderByUsuario(turma t);
    List<correcoesUsuario> findByUsuarioAndTurmaAndTesteAndPerguntaTeste(usuario a, turma t, teste test, perguntaTeste perguntaTeste);
    List<correcoesUsuario> findByUsuarioAndTurma(usuario a, turma t);
}
