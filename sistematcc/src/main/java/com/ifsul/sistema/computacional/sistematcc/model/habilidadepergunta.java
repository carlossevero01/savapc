package com.ifsul.sistema.computacional.sistematcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// @Entity
// @Table(name="habilidadePergunta")
public class habilidadepergunta {
    @Column(nullable = false)
    private int habilidadeId;

    @Column(nullable = false)
    private int perguntaId;

    
}
