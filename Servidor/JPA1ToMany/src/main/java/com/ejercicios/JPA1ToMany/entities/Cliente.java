package com.ejercicios.JPA1ToMany.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {
	
	@Id
	private String dni;
	
	
	private String nombre;
	
	private String email;
	
	/*
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos= new ArrayList<Pedido>();
	*/
	
	
	

}
