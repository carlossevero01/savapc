package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;




import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.aluno;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.notas;

import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.repository.alunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.correcoesAlunoRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.notasRepository;

import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.notasService;


@Service
public class notasServiceImplements implements notasService{
    @Autowired
    notasRepository notasRepository;
    
    @Autowired
    correcoesAlunoRepository correcoesAlunoRepository;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    alunoRepository alunoRepository;
    @Override
    public List<notas> findByAluno(aluno aluno) {
        return notasRepository.findByAluno(aluno);
    }

    @Override
    public List<notas> findByTurma(turma turma) {
        return notasRepository.findByTurma(turma);
    }

    @Override
    public List<notas> findByAlunoAndTurmaOrderByAluno(aluno aluno, turma turma) {
       return notasRepository.findByAlunoAndTurmaOrderByAluno(aluno, turma);
    }

    

    

    @Override
    public void SalvarNotas(turma turma) {
        

       List<correcoesAluno> regs = correcoesAlunoRepository.findByTurmaOrderByAluno(turma);
       Set<teste> testes = new HashSet<>();
       testes.clear();
       
        
       
        String recomendacao = "";
        double nQcorretas = 0;
        int nQChab1 = 0;
        int nQChab2 = 0;
        int nQChab3 = 0;
        int nQChab4 = 0;
        int nQChab5 = 0;
        double nQ = 0;
        double notaProjeto=0;
        double notaTestes=0;
        double pesoTestes=0;
        double notafinal=0;
        int aux=0;
        int nQRespondidas=0;
        
        for (correcoesAluno r : regs) {
            
            
            pesoTestes=r.getTurma().getPesoTestes();
            nQRespondidas= correcoesAlunoRepository.findByAlunoAndTurma(r.getAluno(), r.getTurma()).size();
            
            aux++;
            nQ++;
            if (r.isAcertou()) {
                nQcorretas++;
                for (habilidade h : r.getPerguntaTeste().getHabilidades()) {
                    switch (h.getNome().toLowerCase().replace("ã", "a").replace("ç", "c").replace("í", "i")) {
                        case "compreensao":
                            nQChab1++;
                            break;
                        case "abstracao":
                            nQChab2++;
                            break;
                        case "resolucao de problemas":
                            nQChab3++;
                            break;
                        case "resolucao algoritmica":
                            nQChab4++;
                            break;
                        case "avaliacao":
                            nQChab5++;
                            break;
                        default:
                            break;
                    }
                }
            } 
            if(!testes.contains(r.getTeste())){
                 testes.add(r.getTeste());
                 
            }
            
            if(aux==nQRespondidas){
                notas nota = new notas();
            
                System.out.println("\n \n Tamanho:"+notasRepository.findByAlunoAndTurmaOrderByAluno(r.getAluno(), r.getTurma()).size());
                if(notasRepository.findByAlunoAndTurmaOrderByAluno(r.getAluno(), r.getTurma()).size()>0){
                     nota = notasRepository.findByAlunoAndTurmaOrderByAluno(r.getAluno(), r.getTurma()).get(0);
                    notaProjeto=nota.getNotaProjetoFinal();
                    System.out.println("Entrou ID:"+nota.getNotaId());
                }else{
                    notaProjeto=0;
                     nota.setNotaProjetoFinal(notaProjeto);
                    System.out.println("\nNão entrou");
                }
                
                notaTestes=(nQcorretas/nQ);
                notafinal = (notaTestes*pesoTestes)+notaProjeto;
                   
                if(notafinal>=6){recomendacao="Acod";}else{recomendacao="N/D";}
                
                
                nota.setnPerguntasCorretas(( int) nQcorretas); 
                nota.setnPerguntas((int) nQ);
                nota.setNotaProjetoFinal(notaProjeto);
                nota.setNotaTestes(notaTestes);
                nota.setNotaFinal(notafinal); 
                nota.setRecomendacao(recomendacao);
                nota.setPesoTestes(pesoTestes);
                nota.setH1(nQChab1);
                nota.setH2(nQChab2);
                nota.setH3(nQChab3);
                nota.setH4(nQChab4);
                nota.setH5(nQChab5);
                nota.setTestes(testes);
                notasRepository.save(nota);
                testes.clear();
                notaTestes=0;
                aux=0;
                nQ=0;
                nQcorretas = 0;
                nQChab1 = 0;
                nQChab2 = 0;
                nQChab3 = 0;
                nQChab4 = 0;
                nQChab5 = 0;
                nQRespondidas=0;
               
            }
                    
        }
    }

    
}

            
            
        
    
    

