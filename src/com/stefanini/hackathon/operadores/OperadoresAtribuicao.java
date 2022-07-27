package com.stefanini.hackathon.operadores;

public class OperadoresAtribuicao {
	public static void main(String[] args) {
		int a = 11;
		
		int b = 5;
		
		b += a;
		b -= a;
		b *= a;
		b /= a;
		b %= a;
		
		System.out.println(a % b);
	}
}
