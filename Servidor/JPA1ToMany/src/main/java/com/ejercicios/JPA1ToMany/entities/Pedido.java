package com.ejercicios.JPA1ToMany.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double total;
	
	private LocalDateTime fecha;
	
	//private String dni_cliente;

	/*
	
	@ManyToOne
	@JoinColumn(name="dni_cliente")
	private Cliente cliente;
	*/
}
