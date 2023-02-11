package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "questionarioInicial")
public class questionarioinicial implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionarioId;

    @Column(nullable = false)
    private LocalDate disponibilidade;

    @Column(nullable = false)
    private boolean visibilidade;

    @Column(nullable = false)
    private String nome;

    public int getQuestionarioId() {
        return questionarioId;
    }

    public void setQuestionarioId(int questionarioId) {
        this.questionarioId = questionarioId;
    }

    public LocalDate getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(LocalDate disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public questionarioinicial(LocalDate disponibilidade, boolean visibilidade, String nome) {
        this.disponibilidade = disponibilidade;
        this.visibilidade = visibilidade;
        this.nome = nome;
    }

    public questionarioinicial() {
    }

    @Override
    public String toString() {
        return "questionarioinicial : questionarioId=" + questionarioId + ", disponibilidade=" + disponibilidade
                + ", visibilidade=" + visibilidade + ", nome=" + nome ;
    }

   

    
}
