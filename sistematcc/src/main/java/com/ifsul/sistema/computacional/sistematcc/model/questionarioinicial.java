package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
        name = "questpergunta",
        uniqueConstraints = @UniqueConstraint(columnNames = {"perguntaQuestId","questionarioId"}),
        joinColumns =  @JoinColumn(name = "questionarioId"),
        inverseJoinColumns = @JoinColumn(name = "perguntaQuestId")
    )
    @JsonManagedReference
    private List<perguntaquestionario> perguntasQuestionario;

    @ManyToMany
    @JoinTable(
        name = "registroquestinicial",
        uniqueConstraints = @UniqueConstraint(columnNames = {"alunoId","questionarioId"}),
        joinColumns =  @JoinColumn(name = "questionarioId"),
        inverseJoinColumns = @JoinColumn(name = "alunoId")
    )
    @JsonManagedReference
    private List<aluno> alunos;
    
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

    public List<perguntaquestionario> getPerguntasQuestionario() {
        return perguntasQuestionario;
    }

    public void setPerguntasQuestionario(List<perguntaquestionario> perguntasQuestionario) {
        this.perguntasQuestionario = perguntasQuestionario;
    }

    public List<aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<aluno> alunos) {
        this.alunos = alunos;
    }

   

    
}
