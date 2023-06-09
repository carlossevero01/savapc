package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table (name = "aluno")
public class aluno implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alunoId")
    private int alunoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false)
    private String email;

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

    @OneToMany(mappedBy="aluno")
    @JsonBackReference
     List<regTestes> regTeste;

     @OneToMany(mappedBy="aluno")
     @JsonBackReference
     List<regQuestionarios> regQuestionarios;

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
        this.matricula="0000";
        this.nome="";
        this.email="";
        this.username="";
        this.senha="";
    }

    
    public aluno(String nome, String matricula,  String email, String username, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.username = username;
        this.senha = senha;
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

    public List<regTestes> getRegTeste() {
        return regTeste;
    }

    public void setRegistroteste(List<regTestes> registroteste) {
        this.regTeste = registroteste;
    }


    public void setRegTeste(List<regTestes> regTeste) {
        this.regTeste = regTeste;
    }

    public List<regQuestionarios> getRegQuestionarios() {
        return regQuestionarios;
    }

    public void setRegQuestionarios(List<regQuestionarios> regQuestionarios) {
        this.regQuestionarios = regQuestionarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   


    
    
}


    