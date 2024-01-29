package com.example.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entities.Medico;
import com.example.hospital.repositories.ConsultaRepository;
import com.example.hospital.repositories.MedicoRepository;
import com.example.hospital.repositories.PacienteRepository;


@Service
public class ServicioConsultas {
	@Autowired MedicoRepository repoMedico;
	@Autowired PacienteRepository repoPaciente;
	@Autowired ConsultaRepository repoConsulta;
	
	public List<Medico> todosMedicos(){				
		return repoMedico.findAll();			
	}
}
