package com.ifsul.sistema.computacional.sistematcc.model;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class perguntasForm {
	private String matricula;
	private List<perguntaTeste> perguntaTeste;
	
	public List<perguntaTeste> getPerguntas() {
		return perguntaTeste;
	}
	
	public void setPerguntas(List<perguntaTeste> p) {
		this.perguntaTeste = p;
	}

	

	@Override
	public String toString() {
		return "perguntasForm [matricula=" + matricula + ", perguntaTeste=" + perguntaTeste + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
