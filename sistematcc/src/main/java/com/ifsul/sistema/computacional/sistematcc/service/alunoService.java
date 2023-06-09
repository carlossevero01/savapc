package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;



import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.turma;




public interface alunoService {

    void deleteById (Integer id);
    List<aluno> findByMatricula(String matricula);
    List<aluno> findAllByTurmasIn(List<turma> turmas);

    
}
