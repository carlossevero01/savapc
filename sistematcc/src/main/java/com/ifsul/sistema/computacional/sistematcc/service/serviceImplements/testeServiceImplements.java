package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.testeRepository;
import com.ifsul.sistema.computacional.sistematcc.service.testeService;

@Service
public class testeServiceImplements implements testeService{
    @Autowired
    testeRepository testeRepository;

    @Override
    public List<teste> findByTurmas(turma turma) {
        
        return testeRepository.findByTurmas(turma);
    }

    @Override
    public void atualizarVisibilidades() {
        List<teste> allTests = testeRepository.findAll();
        LocalDate firstDate = LocalDate.now();
        System.out.println("\n \n FD:"+firstDate);
        for (teste test : allTests) {
            LocalDate secondDate = test.getDisponibilidade();
           boolean a =  secondDate.isAfter(firstDate);
           if(a==false){
            test.setVisibilidade(false);
            testeRepository.save(test);
           }
        }
        
    }
    
}
