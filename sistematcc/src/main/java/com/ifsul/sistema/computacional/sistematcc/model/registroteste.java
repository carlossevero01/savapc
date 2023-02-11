package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table (name = "registroTeste")
public class registroteste implements Serializable{
    
    @Column(nullable = false)
    private int testeId;

    @Column(nullable = false)
    private int alunoId;

    @Column(nullable = false)
    private int perguntaId;

    
}