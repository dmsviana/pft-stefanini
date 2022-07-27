package com.stefanini.hackathon.polimorfismo;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Quadrado q = new Quadrado();
		Triangulo t = new Triangulo();
		Forma f = t;
		
		if (f.getClass().equals(Quadrado.class)) {
			Quadrado q2 = (Quadrado)f;
		} else
			System.out.println("não é uma instância de quadrado");
		
		System.out.println("ok");
		
		Scanner leitor = new Scanner(System.in);
		String opcao = leitor.nextLine();
		if(opcao.equals("quadrado")) {
			Desenho.desenharQuadrado();
		} else {
			Desenho.desenharCirculo();
		}
		Desenho.desenhar(opcao);
	}

}
