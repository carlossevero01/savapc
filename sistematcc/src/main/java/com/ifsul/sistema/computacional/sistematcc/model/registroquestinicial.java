package com.ifsul.sistema.computacional.sistematcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// @Entity
// @Table(name="registroQuestInicial")
public class registroquestinicial {
    @Column(nullable = false)
    private int questionarioId;

    @Column(nullable = false)
    private int alunoId;

    @Column(nullable = false)
    private int perguntaQuestId;

}
