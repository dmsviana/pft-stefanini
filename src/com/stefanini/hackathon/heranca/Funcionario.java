package com.stefanini.hackathon.heranca;

public abstract class Funcionario extends Pessoa{

	private float salario;

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}