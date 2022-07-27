package com.stefanini.hackathon.principal;

import com.stefanini.hackathon.heranca.Aluno;
import com.stefanini.hackathon.heranca.Funcionario;
import com.stefanini.hackathon.heranca.Professor;

public class MainHeranca {
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		
		aluno.setIdade(24);
		aluno.setPrimeiroNome("Diogo");
		aluno.setSobrenome("Marcelo");
		aluno.setMatricula(2022150);
		
		Funcionario professor = new Professor();
		professor.setIdade(30);
		professor.setPrimeiroNome("Cleyton");
		professor.setSobrenome("Caetano");
		professor.setSalario(6.500f);
		
		System.out.println(aluno.getMatricula());
		
		System.out.println(professor.getSalario());
		
		
	}
	
	
}
