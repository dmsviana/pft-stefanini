package com.stefanini.hackathon.interfaces;

public class Pato extends Animal implements Voador, Nadador {

	public void nadar() {
		
	}

	public void voar() {
		
	}

	public void respirar() {
		
	}

	public void quack() {
		
	}
	
	public static void main(String[] args) {
		Pato p = new Pato();
		Nadador n  = new Sapo();
		Voador v = p;
		v.voar();
		
		v = (Voador)n;
		v.voar();
		System.out.println("ok");
		
		
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
