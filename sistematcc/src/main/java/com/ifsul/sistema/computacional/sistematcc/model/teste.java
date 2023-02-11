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
@Table (name = "teste")
public class teste implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testeId;

    @Column(nullable = false)
    private boolean visibilidade;

    @Column(nullable = false)
    private LocalDate disponibilidade;

    public int getTesteId() {
        return testeId;
    }

    public void setTesteId(int testeId) {
        this.testeId = testeId;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public LocalDate getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(LocalDate disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public teste(boolean visibilidade, LocalDate disponibilidade) {
        this.visibilidade = visibilidade;
        this.disponibilidade = disponibilidade;
    }

    public teste() {
    }

    @Override
    public String toString() {
        return "teste : testeId=" + testeId + ", visibilidade=" + visibilidade + ", disponibilidade=" + disponibilidade;
    }

    

    
}
