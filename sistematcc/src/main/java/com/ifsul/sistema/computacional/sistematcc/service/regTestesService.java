package com.ifsul.sistema.computacional.sistematcc.service;



import java.util.List;



import com.ifsul.sistema.computacional.sistematcc.model.contabilizacao;

import com.ifsul.sistema.computacional.sistematcc.model.regTestes;


import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;

public interface regTestesService {
    
    List<contabilizacao> contabilizarTestesPorTurma(turma turma);
    List<contabilizacao> contabilizartudo();
    List<regTestes> findByTurma(turma turma);
}

