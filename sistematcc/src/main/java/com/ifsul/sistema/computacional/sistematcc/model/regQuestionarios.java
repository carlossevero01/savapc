package com.ifsul.sistema.computacional.sistematcc.model;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;


@Entity
@Table(name = "regQuestionarios")
public class regQuestionarios implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regQuestionarioId")
    private int regQuestionarioId;

    @ManyToOne
    @JoinColumn(name = "questionarioId")
    private questionarioinicial questionario;

    @ManyToOne
    @JoinColumn(name = "alunoId")
    private aluno aluno;

    @ManyToOne
    @JoinColumn(name = "turmaId")
    private turma turma;
   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "regQuestionarios_RespostaQuestionario",
            joinColumns = @JoinColumn(
                    name = "regQuestionarioId", referencedColumnName = "regQuestionarioId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "respostaQuestionarioId", referencedColumnName = "respostaQuestionarioId"
            )
    )
    private List<respostaQuestionarios> respostasQuestionario;


    public aluno getAluno() {
        return aluno;
    }

    public void setAluno(aluno aluno) {
        this.aluno = aluno;
    }

    public regQuestionarios() {
        super();
    }

    public turma getTurma() {
        return turma;
    }

    public void setTurma(turma turma) {
        this.turma = turma;
    }

    public int getRegQuestionarioId() {
        return regQuestionarioId;
    }

    public void setRegQuestionarioId(int regQuestionarioId) {
        this.regQuestionarioId = regQuestionarioId;
    }

    public questionarioinicial getQuestionario() {
        return questionario;
    }

    public void setQuestionario(questionarioinicial questionario) {
        this.questionario = questionario;
    }

    public List<respostaQuestionarios> getRespostasQuestionario() {
        return respostasQuestionario;
    }

    public void setRespostasQuestionario(List<respostaQuestionarios> respostasQuestionario) {
        this.respostasQuestionario = respostasQuestionario;
    }

   

    
}
