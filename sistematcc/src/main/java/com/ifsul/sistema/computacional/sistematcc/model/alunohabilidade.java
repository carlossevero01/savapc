package com.ifsul.sistema.computacional.sistematcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="alunoHabilidade")
public class alunohabilidade {
    @Column(nullable = false)
    private int alunoId;

    @Column(nullable = false)
    private int habilidadeId;

    
}
