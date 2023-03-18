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

   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "registro_respostas",
            joinColumns = @JoinColumn(
                    name = "registroId", referencedColumnName = "registroId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "respostaId", referencedColumnName = "respostaId"
            )
    )
    private List<resposta> respostas;

    

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

    public List<resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<resposta> respostas) {
        this.respostas = respostas;
    }

    public registro() {
        super();
    }

    public registro(aluno aluno, teste teste, List<resposta> respostas) {
        super();
        this.aluno = aluno;
        this.teste = teste;
        this.respostas = respostas;
    }
    
    @Override
    public String toString() {
        return " [registroId=" + registroId + ", teste=" + teste.getNome() + ", aluno=" + aluno.getAlunoId() + ", respostas="
                + respostas + "]";
    }

    public teste getTeste() {
        return teste;
    }

    public void setTeste(teste teste) {
        this.teste = teste;
    }
    


}
