package com.ifsul.sistema.computacional.sistematcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="opcaoRespostaPergunta")
public class opcaorespostapergunta {
    @Column(nullable = false)
    private int perguntaId;

    @Column(nullable = false)
    private int opcaoRespostaId;

    
}
