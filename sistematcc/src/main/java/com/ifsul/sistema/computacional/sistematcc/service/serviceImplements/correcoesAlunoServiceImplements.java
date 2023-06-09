package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.perguntaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.correcoesAlunoRepository;
import com.ifsul.sistema.computacional.sistematcc.service.correcoesAlunoService;

public class correcoesAlunoServiceImplements implements correcoesAlunoService{
    @Autowired
    correcoesAlunoRepository correcoesAlunoRepository;
    @Override
    public List<correcoesAluno> findByAluno(aluno a) {
        return correcoesAlunoRepository.findByAluno(a);
    }
    @Override
    public List<correcoesAluno> findByAlunoAndTurmaAndTesteAndPerguntaTeste(aluno a, turma t, teste test,
            perguntaTeste perguntaTeste) {
        return correcoesAlunoRepository.findByAlunoAndTurmaAndTesteAndPerguntaTeste(a, t, test, perguntaTeste);
    }
    @Override
    public List<correcoesAluno> findByTurmaOrderByAluno(turma t) {
        return correcoesAlunoRepository.findByTurmaOrderByAluno(t);
    }
    @Override
    public List<correcoesAluno> findByAlunoAndTurma(aluno a, turma t) {
        return correcoesAlunoRepository.findByAlunoAndTurma(a, t);
    }
    
}
