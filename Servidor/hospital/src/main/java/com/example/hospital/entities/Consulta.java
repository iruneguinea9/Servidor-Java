package com.example.hospital.entities;
import java.time.LocalDate;

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
public class Consulta {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private int idmedico;
	private String idpaciente;
	private LocalDate fecha;
	private String motivo;
	private String diagnostico;
}
