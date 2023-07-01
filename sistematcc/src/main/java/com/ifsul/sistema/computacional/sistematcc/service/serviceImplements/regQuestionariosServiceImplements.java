package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;



import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.questionarioinicialRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regQuestionariosRepository;
import com.ifsul.sistema.computacional.sistematcc.service.regQuestionariosService;


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
