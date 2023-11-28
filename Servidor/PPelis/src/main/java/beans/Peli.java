package beans;

import java.io.Serializable;

public class Peli implements Serializable {
	
	private String nombre;
	private int entradas;
	
	public Peli() {
		
	}
	
	public int getEntradas() {
		return entradas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
