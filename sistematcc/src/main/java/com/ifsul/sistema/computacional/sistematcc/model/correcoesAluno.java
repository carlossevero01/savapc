package com.ifsul.sistema.computacional.sistematcc.model;

public class correcoesAluno {
    
    private int alunoId;
    private int testeId;
    private String testeNome;
    private int perguntaId;
    private int opRespostaId;
    private boolean acertou;
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + alunoId;
        result = prime * result + testeId;
        result = prime * result + ((testeNome == null) ? 0 : testeNome.hashCode());
        result = prime * result + perguntaId;
        result = prime * result + opRespostaId;
        result = prime * result + (acertou ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        correcoesAluno other = (correcoesAluno) obj;
        if (alunoId != other.alunoId)
            return false;
        if (testeId != other.testeId)
            return false;
        if (testeNome == null) {
            if (other.testeNome != null)
                return false;
        } else if (!testeNome.equals(other.testeNome))
            return false;
        if (perguntaId != other.perguntaId)
            return false;
        if (opRespostaId != other.opRespostaId)
            return false;
        if (acertou != other.acertou)
            return false;
        return true;
    }
    
    
    @Override
    public String toString() {
        return "[alunoId="+alunoId+"\t testeId="+testeId + "\t testeNome=" + testeNome+ "\t perguntaId=" + perguntaId+" |" + "\n|opRespostaId=" + opRespostaId + "\t acertou=" + acertou+"]";
    }
    public correcoesAluno(int alunoId, int testeId, String testeNome, int perguntaId, int opRespostaId, boolean acertou) {
        this.alunoId = alunoId;
        this.testeId = testeId;
        this.testeNome = testeNome;
        this.perguntaId = perguntaId;
        this.opRespostaId = opRespostaId;
        this.acertou = acertou;
        
    }
   
    public correcoesAluno() {
        this.alunoId=0;
        this.testeId=0;
        this.testeNome="";
        this.perguntaId=0;
        this.opRespostaId=0;
        this.acertou=false;
        
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
    public String getTesteNome() {
        return testeNome;
    }
    public void setTesteNome(String testeNome) {
        this.testeNome = testeNome;
    }
    public int getPerguntaId() {
        return perguntaId;
    }
    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }
    public int getOpRespostaId() {
        return opRespostaId;
    }
    public void setOpRespostaId(int opRespostaId) {
        this.opRespostaId = opRespostaId;
    }
    public boolean isAcertou() {
        return acertou;
    }
    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }
   

    
}
