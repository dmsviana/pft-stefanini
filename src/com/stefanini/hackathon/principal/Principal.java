package com.stefanini.hackathon.principal;

import com.stefanini.hackathon.orientacaoaobjetos.Carro;

public class Principal {
	public static void main(String[] args) {
		Carro bmw = new Carro();
		
		bmw.setMarca("BMW");
		bmw.setBancos(6);
		bmw.setChassi(23413);
		bmw.setModelo("Esportivo");
		bmw.setPlaca("ABC1234");
		bmw.setRoda(18);
		
		
		Carro mercedes = new Carro();
		mercedes.setMarca("Mercedes");
		mercedes.setBancos(6);
		mercedes.setChassi(23413);
		mercedes.setModelo("Esportivo");
		mercedes.setPlaca("ABC1234");
		mercedes.setRoda(18);
		
		
		
		
		System.out.println(bmw.toString());
		System.out.println(mercedes.toString());
	}
}
