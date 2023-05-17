package com.ifsul.sistema.computacional.sistematcc.model;

public class contabilizacaoPorHabilidade {

    private int testeId;
    private String teste;
    private String turma;
    private String aluno;
    private String matricula;
    private int nQ;
    private int nQcorretas;
    private int nQChab1;
    private int nQChab2;
    private int nQChab3;
    private int nQChab4;
    private int nQChab5;
    private double peso;
    private double valorTotal;
    private String recomendacao;
    
    public contabilizacaoPorHabilidade() {
        super();
        this.nQcorretas=0;
        this.nQChab1=0;
        this.nQChab2=0;
        this.nQChab3=0;
        this.nQChab4=0;
        this.nQChab5=0;
        this.nQ=0;
        this.peso=0;
        this.recomendacao="";
    }
    public contabilizacaoPorHabilidade(int testeId,String teste, String turma,String aluno,String matricula,int nQ,  int nQcorretas, int nQChab1, int nQChab2, int nQChab3, int nQChab4,
            int nQChab5, double peso) {
        super();
        this.testeId=testeId;
        this.aluno = aluno;
        this.matricula=matricula;
        this.turma = turma;
        this.teste = teste;
        this.nQcorretas = nQcorretas;
        this.nQChab1 = nQChab1;
        this.nQChab2 = nQChab2;
        this.nQChab3 = nQChab3;
        this.nQChab4 = nQChab4;
        this.nQChab5 = nQChab5;
        this.nQ = nQ;
        this.peso = peso;
        this.valorTotal= Double.valueOf(nQcorretas)/Double.valueOf(nQ)*this.peso; 
        this.valorTotal =  Double.parseDouble(String.format("%.2f",this.valorTotal).replace(",","."));    
          
        if(this.valorTotal>=6) {this.recomendacao="Alfabetizado em Codigo";}else{this.recomendacao="nao desenvolveu habilidades";}
        
    } 
    @Override
        public String toString() {
            return "\ncontabilizacao: \n testeId= "+testeId+"alunoId=" + aluno +"\n turmaId="+turma+ "\n testeId=" + teste + "\n nQcorretas=" + nQcorretas
                    + "\n nQChab1=" + nQChab1 + "\n nQChab2=" + nQChab2 + "\n nQChab3=" + nQChab3 + "\n nQChab4=" + nQChab4
                    + "\n nQChab5=" + nQChab5 +"\n nQ="+nQ+ "\n valorTotal="+(int) valorTotal+"\n recomendacao="+recomendacao+ "]";
        }



    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getRecomendacao() {
        return recomendacao;
    }
    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }
    public int getnQcorretas() {
        return nQcorretas;
    }
    public void setnQcorretas(int nQcorretas) {
        this.nQcorretas = nQcorretas;
    }
    public int getnQChab1() {
        return nQChab1;
    }
    public void setnQChab1(int nQChab1) {
        this.nQChab1 = nQChab1;
    }
    public int getnQChab2() {
        return nQChab2;
    }
    public void setnQChab2(int nQChab2) {
        this.nQChab2 = nQChab2;
    }
    public int getnQChab3() {
        return nQChab3;
    }
    public void setnQChab3(int nQChab3) {
        this.nQChab3 = nQChab3;
    }
    public int getnQChab4() {
        return nQChab4;
    }
    public void setnQChab4(int nQChab4) {
        this.nQChab4 = nQChab4;
    }
    public int getnQChab5() {
        return nQChab5;
    }
    public void setnQChab5(int nQChab5) {
        this.nQChab5 = nQChab5;
    }
    public int getnQ() {
        return nQ;
    }
    public void setnQ(int nQ) {
        this.nQ = nQ;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getTeste() {
        return teste;
    }
    public void setTeste(String teste) {
        this.teste = teste;
    }
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    public String getAluno() {
        return aluno;
    }
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
    public int getTesteId() {
        return testeId;
    }
    public void setTesteId(int testeId) {
        this.testeId = testeId;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
