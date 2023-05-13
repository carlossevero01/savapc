package com.ifsul.sistema.computacional.sistematcc.model;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;


@Entity
@Table(name = "regTestes")
public class regTestes implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regTestesId")
    private int regTestesId;

    @ManyToOne
    @JoinColumn(name = "testeId")
    private teste teste;

    @ManyToOne
    @JoinColumn(name = "alunoId")
    private aluno aluno;

    @ManyToOne
    @JoinColumn(name = "turmaId")
    private turma turma;
   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "regTestes_RespostaTeste",
            joinColumns = @JoinColumn(
                    name = "regTestesId", referencedColumnName = "regTestesId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "respostaTesteId", referencedColumnName = "respostaTesteId"
            )
    )
    private List<respostaTeste> respostasTeste;

    

    

    public aluno getAluno() {
        return aluno;
    }

    public void setAluno(aluno aluno) {
        this.aluno = aluno;
    }

    public regTestes() {
        super();
    }

    public regTestes(aluno aluno,turma turma, teste teste, List<respostaTeste> respostas) {
        super();
        this.aluno = aluno;
        this.turma= turma;
        this.teste = teste;
        this.respostasTeste = respostas;
    }
    
    @Override
    public String toString() {
        return " [regTestesId=" + regTestesId + ", teste=" + teste.getNome() + ", aluno=" + aluno.getAlunoId() +", turma=" + turma.getTurmaId()+ ", respostaTeste="
                + respostasTeste + "]";
    }

    public teste getTeste() {
        return teste;
    }

    public void setTeste(teste teste) {
        this.teste = teste;
    }

    public int getRegTestesId() {
        return regTestesId;
    }

    public void setRegTestesId(int regTestesId) {
        this.regTestesId = regTestesId;
    }

    public List<respostaTeste> getRespostasTeste() {
        return respostasTeste;
    }

    public void setRespostasTeste(List<respostaTeste> respostasTeste) {
        this.respostasTeste = respostasTeste;
    }

    public turma getTurma() {
        return turma;
    }

    public void setTurma(turma turma) {
        this.turma = turma;
    }

}
