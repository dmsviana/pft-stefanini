package com.stefanini.hackathon.heranca;

public class Professor extends Funcionario{
	


	private String disciplina;

	public String getDisciplina() {
		return disciplina;
	}

	public void profissao() {
		System.out.println("Eu sou um professor");
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}