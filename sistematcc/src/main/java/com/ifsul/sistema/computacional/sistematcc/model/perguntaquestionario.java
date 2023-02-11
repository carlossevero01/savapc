package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "perguntaQuestionario")
public class perguntaquestionario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int perguntaQuestId;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String tipo;

    public int getPerguntaQuestId() {
        return perguntaQuestId;
    }

    public void setPerguntaQuestId(int perguntaQuestId) {
        this.perguntaQuestId = perguntaQuestId;
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

    public perguntaquestionario() {
    }

    public perguntaquestionario(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "perguntaquestionario : perguntaQuestId=" + perguntaQuestId + ", descricao=" + descricao + ", tipo="
                + tipo;
    }

    

    
}
