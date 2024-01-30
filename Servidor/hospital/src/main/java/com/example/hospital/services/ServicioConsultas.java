package com.example.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.hospital.entities.Consulta;
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
	
	public Medico MedicoID(int id){				
		return repoMedico.findById(id).get();			
	}
	public Medico medicoUser(String user){	
		 return repoMedico.findByUser(user);
	}
	public void guardarDatos(int id, String user,String password) {
		repoMedico.actualizarDatos(id, user,password);
	}
	public Medico medicoLogin(String user,String password) {
		Medico m=repoMedico.findByUser(user);
		if(m==null) {
			return null;
		}
		if(m.getPassword().equals(password)) {
			return m;
		}
		return null;
	}

	public List<Consulta> consultas(Medico m) {
	    return repoConsulta.findByMedico(m);
	}

}
