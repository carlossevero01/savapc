package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.correcoesUsuario;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.notas;
import com.ifsul.sistema.computacional.sistematcc.model.regQuestionarios;
import com.ifsul.sistema.computacional.sistematcc.model.respostaQuestionarios;
import com.ifsul.sistema.computacional.sistematcc.model.teste;
import com.ifsul.sistema.computacional.sistematcc.model.turma;
import com.ifsul.sistema.computacional.sistematcc.model.usuario;
import com.ifsul.sistema.computacional.sistematcc.repository.usuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.correcoesUsuarioRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.notasRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regQuestionariosRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.turmaRepository;
import com.ifsul.sistema.computacional.sistematcc.service.notasService;

@Service
public class notasServiceImplements implements notasService {
    @Autowired
    notasRepository notasRepository;

    @Autowired
    correcoesUsuarioRepository correcoesUsuarioRepository;
    @Autowired
    turmaRepository turmaRepository;
    @Autowired
    usuarioRepository alunoRepository;
    @Autowired
    regQuestionariosRepository regQuestionariosRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    @Override
    public List<notas> findByUsuario(usuario Usuario) {
        return notasRepository.findByUsuario(Usuario);
    }

    @Override
    public List<notas> findByTurma(turma turma) {
        return notasRepository.findByTurma(turma);
    }

    @Override
    public List<notas> findByUsuarioAndTurmaOrderByUsuario(usuario Usuario, turma turma) {
        return notasRepository.findByUsuarioAndTurmaOrderByUsuario(Usuario, turma);
    }

    @Override
    public void SalvarNotas(turma turma) {
        List<correcoesUsuario> regs = correcoesUsuarioRepository.findByTurmaOrderByUsuario(turma);
        Set<teste> testes = new HashSet<>();
        testes.clear();

        String recomendacao = " ";
        double nQcorretas = 0;
        int nQChab1 = 0;
        int nQChab2 = 0;
        int nQChab3 = 0;
        int nQChab4 = 0;
        int nQChab5 = 0;
        double nQ = 0;
        double notaProjeto = 0;
        double notaTestes = 0;
        String sabeProgramar="não"; 
        double notafinal = 0;
        int aux = 0;
        int nQRespondidas = 0;
        boolean notaExiste=false;
       
        for (correcoesUsuario r : regs) {

            
            nQRespondidas = correcoesUsuarioRepository.findByUsuarioAndTurma(r.getUsuario(), r.getTurma()).size();

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
            if (!testes.contains(r.getTeste())) {
                testes.add(r.getTeste());
            }

            if (aux == nQRespondidas) {
                notas nota = new notas();
                
                if (notasRepository.findByUsuarioAndTurmaOrderByUsuario(r.getUsuario(), r.getTurma()).size() > 0) {
                    nota = notasRepository.findByUsuarioAndTurmaOrderByUsuario(r.getUsuario(), r.getTurma()).get(0);
                    notaProjeto = nota.getNotaProjetoFinal();
                    sabeProgramar = nota.getSabeProgramar();
                    notaExiste=true;
                    
                } else {
                    nota.setUsuario(r.getUsuario());
                    nota.setTurma(r.getTurma());
                    notaProjeto = 0;
                    nota.setNotaProjetoFinal(notaProjeto);
                    notaExiste=false;
                    nota.setDesclassificado(false);
                }
                notaTestes = (nQcorretas / nQ) *10;
                notaTestes = Double.valueOf(String.format("%,.2f", notaTestes).replace(",", "."));
                notafinal = (notaTestes + notaProjeto)/2;
                notafinal = Double.valueOf(String.format("%,.2f", notafinal).replace(",", "."));

                for(regQuestionarios regquestionario : regQuestionariosRepository.findByUsuarioAndTurma(r.getUsuario(), r.getTurma())){
                    for(respostaQuestionarios respostaQuest : regquestionario.getRespostasQuestionario()){
                         if(respostaQuest.getPerguntaQuestionario().getTitulo().equalsIgnoreCase("Programa")){  
                            
                            if(opcaorespostaRepository.findById(respostaQuest.getOpRespostaId())!=null){ 
                                sabeProgramar = opcaorespostaRepository.findById(respostaQuest.getOpRespostaId()).get().getDescricao();
                            }else{ sabeProgramar = "Não";}    
                        }
                    }           
                }
                if (notafinal >= 6 && sabeProgramar.equalsIgnoreCase("Sim")) {
                    recomendacao = "Lcod";
                }else if(notafinal >= 6 && sabeProgramar.equalsIgnoreCase("Não")){
                    recomendacao = "Acod";
                }else if(notafinal > 5 && notafinal < 6) {
                    recomendacao = "Pcd";
                }else {recomendacao= "N/D";}
                if(notaExiste){
                    if(nota.getRecomendacao().equalsIgnoreCase("N/D")){
                        nota.setRecomendacao(recomendacao);
                    }else if(nota.getRecomendacao().equalsIgnoreCase("Pcd")){
                        if(!recomendacao.equalsIgnoreCase("N/D")){
                            nota.setRecomendacao(recomendacao);
                        }
                    }else if(nota.getRecomendacao().equalsIgnoreCase("Acod")){
                        if(recomendacao.equalsIgnoreCase("Lcod")){
                           nota.setRecomendacao(recomendacao); 
                        }
                    }   
                }else{
                    nota.setRecomendacao(recomendacao);
                }
                nota.setnPerguntasCorretas((int) nQcorretas);
                nota.setnPerguntas((int) nQ);
                nota.setNotaProjetoFinal(notaProjeto);
                nota.setNotaTestes(notaTestes);
                nota.setNotaFinal(notafinal);
                
                nota.setSabeProgramar(sabeProgramar);
                nota.setH1(nQChab1);
                nota.setH2(nQChab2);
                nota.setH3(nQChab3);
                nota.setH4(nQChab4);
                nota.setH5(nQChab5);
                nota.setTestes(testes);
                notasRepository.save(nota);
                testes.clear();
                notaTestes = 0;
                aux = 0;
                nQ = 0;
                nQcorretas = 0;
                nQChab1 = 0;
                nQChab2 = 0;
                nQChab3 = 0;
                nQChab4 = 0;
                nQChab5 = 0;
                nQRespondidas = 0;
                notafinal=0;
                recomendacao="";
            }

        }
    }

    @Override
    public List<notas> findByTurmaAndDesclassificado(turma t, boolean desclassificado) {
        return notasRepository.findByTurmaAndDesclassificado(t,desclassificado);
    }

}
