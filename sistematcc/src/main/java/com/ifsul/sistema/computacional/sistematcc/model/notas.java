package com.ifsul.sistema.computacional.sistematcc.model;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notas")
public class notas {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notaId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alunoId", referencedColumnName = "alunoId")
    private aluno aluno;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="turmaId")
    private turma turma;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "testes_nota",
            joinColumns = @JoinColumn(
                    name = "notaId", referencedColumnName = "notaId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "testeId", referencedColumnName = "testeId"
            )
    )
    private Set<teste> testes = new HashSet<>();

    
    
    
    private int nPerguntasCorretas;

    private int nPerguntas;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int h5; 
     
    private double notaProjetoFinal;

    private double notaTestes;
    private double pesoTestes;
    private double notaFinal;

    private String recomendacao;

    public int getNotaId() {
        return notaId;
    }

    public void setNotaId(int notaId) {
        this.notaId = notaId;
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

    

    public double getNotaProjetoFinal() {
        return notaProjetoFinal;
    }

    public void setNotaProjetoFinal(double notaProjetoFinal) {
        this.notaProjetoFinal = notaProjetoFinal;
    }

    public double getNotaTestes() {
        return notaTestes;
    }

    public void setNotaTestes(double notaTestes) {
        this.notaTestes = notaTestes;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public notas() {
        super();
    }

    

    public int getH1() {
        return h1;
    }

    public void setH1(int h1) {
        this.h1 = h1;
    }

    public int getH2() {
        return h2;
    }

    public void setH2(int h2) {
        this.h2 = h2;
    }

    public int getH3() {
        return h3;
    }

    public void setH3(int h3) {
        this.h3 = h3;
    }

    public int getH4() {
        return h4;
    }

    public void setH4(int h4) {
        this.h4 = h4;
    }

    public int getH5() {
        return h5;
    }

    public void setH5(int h5) {
        this.h5 = h5;
    }

    public int getnPerguntasCorretas() {
        return nPerguntasCorretas;
    }

    public void setnPerguntasCorretas(int nPerguntasCorretas) {
        this.nPerguntasCorretas = nPerguntasCorretas;
    }

    public int getnPerguntas() {
        return nPerguntas;
    }

    public void setnPerguntas(int nPerguntas) {
        this.nPerguntas = nPerguntas;
    }

    public notas(aluno aluno, turma turma,  double npC, double np, double notaProjetoFinal,
            double notaTestes, double notaFinal, String recomendacao) {  
        this.aluno = aluno;
        this.turma = turma;
       
        this.nPerguntasCorretas=(int) npC;
        this.nPerguntas=(int) np;
        this.notaProjetoFinal = notaProjetoFinal;
        this.notaTestes = notaTestes;
        this.notaFinal= notaFinal;
        this.recomendacao=recomendacao;
    }

    @Override
    public String toString() {
        return "notas [notaId=" + notaId + ", aluno=" + aluno + ", turma=" + turma + ", nPerguntasCorretas=" + nPerguntasCorretas + ", nPerguntas=" + nPerguntas + "\n h1=" + h1 + ", h2="
                + h2 + ", h3=" + h3 + ", h4=" + h4 + ", h5=" + h5 + "\n notaProjetoFinal=" + notaProjetoFinal
                + ", notaTestes=" + notaTestes + ", notaFinal=" + notaFinal + "\n recomendacao=" + recomendacao + "]";
    }

    public double getPesoTestes() {
        return pesoTestes;
    }

    public void setPesoTestes(double pesoTestes) {
        this.pesoTestes = pesoTestes;
    }

   

    public Set<teste> getTestes() {
        return testes;
    }

    public void setTestes(Set<teste> testes) {
        this.testes = testes;
    }

   

    

    
}
