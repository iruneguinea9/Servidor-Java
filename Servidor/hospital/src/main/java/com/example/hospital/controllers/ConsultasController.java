package com.example.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;
import com.example.hospital.services.ServicioConsultas;

@Controller
public class ConsultasController {
	@Autowired ServicioConsultas servicio;
	
	
	
	@GetMapping("/medicos")
	public String verMedicos(ModelMap modelo) {
		modelo.addAttribute("medicos",servicio.todosMedicos());
		return "medicos";
	}
	
	@GetMapping("/registrar")
		public String registrar(ModelMap modelo,int id) {
		
		//modelo.addAttribute();
		return "registromedico.jsp";
	}
	
}
