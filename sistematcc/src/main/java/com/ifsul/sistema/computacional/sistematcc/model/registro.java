package com.ifsul.sistema.computacional.sistematcc.model;


import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
@Entity
@Table(name = "registro")
public class registro implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registroId")
    private int registroId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "testeId", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
    private teste teste;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "alunoId", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
   private aluno aluno;

   @OneToMany(mappedBy="registro")
    private List<pergunta> perguntas;

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistrotesteId(int registrotesteId) {
        this.registroId = registrotesteId;
    }

    public aluno getAluno() {
        return aluno;
    }

    public void setAluno(aluno aluno) {
        this.aluno = aluno;
    }

    public List<pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public registro() {
        super();
    }

    

    public registro(com.ifsul.sistema.computacional.sistematcc.model.aluno aluno,
            com.ifsul.sistema.computacional.sistematcc.model.teste teste, List<pergunta> perguntas) {
        this.aluno = aluno;
        this.teste = teste;
        this.perguntas = perguntas;
    }

    @Override
    public String toString() {
        return "registroteste [registrotesteId=" + registroId + ", aluno=" + aluno + ", perguntas=" + perguntas
                + "]";
    }

    public teste getTeste() {
        return teste;
    }

    public void setTeste(teste teste) {
        this.teste = teste;
    }
    


}
