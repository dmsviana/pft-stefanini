package com.stefanini.hackathon.heranca;

public abstract class Pessoa {

	private String primeiroNome;
	private String sobrenome;
	private int idade;


	public abstract void profissao();
	
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return primeiroNome + " - " + idade;
	}
	
}