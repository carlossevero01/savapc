package com.ifsul.sistema.computacional.sistematcc.model;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class perguntasQuestForm {
	private String matricula;
	private int turmaId;
	private List<perguntaquestionario> perguntas;
	
	
	
	

	

	public int getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}

	


	@Override
	public String toString() {
		return "perguntasForm [matricula=" + matricula + ", turmaId=" + turmaId + ", perguntas=" + perguntas
				+ "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<perguntaquestionario> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<perguntaquestionario> perguntas) {
		this.perguntas = perguntas;
	}

	
	
}
