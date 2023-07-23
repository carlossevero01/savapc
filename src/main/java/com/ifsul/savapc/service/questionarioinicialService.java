package com.ifsul.savapc.service;

import java.util.List;

import com.ifsul.savapc.model.perguntasQuestForm;
import com.ifsul.savapc.model.questionarioinicial;

import com.ifsul.savapc.model.turma;


public interface questionarioinicialService {
    List<questionarioinicial> findByTurmas(turma turma);
    void atualizarVisibilidade();
    boolean salvarRespostasQuest(turma t, questionarioinicial quest, perguntasQuestForm lresp);
}
