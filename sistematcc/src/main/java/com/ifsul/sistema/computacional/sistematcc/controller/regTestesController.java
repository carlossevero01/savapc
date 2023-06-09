package com.ifsul.sistema.computacional.sistematcc.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;





import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.serviceImplements.regTestesServiceImplements;


@Controller
public class regTestesController {
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Autowired
    regTestesServiceImplements regTestesServiceImplements;
    @Autowired
    turmaRepository turmaRepository;

    

    
}
