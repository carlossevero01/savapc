package com.ifsul.sistema.computacional.sistematcc.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "resposta")
public class resposta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="respostaId")
    private int respostaId;
    @Column(name = "opRespostaId")
    private int opRespostaId;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "perguntaId")
    private pergunta pergunta;

    












    
    public int getOpRespostaId() {
        return opRespostaId;
    }
    public void setOpRespostaId(int opRespostaId) {
        this.opRespostaId = opRespostaId;
    }
    public resposta() {
        super();
    }
    
    public resposta(int respostaId, int opRespostaId) {
        this.respostaId = respostaId;
        this.opRespostaId = opRespostaId;
        
    }
    public int getRespostaId() {
        return respostaId;
    }
    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }
   
    @Override
    public String toString() {
        return " [respostaId=" + respostaId + ", opRespostaId=" + opRespostaId + "]";
    }
    public pergunta getPergunta() {
        return pergunta;
    }
    public void setPergunta(pergunta pergunta) {
        this.pergunta = pergunta;
    }
    
    

}
