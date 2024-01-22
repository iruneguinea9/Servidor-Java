package com.example.demo2.beans;

public class Viaje {
	private String lugar;
	private int dias;
	private int kms;
	
	public Viaje() {
		// TODO Auto-generated constructor stub
	}
	
	public Viaje(String lugar, int dias, int kms) {
		super();
		this.lugar = lugar;
		this.dias = dias;
		this.kms = kms;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}
	
	
	
	

}
