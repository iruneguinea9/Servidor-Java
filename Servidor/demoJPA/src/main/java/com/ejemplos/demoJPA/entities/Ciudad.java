package com.ejemplos.demoJPA.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Ciudad {
	
	@Id
	private String nombre;
	
	private String poblacion;
	


	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", poblacion=" + poblacion + "]";
	}
	
	

}
