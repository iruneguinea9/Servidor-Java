package com.example.hospital.entities;

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
public class Medico {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String nombre;
	private String especialidad;
	private String user;
	private String password;
}
