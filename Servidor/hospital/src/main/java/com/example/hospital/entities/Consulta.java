package com.example.hospital.entities;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consulta")
public class Consulta {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	@JoinColumn(name = "idmedico")
	@ManyToOne
	private Medico medico;
	private String idpaciente;
	private LocalDate fecha;
	private String motivo;
	private String diagnostico;
	
	public boolean esFechaPasada() {
		if (this.fecha.isAfter(LocalDate.now()))
			return true;
		return false;
	}
}
