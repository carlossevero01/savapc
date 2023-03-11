package com.ifsul.sistema.computacional.sistematcc.model;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;


@Entity
@Table(name = "registro")
public class registro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registroId")
    private int registroId;

    @ManyToOne
    @JoinColumn(name = "testeId")
    private teste teste;

    @ManyToOne
    @JoinColumn(name = "alunoId")
    private aluno aluno;

   
    @OneToMany
    @JoinColumn(name = "registroId") // Esta coluna está na tabela "aluno".
    private List<pergunta> perguntas;

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistroId(int registrotesteId) {
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

    public registro(aluno aluno, teste teste, List<pergunta> perguntas) {
        super();
        this.aluno = aluno;
        this.teste = teste;
        this.perguntas = perguntas;
    }
    

    

    

    @Override
    public String toString() {
        return "registro [registroId=" + registroId + ", teste=" + teste + ", aluno=" + aluno + ", perguntas="
                + perguntas + "]";
    }

    public teste getTeste() {
        return teste;
    }

    public void setTeste(teste teste) {
        this.teste = teste;
    }
    


}
