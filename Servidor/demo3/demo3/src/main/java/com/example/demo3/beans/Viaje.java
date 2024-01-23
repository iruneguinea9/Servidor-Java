package com.example.demo3.beans;

import java.util.ArrayList;
import java.util.Objects;

public class Viaje {
	private String lugar;
	private int dias;
	private int kms;
	private ArrayList<String> paradas=new ArrayList<String>();
	
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

	@Override
	public int hashCode() {
		return Objects.hash(lugar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viaje other = (Viaje) obj;
		return Objects.equals(lugar, other.lugar);
	}
	
	public ArrayList<String> getParadas() {
		return paradas;
	}
	
	public void setParadas(ArrayList<String> paradas) {
		this.paradas = paradas;
	}
	
	public void aniadirParada(String parada) {
		if (!paradas.contains(parada))
			paradas.add(parada);
	}
	

}
