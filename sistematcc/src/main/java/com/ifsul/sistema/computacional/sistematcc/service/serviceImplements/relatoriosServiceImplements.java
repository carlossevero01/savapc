package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;



import org.springframework.beans.factory.annotation.Autowired;


import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.correcoesAlunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.relatoriosService;

public class relatoriosServiceImplements implements relatoriosService{
    @Autowired
    regTestesServiceImplements regTestesServiceImplements;
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    correcoesAlunoRepository correcoesAlunoRepository;
    @Autowired
    correcoesAlunoServiceImplements correcoesAlunoServiceImplements;
    @Autowired
    alunoRepository alunoRepository;
    @Autowired
    turmaRepository turmaRepository;

    
    
}
