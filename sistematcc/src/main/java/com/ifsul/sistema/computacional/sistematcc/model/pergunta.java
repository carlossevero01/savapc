package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name = "pergunta")
public class pergunta implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perguntaId")
    private int perguntaId;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(
        name = "habilidadepergunta",
        uniqueConstraints = @UniqueConstraint(columnNames = {"habilidadeId","perguntaId"}),
        joinColumns =  @JoinColumn(name = "perguntaId"),
        inverseJoinColumns = @JoinColumn(name = "habilidadeId")
    )
    @JsonManagedReference
    private List<habilidade> habilidades;
    
    
    
    @ManyToMany
    @JoinTable(
        name = "perguntateste",
        uniqueConstraints = @UniqueConstraint(columnNames = {"perguntaId","testeId"}),
        joinColumns =  @JoinColumn(name = "perguntaId"),
        inverseJoinColumns = @JoinColumn(name = "testeId")
    )
    @JsonBackReference
    private List<teste> testes;

    @ManyToMany
    @JoinTable(
        name = "opcaorespostapergunta",
        uniqueConstraints = @UniqueConstraint(columnNames = {"perguntaId","opcaoRespostaId"}),
        joinColumns =  @JoinColumn(name = "perguntaId"),
        inverseJoinColumns = @JoinColumn(name = "opcaoRespostaId")
    )
    @JsonManagedReference
    private List<opcaoresposta> opcoesResposta;
   
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "registroId", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
    private registro registro;
    

    @Override
    public String toString() {
        return "pergunta [perguntaId=" + perguntaId + ", descricao=" + descricao + ", habilidades=" + habilidades
                + ", testes=" + testes + ", opcoesResposta=" + opcoesResposta + ", registroteste=" + registro
                + "]";
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public pergunta() {
    }

    public pergunta(String descricao) {
        this.descricao = descricao;
    }

    public List<habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<teste> getTestes() {
        return testes;
    }

    public void setTestes(List<teste> testes) {
        this.testes = testes;
    }

    public List<opcaoresposta> getOpcoesResposta() {
        return opcoesResposta;
    }

    public void setOpcoesResposta(List<opcaoresposta> opcoesResposta) {
        this.opcoesResposta = opcoesResposta;
    }

    public registro getRegistro() {
        return registro;
    }

    public void setRegistroteste(registro registroteste) {
        this.registro = registroteste;
    }

    

    

    
}
