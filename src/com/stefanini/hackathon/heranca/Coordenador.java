package com.stefanini.hackathon.heranca;

public class Coordenador extends Funcionario{

	private String curso;

	public String getCurso() {
		return curso;
	}

	public void profissao() {
		System.out.println("Eu sou um coordenador");
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
}