package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table (name = "turma")
public class turma implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int turmaId;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private boolean visibilidade;

    @Column(nullable= false)
    private Double pesoTestes;

    @ManyToMany
    @JoinTable(
        name = "alunoturma",
        uniqueConstraints = @UniqueConstraint(columnNames ={"turmaId","alunoId"} ),
        joinColumns =  @JoinColumn(name = "turmaId"),
        inverseJoinColumns = @JoinColumn(name = "alunoId")
    )
    @JsonManagedReference
    private List<aluno> alunos;

    @ManyToMany
    @JoinTable(
        name = "professorturma",
        uniqueConstraints = @UniqueConstraint(columnNames ={"turmaId","professorId"} ),
        joinColumns =  @JoinColumn(name = "turmaId"),
        inverseJoinColumns = @JoinColumn(name = "professorId")
    )
    @JsonManagedReference
    private List<professor> professores;

    @ManyToMany
    @JoinTable(
        name = "testesturma",
        uniqueConstraints = @UniqueConstraint(columnNames = {"turmaId","testeId"}),
        joinColumns =  @JoinColumn(name = "turmaId"),
        inverseJoinColumns = @JoinColumn(name = "testeId")
    )
    @JsonManagedReference
    private List<teste> testes;

    @ManyToMany
    @JoinTable(
        name = "questionarioturmas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"turmaId","questionarioId"}),
        joinColumns =  @JoinColumn(name = "turmaId"),
        inverseJoinColumns = @JoinColumn(name = "questionarioId")
    )
    @JsonManagedReference
    private List<questionarioinicial> questionarios;
    
    @OneToMany(mappedBy="turma")
    @JsonBackReference
     List<regTestes> regTeste;

    

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<notas> notas;

    

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public turma() {
    }

    public turma(String nome, boolean visibilidade, List<teste> testes, double pesoTestes) {
        this.nome = nome;
        this.visibilidade = visibilidade;
        this.testes = testes;
        if(pesoTestes==0){ this.pesoTestes=7.0;}else{ this.pesoTestes=pesoTestes;}
    }

    @Override
    public String toString() {
        return "turma : turmaId=" + turmaId + ", nome=" + nome +", visibilidade="+visibilidade+",pesoTestes="+pesoTestes;
    }

    public List<aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<aluno> alunos) {
        this.alunos = alunos;
    }

    public List<professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<professor> professores) {
        this.professores = professores;
    }

    public boolean isVisibilidade() {
        return this.visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public List<teste> getTestes() {
        return testes;
    }

    public void setTestes(List<teste> testes) {
        this.testes = testes;
    }

    public List<questionarioinicial> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<questionarioinicial> questionarios) {
        this.questionarios = questionarios;
    }

    public List<regTestes> getRegTeste() {
        return regTeste;
    }

    public void setRegTeste(List<regTestes> regTeste) {
        this.regTeste = regTeste;
    }

    

    public List<notas> getNotas() {
        return notas;
    }

    public void setNotas(List<notas> notas) {
        this.notas = notas;
    }

    public Double getPesoTestes() {
        return pesoTestes;
    }

    public void setPesoTestes(Double pesoTestes) {
        this.pesoTestes = pesoTestes;
    }

    

   

    
    

    
}
