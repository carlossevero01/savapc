package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

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

    @ManyToMany
    @JoinTable(
        name = "questpergunta",
        uniqueConstraints = @UniqueConstraint(columnNames = {"perguntaQuestId","questionarioId"}),
        joinColumns =  @JoinColumn(name = "perguntaQuestId"),
        inverseJoinColumns = @JoinColumn(name = "questionarioId")
    )
    @JsonBackReference
    private List<questionarioinicial> questionarios;

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

    public List<questionarioinicial> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<questionarioinicial> questionarios) {
        this.questionarios = questionarios;
    }

    

    
}
