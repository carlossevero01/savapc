package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "opcaoResposta")
public class opcaoresposta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opcaoRespostaId;

    @Column(nullable = false)
    private String descricao ;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private boolean verdadeira;

    public int getOpcaoRespostaId() {
        return opcaoRespostaId;
    }

    public void setOpcaoRespostaId(int opcaoRespostaId) {
        this.opcaoRespostaId = opcaoRespostaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isVerdadeira() {
        return verdadeira;
    }

    public void setVerdadeira(boolean verdadeira) {
        this.verdadeira = verdadeira;
    }

    public opcaoresposta() {
    }

    public opcaoresposta(String descricao, String tipo, boolean verdadeira) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.verdadeira = verdadeira;
    }

    @Override
    public String toString() {
        return "opcaoresposta : opcaoRespostaId=" + opcaoRespostaId + ", descricao=" + descricao + ", tipo=" + tipo
                + ", verdadeira=" + verdadeira ;
    }

    

    
}
