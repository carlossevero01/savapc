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
@Table(name = "respostaTeste")
public class respostaTeste implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="respostaTesteId")
    private int respostaTesteId;
    @Column(name = "opRespostaId")
    private int opRespostaId;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "perguntaTesteId")
    private perguntaTeste perguntaTeste;
    
    public int getOpRespostaId() {
        return opRespostaId;
    }
    public void setOpRespostaId(int opRespostaId) {
        this.opRespostaId = opRespostaId;
    }
    public respostaTeste() {
        super();
    }
    
    public respostaTeste(int respostaTesteId, int opRespostaId) {
        this.respostaTesteId = respostaTesteId;
        this.opRespostaId = opRespostaId;
        
    }
    public int getRespostaTesteId() {
        return respostaTesteId;
    }
    public void setRespostaTesteId(int respostaId) {
        this.respostaTesteId = respostaId;
    }
   
    @Override
    public String toString() {
        return " [respostaTesteId=" + respostaTesteId + ", opRespostaId=" + opRespostaId + "]";
    }
    public perguntaTeste getPerguntaTeste() {
        return perguntaTeste;
    }
    public void setperguntaTeste(perguntaTeste pergunta) {
        this.perguntaTeste = pergunta;
    }
    
    

}
