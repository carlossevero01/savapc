package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name = "habilidade")
public class habilidade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habilidadeId;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
        name = "alunohabilidade",
        uniqueConstraints = @UniqueConstraint(columnNames ={"habilidadeId","alunoId"} ),
        joinColumns =  @JoinColumn(name = "habilidadeId"),
        inverseJoinColumns = @JoinColumn(name = "alunoId")
    )
    @JsonBackReference
    private List<aluno> alunos;
    
    @ManyToMany
    @JoinTable(
        name = "habilidadepergunta",
        uniqueConstraints = @UniqueConstraint(columnNames = {"habilidadeId","perguntaId"}),
        joinColumns =  @JoinColumn(name = "habilidadeId"),
        inverseJoinColumns = @JoinColumn(name = "perguntaId")
    )
    @JsonBackReference
    private List<pergunta> perguntas;
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

    public List<aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<aluno> alunos) {
        this.alunos = alunos;
    }

    public List<pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    

    
}
