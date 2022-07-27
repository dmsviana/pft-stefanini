package com.stefanini.hackathon.polimorfismo;
public class Desenho {

	public static Quadrado desenharQuadrado(){
		return new Quadrado();
	}
	
	public static Circulo desenharCirculo() {
		return new Circulo();
	}
	
	public static Forma desenhar(String op) {
		switch (op) {
		case "quadrado":
			return new Quadrado();
		case "circulo":
			return new Circulo();
		case "triangulo":
			return new Triangulo();
		}
		
		return null;
		
	}
	
}
