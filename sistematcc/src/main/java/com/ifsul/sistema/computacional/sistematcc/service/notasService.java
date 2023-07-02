package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;




import com.ifsul.sistema.computacional.sistematcc.model.notas;

import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;


public interface notasService {
    void SalvarNotas(turma turma);
    List<notas> findByUsuario(usuario usuario);
    List<notas> findByTurma(turma turma);
    List<notas> findByUsuarioAndTurmaOrderByUsuario(usuario aluno,turma turma);
    List<notas> findByTurmaAndDesclassificado(turma t, boolean desclassificado);
    
}
