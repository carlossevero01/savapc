package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "habilidade")
public class habilidade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habilidadeId;

    @Column(nullable = false)
    private String nome;

    public int getHabilidadeId() {
        return habilidadeId;
    }

    public void setHabilidadeId(int habilidadeId) {
        this.habilidadeId = habilidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public habilidade() {
    }

    public habilidade(String nome) {
        
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "habilidade : habilidadeId=" + habilidadeId + ", nome=" + nome ;
    }

    

    
}
