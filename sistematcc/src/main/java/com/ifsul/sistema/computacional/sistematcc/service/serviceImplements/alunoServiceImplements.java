package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.service.alunoService;

public class alunoServiceImplements implements alunoService{
    @Autowired
    alunoRepository alunoRepository;
    @Override
    public List<aluno> findByMatricula(String matricula) { return alunoRepository.findByMatricula(matricula); }
    @Override
    public List<aluno> findAllByTurmasIn(List<turma> turmas) {
       return alunoRepository.findAllByTurmasIn(turmas);
    }
    @Override
    public void deleteById(Integer id) {
        alunoRepository.deleteById(id);
    }
    
    
}
