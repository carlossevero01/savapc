package com.ifsul.savapc.service.serviceImplements;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.savapc.model.teste;
import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.repository.testeRepository;
import com.ifsul.savapc.service.testeService;

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
