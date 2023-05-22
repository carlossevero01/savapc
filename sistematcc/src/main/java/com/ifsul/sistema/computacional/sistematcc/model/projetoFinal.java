package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="projetoFinal")
public class projetoFinal implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projetoId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alunoId", referencedColumnName = "alunoId")
    private aluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turmaId", referencedColumnName = "turmaId")
    private turma turma;

    private double nota;

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public aluno getAluno() {
        return aluno;
    }

    public void setAluno(aluno aluno) {
        this.aluno = aluno;
    }

    public turma getTurma() {
        return turma;
    }

    public void setTurma(turma turma) {
        this.turma = turma;
    }

    public projetoFinal() {
        super();
    }

    public projetoFinal( aluno aluno,
            turma turma, double nota) {
       
        this.aluno = aluno;
        this.turma = turma;
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    



}
