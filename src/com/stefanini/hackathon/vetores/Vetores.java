package com.stefanini.hackathon.vetores;

public class Vetores {
	public static void main(String[] args) {
		int[] notas = new int[10];
		
		
		notas[0] = 1;
		notas[1] = 5;
		notas[2] = 9;
		notas[3] = 2;
		notas[4] = 6;
		notas[5] = 4;
		notas[6] = 3;
		notas[7] = 7;
		
		
		String[] carros = {"BMW i320", "Tesla", "Celta", "Virtus"};
		
		System.out.println(carros.length);
		
		for(String carro : carros) {
			System.out.println(carro);
		}
		
		
//		for(int i = 0; i < notas.length; i++) {
//			System.out.println(notas[i]);
//		}
	}
}
