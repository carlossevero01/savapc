package com.ifsul.savapc.service.serviceImplements;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.savapc.model.regQuestionarios;
import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.model.usuario;
import com.ifsul.savapc.repository.opcaorespostaRepository;
import com.ifsul.savapc.repository.questionarioinicialRepository;
import com.ifsul.savapc.repository.regQuestionariosRepository;
import com.ifsul.savapc.service.regQuestionariosService;


@Service
public class regQuestionariosServiceImplements implements regQuestionariosService{

    @Autowired
    regQuestionariosRepository regQuestionariosRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;

    @Override
    public List<regQuestionarios> findByTurma(turma turma) {
        return regQuestionariosRepository.findByTurma(turma);
    }

    @Override
    public List<regQuestionarios> findByUsuarioAndTurma(usuario u, turma turma) {
        return regQuestionariosRepository.findByUsuarioAndTurma(u, turma);
    }
    
}
