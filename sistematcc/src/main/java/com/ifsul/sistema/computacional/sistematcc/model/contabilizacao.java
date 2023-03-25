package com.ifsul.sistema.computacional.sistematcc.model;

public class contabilizacao {
    private int alunoId;
    private int testeId;
    private int nQcorretas;
    private int nQChab1;
    private int nQChab2;
    private int nQChab3;
    private int nQChab4;
    private int nQChab5;
    private int nQ;
    private double valorTotal;
    private String recomendacao;
    
    public contabilizacao() {
        super();
        this.nQcorretas=0;
        this.nQChab1=0;
        this.nQChab2=0;
        this.nQChab3=0;
        this.nQChab4=0;
        this.nQChab5=0;
        this.nQ=0;
        this.recomendacao="";
    }
    public contabilizacao(int alunoId, int testeId, int nQcorretas, int nQChab1, int nQChab2, int nQChab3, int nQChab4,
            int nQChab5, int nQ) {
        super();
        this.alunoId = alunoId;
        this.testeId = testeId;
        this.nQcorretas = nQcorretas;
        this.nQChab1 = nQChab1;
        this.nQChab2 = nQChab2;
        this.nQChab3 = nQChab3;
        this.nQChab4 = nQChab4;
        this.nQChab5 = nQChab5;
        this.nQ = nQ;
        this.valorTotal= Double.valueOf(nQcorretas)/Double.valueOf(nQ)*100; 
        this.valorTotal =  Double.parseDouble(String.format("%.2f",this.valorTotal).replace(",","."));    
          
        if(this.valorTotal>=60) {this.recomendacao="Alfabetizado em Codigo";}else{this.recomendacao="nao desenvolveu habilidades";}
    } 
    @Override
        public String toString() {
            return "\ncontabilizacao: \n alunoId=" + alunoId + "\n testeId=" + testeId + "\n nQcorretas=" + nQcorretas
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
    public int getAlunoId() {
        return alunoId;
    }



    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }



    public int getTesteId() {
        return testeId;
    }



    public void setTesteId(int testeId) {
        this.testeId = testeId;
    }



    public int getnQ() {
        return nQ;
    }



    public void setnQ(int nQ) {
        this.nQ = nQ;
    }

    
}
