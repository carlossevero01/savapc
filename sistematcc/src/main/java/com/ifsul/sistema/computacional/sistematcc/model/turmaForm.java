package com.ifsul.sistema.computacional.sistematcc.model;

import java.util.List;

public class turmaForm {
   
    private int turmaId;
    private String nome;
    private boolean visibilidade;
    private List<teste> testes;
   // private int professorId;
    public int getTurmaId() {
        return turmaId;
    }
    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isVisibilidade() {
        return visibilidade;
    }
    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }
    public List<teste> getTestes() {
        return testes;
    }
    public void setTestes(List<teste> testes) {
        this.testes = testes;
    }

    
}
