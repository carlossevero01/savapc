package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import jakarta.persistence.*;
@Entity
@Table (name = "aluno")
public class aluno implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alunoId")
    private int alunoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String matricula;

    @ManyToMany
    @JoinTable(
        name = "alunoturma",
        uniqueConstraints = @UniqueConstraint(columnNames = {"turmaId","alunoId"}),
        joinColumns =  @JoinColumn(name = "alunoId"),
        inverseJoinColumns = @JoinColumn(name = "turmaId")
    )
    @JsonBackReference
    private List<turma> turmas;
    
    @ManyToMany
    @JoinTable(
        name = "alunohabilidade",
        uniqueConstraints = @UniqueConstraint(columnNames = {"habilidadeId","alunoId"}),
        joinColumns =  @JoinColumn(name = "alunoId"),
        inverseJoinColumns = @JoinColumn(name = "habilidadeId")
    )
    @JsonManagedReference
    private List<habilidade> habilidades;


    @ManyToMany
    @JoinTable(
        name = "registroquestinicial",
        uniqueConstraints = @UniqueConstraint(columnNames = {"alunoId","questionarioId"}),
        joinColumns =  @JoinColumn(name = "alunoId"),
        inverseJoinColumns = @JoinColumn(name = "questionarioId")
    )
    @JsonBackReference
    private List<questionarioinicial> questionarios;

    @OneToMany(mappedBy="aluno")
     List<registro> registroteste;

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public aluno() {
        super();
    }

    public aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    

    @Override
    public String toString() {
        return "aluno [alunoId=" + alunoId + ", nome=" + nome + ", matricula=" + matricula + ", turmas=" + turmas
                + ", habilidades=" + habilidades + ", questionarios=" + questionarios + ", registroteste="
                + registroteste + "]";
    }

    public List<turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<turma> turmas) {
        this.turmas = turmas;
    }

    public List<habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<habilidade> habilidades) {
        this.habilidades = habilidades;
    }


    public List<questionarioinicial> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<questionarioinicial> questionarios) {
        this.questionarios = questionarios;
    }

    public List<registro> getRegistroteste() {
        return registroteste;
    }

    public void setRegistroteste(List<registro> registroteste) {
        this.registroteste = registroteste;
    }


    
}
