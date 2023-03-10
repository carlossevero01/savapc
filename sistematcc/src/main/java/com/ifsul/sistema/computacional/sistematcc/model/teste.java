package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name = "teste")
public class teste implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testeId")
    private int testeId;

    @Column(nullable = false)
    private boolean visibilidade;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate disponibilidade;

    @ManyToMany
    @JoinTable(
        name = "perguntateste",
        uniqueConstraints = @UniqueConstraint(columnNames = {"perguntaId","testeId"}),
        joinColumns =  @JoinColumn(name = "testeId"),
        inverseJoinColumns = @JoinColumn(name = "perguntaId")
    )
    @JsonManagedReference
    private List<pergunta> perguntas;

    @OneToMany(mappedBy = "teste", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     List<registro> registroteste;

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
        super();
    }

    

    public List<pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<pergunta> perguntas) {
        this.perguntas = perguntas;
    }

   

    

    @Override
    public String toString() {
        return "teste [testeId=" + testeId + ", visibilidade=" + visibilidade + ", nome=" + nome + ", disponibilidade="
                + disponibilidade + ", perguntas=" + perguntas + ", registroteste=" + registroteste + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<registro> getRegistroteste() {
        return registroteste;
    }

    public void setRegistroteste(List<registro> registroteste) {
        this.registroteste = registroteste;
    }

    

    
}
