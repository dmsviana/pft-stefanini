package com.stefanini.hackathon.orientacaoaobjetos;

public class Carro {
	private String marca;
	private String modelo;
	private int chassi;
	private String placa;
	private int roda;
	private int bancos;
	private int velocidade;
	
	public Carro(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	public Carro() {
		System.out.println("Construindo um construtor");
	}

	public void acelerar() {
		System.out.println("Acelerando...");
	}
	
	public void frear() {
		System.out.println("Freando...");
	}
	
	public double calcularTaxaAceleracao(double velocidadeFinal, double velocidadeInicial, double tempoFinal, double tempoInicial) {
		return (velocidadeFinal - velocidadeInicial) / (tempoFinal - tempoInicial) * 3.6;
	}
	
	public double calcularTaxaAceleracao(double velocidadeFinal, double tempoFinal) {
		return (velocidadeFinal - 0) / (tempoFinal - 0) * 3.6;
	}


	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public Carro(String marca, String modelo, int chassi, String placa, int roda, int bancos) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.placa = placa;
		this.roda = roda;
		this.bancos = bancos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getChassi() {
		return chassi;
	}

	public void setChassi(int chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getRoda() {
		return roda;
	}

	public void setRoda(int roda) {
		this.roda = roda;
	}

	public int getBancos() {
		return bancos;
	}

	public void setBancos(int bancos) {
		this.bancos = bancos;
	}

	public String toString() {
		return "Marca: " + marca + "\nModelo: " + modelo + "\nChassi: " + chassi + "\nBancos: " + bancos + "\nPlaca: "
				+ placa + "\nRoda: " + roda;
	}

}
