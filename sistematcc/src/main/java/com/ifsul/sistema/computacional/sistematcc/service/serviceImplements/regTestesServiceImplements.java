package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ifsul.sistema.computacional.sistematcc.model.correcoesUsuario;
import com.ifsul.sistema.computacional.sistematcc.model.opcaoresposta;
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.respostaTeste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.correcoesUsuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;

@Service
public class regTestesServiceImplements implements regTestesService{

    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    
    @Autowired
    correcoesUsuarioRepository correcoesUsuarioRepository;
    

    public void fazerCorrecaoTestes() {
        
        List<regTestes> regs = regTestesRepository.findAll();
        for(int i=0;i<regs.size();i++){
            if(regs.get(i).getUsuario().getUsuarioId()==-1
                || regs.get(i).getTeste().getTesteId()==-1){
                    regs.remove(i);  
            }
            if(regs.get(i).getRespostasTeste().size()>0){
                for(int j=0;j<regs.get(i).getRespostasTeste().size();j++){
                    if(regs.get(i).getRespostasTeste().get(j).getPerguntaTeste()==null){
                        regs.get(i).getRespostasTeste().remove(j);
                    }
                }
            }
        }
        
        for (regTestes r : regs) { 
           
            int opRespostaCertaId=0;
            for (respostaTeste resp : r.getRespostasTeste()) {
                if(correcoesUsuarioRepository.findByUsuarioAndTurmaAndTesteAndPerguntaTeste(r.getUsuario(), r.getTurma(), r.getTeste(), resp.getPerguntaTeste()).size()<=0){
                System.out.println("\n Aluno:"+"PID:"+resp.getPerguntaTeste().getPerguntaTesteId()+"RID:"+resp.getOpRespostaId());
                
                if(opcaorespostaRepository.findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(resp.getPerguntaTeste(), true).size()>0){
                    opRespostaCertaId = opcaorespostaRepository.findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(resp.getPerguntaTeste(), true).get(0).getOpcaoRespostaId();
                }else{
                    opRespostaCertaId=0;
                }
                if (resp.getOpRespostaId() == opRespostaCertaId) { //Resposta Certa
                    opcaoresposta opR =  opcaorespostaRepository.findById(resp.getOpRespostaId()).get();            
                    correcoesUsuario cA = new correcoesUsuario(r.getUsuario(), r.getTurma(),r.getTeste(),
                            resp.getPerguntaTeste(), opR , true);
                    correcoesUsuarioRepository.save(cA);
                    
                    
                } else {                                                //Resposta Errada
                    opcaoresposta opR =  opcaorespostaRepository.findById(resp.getOpRespostaId()).get();
                    correcoesUsuario cA = new correcoesUsuario(r.getUsuario(),r.getTurma(), r.getTeste(), resp.getPerguntaTeste(), opR, false);
                    correcoesUsuarioRepository.save(cA);
                    
                }
            }
         }
        }
    }

    @Override
    public List<regTestes> findByTurma(turma turma) {
        return regTestesRepository.findByTurma(turma);
    }

    @Override
    public List<regTestes> findRegTestesByTurmaAndUsuario(turma t, usuario a) {
        return regTestesRepository.findRegTestesByTurmaAndUsuario(t, a);
    }
    
}
