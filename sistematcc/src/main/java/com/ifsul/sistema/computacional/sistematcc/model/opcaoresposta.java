package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.UniqueConstraint;
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

    @ManyToMany
    @JoinTable(
        name = "opcaorespostapergunta",
        uniqueConstraints = @UniqueConstraint(columnNames = {"perguntaId","opcaoRespostaId"}),
        joinColumns =  @JoinColumn(name = "opcaoRespostaId"),
        inverseJoinColumns = @JoinColumn(name = "perguntaId")
    )
    @JsonBackReference
    private List<pergunta> perguntas;

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

    public List<pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    

    
}
