package com.example.ponencias.beans;

import java.time.LocalDate;

public class Ponencia {
	private String titulo; //el identificador
	private int aforo;
	private LocalDate fecha;
	
	public Ponencia() {}
	
	public Ponencia(String titulo,int aforo,LocalDate fecha) {
		this.titulo=titulo;
		this.aforo=aforo;
		this.fecha=fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
