package com.ifsul.sistema.computacional.sistematcc.model;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class testeForm {
	private String nome; 
	private LocalDate getDisponibilidade; 
	private boolean visibilidade;
	private List<pergunta> perguntas;

	public List<pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<pergunta> p) {
		this.perguntas = p;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDisponibilidade() {
		return getDisponibilidade;
	}

	public void setDisponibilidade(LocalDate getDisponibilidade) {
		this.getDisponibilidade = getDisponibilidade;
	}

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}

	@Override
	public String toString() {
		return "testeForm [nome=" + nome + ", getDisponibilidade=" + getDisponibilidade + ", visibilidade="
				+ visibilidade + ", perguntas=" + perguntas + "]";
	}

	

	
	

	

	
	
}
