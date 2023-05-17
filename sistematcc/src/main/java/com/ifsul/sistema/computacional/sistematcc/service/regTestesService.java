package com.ifsul.sistema.computacional.sistematcc.service;



import java.util.List;



import com.ifsul.sistema.computacional.sistematcc.model.contabilizacaoPorHabilidade;

import com.ifsul.sistema.computacional.sistematcc.model.regTestes;


import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;

public interface regTestesService {
    
    List<contabilizacaoPorHabilidade> contabilizarTestesPorTurma(turma turma);
    List<contabilizacaoPorHabilidade> contabilizartudo();
    List<regTestes> findByTurma(turma turma);
}

