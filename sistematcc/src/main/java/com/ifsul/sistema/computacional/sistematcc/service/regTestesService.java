package com.ifsul.sistema.computacional.sistematcc.service;



import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;


import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;

public interface regTestesService {
    
    
    void fazerCorrecaoTestes();
    List<regTestes> findByTurma(turma turma);
    List<regTestes> findRegTestesByTurmaAndAluno(turma t,aluno a);
}

