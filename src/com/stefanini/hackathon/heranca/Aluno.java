package com.stefanini.hackathon.heranca;

public class Aluno extends Pessoa{

	private int matricula;

	public int getMatricula() {
		return matricula;
	}

	public void profissao() {
		System.out.println("Eu sou um aluno");
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}