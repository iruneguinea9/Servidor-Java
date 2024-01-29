package com.ejemplos.demoJPA.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.demoJPA.entities.Ciudad;
import com.ejemplos.demoJPA.entities.Empleado;
import com.ejemplos.demoJPA.repositories.CiudadRepository;
import com.ejemplos.demoJPA.repositories.EmpleadoRepository;

@Service
public class ServicioEmpleados {
	
	@Autowired CiudadRepository repoCiudad;
	@Autowired EmpleadoRepository repoEmpleado;
	
	
	
	public List<Ciudad> todasCiudades(){				
		return repoCiudad.findAll();			
	}
	
	
	
	public List<Empleado> todosEmpleadosSalarioMin(double salMin){		
			//return repoEmpleado.findBySalarioGreaterThan(salMin);
			return repoEmpleado.findAll();
	}
	
	public ArrayList<String> nombresCiudades(){
		return repoCiudad.nombres_ciudades();
	}
	
	public void subirSalario(int idEmpleado, int porc) {
		repoEmpleado.subirSalario(idEmpleado, porc);
	}
	
	
	
	
	public void guardarEmpleado(Empleado nuevoEmpleado) {		
		repoEmpleado.save(nuevoEmpleado);		
	}
	

}
