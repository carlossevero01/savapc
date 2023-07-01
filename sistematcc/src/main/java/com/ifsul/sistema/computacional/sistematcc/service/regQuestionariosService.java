package com.ifsul.sistema.computacional.sistematcc.service;



import java.util.List;




import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;



import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.service.regQuestionariosService;

public interface regQuestionariosService {
    
    List<regQuestionarios> findByUsuarioAndTurma(usuario u, turma turma);
    List<regQuestionarios> findByTurma(turma turma);
}

