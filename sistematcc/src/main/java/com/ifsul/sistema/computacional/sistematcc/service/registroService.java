package com.ifsul.sistema.computacional.sistematcc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsul.sistema.computacional.sistematcc.model.contabilizacao;
import com.ifsul.sistema.computacional.sistematcc.model.correcoesAluno;
import com.ifsul.sistema.computacional.sistematcc.model.habilidade;
import com.ifsul.sistema.computacional.sistematcc.model.registro;
import com.ifsul.sistema.computacional.sistematcc.model.resposta;
import com.ifsul.sistema.computacional.sistematcc.repository.opcaorespostaRepository;
import com.ifsul.sistema.computacional.sistematcc.repository.registroRepository;
import com.ifsul.sistema.computacional.sistematcc.service.registroService;
@Service
public class registroService {
    @Autowired
    registroRepository registroRepository;
    @Autowired
    opcaorespostaRepository opcaorespostaRepository;
    public List<contabilizacao> contabilizartudo() {
        List<registro> regs = registroRepository.findAll();
      

        List<correcoesAluno> correcaoList = new ArrayList<>();
        List<contabilizacao> contabilizacaoList = new ArrayList<>();
        int nQcorretas = 0;
        int nQChab1 = 0;
        int nQChab2 = 0;
        int nQChab3 = 0;
        int nQChab4 = 0;
        int nQChab5 = 0;
        int nQ = 0;
        for (registro r : regs) {
            nQcorretas = 0;
            nQChab1 = 0;
            nQChab2 = 0;
            nQChab3 = 0;
            nQChab4 = 0;
            nQChab5 = 0;
            nQ = r.getTeste().getPerguntas().size();
            for (resposta resp : r.getRespostas()) {

                if (resp.getOpRespostaId() == opcaorespostaRepository
                        .findOpcaoRespostaIdByPerguntasAndVerdadeira(resp.getPergunta(), true).get(0)
                        .getOpcaoRespostaId()) {
                    correcoesAluno cA = new correcoesAluno(r.getAluno().getAlunoId(), r.getTeste().getTesteId(),
                            r.getTeste().getNome(), resp.getPergunta().getPerguntaId(), resp.getOpRespostaId(), true);

                    nQcorretas++;
                    for (habilidade h : resp.getPergunta().getHabilidades()) {
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
                            r.getTeste().getNome(), resp.getPergunta().getPerguntaId(), resp.getOpRespostaId(), false);
                    correcaoList.add(cA);
                }
            }
            var contQH = new contabilizacao(r.getAluno().getAlunoId(), r.getTeste().getTesteId(), nQcorretas, nQChab1,
                    nQChab2, nQChab3, nQChab4, nQChab5, nQ);
            contabilizacaoList.add(contQH);
        }
        return contabilizacaoList;
    }
}

