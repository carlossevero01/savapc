package com.ifsul.savapc.service.serviceImplements;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.savapc.model.questionarioinicial;
import com.ifsul.savapc.model.turma;
import com.ifsul.savapc.repository.questionarioinicialRepository;
import com.ifsul.savapc.service.questionarioinicialService;
@Service
public class questionarioinicialServiceImplements implements questionarioinicialService{
    @Autowired
    questionarioinicialRepository questionarioinicialRepository;
    @Override
    public List<questionarioinicial> findByTurmas(turma turma) {
        return questionarioinicialRepository.findByTurmas(turma);
    }
    @Override
    public void atualizarVisibilidade() {
         List<questionarioinicial> allQuests = questionarioinicialRepository.findAll();
        LocalDate firstDate = LocalDate.now();
        for (questionarioinicial quest : allQuests) {
            LocalDate secondDate = quest.getDisponibilidade();
           boolean a =  secondDate.isAfter(firstDate);
           if(a==false){
            quest.setVisibilidade(false);
            questionarioinicialRepository.save(quest);
           }
        }
    }
    
}
