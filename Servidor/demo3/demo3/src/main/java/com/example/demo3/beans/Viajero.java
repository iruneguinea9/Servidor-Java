package com.example.demo3.beans;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class Viajero {
	
	@Size(min=3, message="3 caracteres requeridos en el nombre")
	private String nombre;
	
	@Max(value = 130, message="Edad máxima 130")
	@Max(value = 18, message="Edad mínima 18")
	private int edad;
	
	private String pais;
	
	
	
	public Viajero() {
		
	}

	public Viajero(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

}
