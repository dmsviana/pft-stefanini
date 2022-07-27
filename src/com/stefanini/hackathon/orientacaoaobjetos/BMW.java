package com.stefanini.hackathon.orientacaoaobjetos;

public class BMW extends Carro{
	
	
	@Override
	public double calcularTaxaAceleracao(double velocidadeFinal, double velocidadeInicial, double tempoFinal, double tempoInicial) {
		return (velocidadeFinal - velocidadeInicial) / (tempoFinal - tempoInicial) * 3.6;
		
	}
	
	
}
