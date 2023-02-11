package com.ifsul.sistema.computacional.sistematcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="perguntaTeste")
public class perguntateste {
    @Column(nullable = false)
    private int testeId;

    @Column(nullable = false)
    private int perguntaId;

    
}
