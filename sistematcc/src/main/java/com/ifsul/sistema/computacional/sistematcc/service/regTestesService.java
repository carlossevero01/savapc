package com.ifsul.sistema.computacional.sistematcc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.contabilizacao;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.regTestes;
import com.ifsul.sistema.computacional.sistematcc.model.respostaTeste;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.regTestesRepository;
import com.ifsul.sistema.computacional.sistematcc.service.regTestesService;
@Service
public class regTestesService {
    @Autowired
    regTestesRepository regTestesRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    public List<contabilizacao> contabilizartudo() {
        List<regTestes> regs = regTestesRepository.findAll();
        for(int i=0;i<regs.size();i++){
            if(regs.get(i).getAluno().getAlunoId()==-1
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

        List<correcoesAluno> correcaoList = new ArrayList<>();
        List<contabilizacao> contabilizacaoList = new ArrayList<>();
        int nQcorretas = 0;
        int nQChab1 = 0;
        int nQChab2 = 0;
        int nQChab3 = 0;
        int nQChab4 = 0;
        int nQChab5 = 0;
        int nQ = 0;
        for (regTestes r : regs) {
            nQcorretas = 0;
            nQChab1 = 0;
            nQChab2 = 0;
            nQChab3 = 0;
            nQChab4 = 0;
            nQChab5 = 0;
            nQ = r.getTeste().getPerguntasTeste().size();
            for (respostaTeste resp : r.getRespostasTeste()) {

                if (resp.getOpRespostaId() == opcaorespostaRepository
                        .findOpcaoRespostaIdByPerguntasTesteAndVerdadeira(resp.getPerguntaTeste(), true).get(0)
                        .getOpcaoRespostaId()) {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPerguntaTeste().getPerguntaTesteId(), resp.getOpRespostaId(), true);

                    nQcorretas++;
                    for (habilidade h : resp.getPerguntaTeste().getHabilidades()) {
                        switch (h.getNome()) {
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
                    correcaoList.add(cA);
                } else {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPerguntaTeste().getPerguntaTesteId(), resp.getOpRespostaId(), false);
                    correcaoList.add(cA);
                }
            }
            var contQH = new contabilizacao(r.getAluno().getAlunoId(), r.getTeste().getTesteId(), nQcorretas, nQChab1,
                    nQChab2, nQChab3, nQChab4, nQChab5, nQ, r.getTeste().getPeso());
            contabilizacaoList.add(contQH);
        }
        return contabilizacaoList;
    }
}

