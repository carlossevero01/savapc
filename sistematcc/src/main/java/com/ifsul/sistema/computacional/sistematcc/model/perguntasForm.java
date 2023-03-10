package com.ifsul.sistema.computacional.sistematcc.model;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class perguntasForm {
	private String matricula;
	private List<pergunta> perguntas;
	
	public List<pergunta> getPerguntas() {
		return perguntas;
	}
	
	public void setPerguntas(List<pergunta> p) {
		this.perguntas = p;
	}

	

	@Override
	public String toString() {
		return "perguntasForm [matricula=" + matricula + ", perguntas=" + perguntas + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
