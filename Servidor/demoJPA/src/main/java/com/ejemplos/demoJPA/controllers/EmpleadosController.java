package com.ejemplos.demoJPA.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejemplos.demoJPA.entities.Empleado;
import com.ejemplos.demoJPA.services.ServicioEmpleados;

@Controller
public class EmpleadosController {
	
	@Autowired ServicioEmpleados servicio;
	
	/*
	@GetMapping("/ver")
	@ResponseBody
	public String verciudades() {
		return servicio.todasCiudades().toString();
	}
	*/
	
	
	@ModelAttribute("nombres_ciudades")
	public ArrayList<String> nombresCiudades() {
		//return new String[] {"Toronto","New York","Vancouver"};
		return servicio.nombresCiudades();
	}
	
	@ModelAttribute("regiones")
	public Character[] regiones() {
		return new Character[] {'N','S','E','O'};
		
	}
	
	
	
	
	@GetMapping("/empleados")
	public String empleados(ModelMap modelo,
							@ModelAttribute ("nuevoEmpleado") Empleado nuevoEmpleado) {	
		
		modelo.addAttribute("empleados",servicio.todosEmpleadosSalarioMin(20000));		
		
		nuevoEmpleado.setSalario(2000);
		return "empleados2";
		
	}
	
	@PostMapping("/aniadirEmpleado")
	public String aniadirEmplForm(	@ModelAttribute ("nuevoEmpleado") Empleado nuevoEmpleado) {
		
			servicio.guardarEmpleado(nuevoEmpleado);
			return "redirect:/empleados";
			
	}
	
	
	
	@PostMapping("/subirSueldo/{idEmpleado}")
	public String subirSueldo(@PathVariable int idEmpleado,@RequestParam int porc	) {
		
			//return "Subir sueldo a" + idEmpleado + " en " + porc + "%";
			servicio.subirSalario(idEmpleado, porc);
			return "redirect:/empleados";
			
	}
}
