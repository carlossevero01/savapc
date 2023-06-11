package com.ifsul.sistema.computacional.sistematcc.service;



import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;

public interface regTestesService {
    
    
    void fazerCorrecaoTestes();
    List<regTestes> findByTurma(turma turma);
    List<regTestes> findRegTestesByTurmaAndUsuario(turma t,usuario a);
    List<regTestes> findByTesteAndTurmaAndUsuario(teste t, turma tu, usuario u);
}

