package com.stefanini.hackathon.polimorfismo;

public class Quadrado extends Forma{

	private int lado;
	
	public int getLado() {
		return lado;
	}
	
	public void desenhar() {
		System.out.println("________");
		System.out.println("|       |");
		System.out.println("|       |");
		System.out.println("|       |");
		System.out.println("|       |");
		System.out.println("|       |");
		System.out.println("________");
	}
	
}
