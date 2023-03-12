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
    @Column(nullable=false, unique=true)
    private String username;
    @Column(nullable=false)
    private String senha;
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

    //  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //  @JoinTable(name = "TB_USERS_ROLES",
    //          joinColumns = @JoinColumn(name = "user_id"),
    //          inverseJoinColumns = @JoinColumn(name = "role_id"))
    //  private Collection<Role> roles;

    // public Collection<Role> getRoles() {
    //     return roles;
    // }
    // public void setRoles(Collection<Role> roles) {
    //     this.roles = roles;
    // } 
    
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

    public aluno(int alunoId, String nome, String matricula, String username, String password) {
        this.alunoId = alunoId;
        this.nome = nome;
        this.matricula = matricula;
        this.username = username;
        this.senha = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String password) {
        this.senha = password;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "aluno [alunoId=" + alunoId + ", nome=" + nome + ", matricula=" + matricula + "]";
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    
}
