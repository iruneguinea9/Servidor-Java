package com.example.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

import com.example.hospital.entities.Medico;
import com.example.hospital.services.ServicioConsultas;

import jakarta.servlet.http.HttpSession;

@Controller
public class ConsultasController {
	@Autowired ServicioConsultas servicio;
	
	
	
	@GetMapping("/medicos")
	public String verMedicos(ModelMap modelo) {
		modelo.addAttribute("medicos",servicio.todosMedicos());
		return "medicos";
	}
	
	@GetMapping("/registrar/{id}")
		public String registrar(ModelMap modelo,@PathVariable Integer id) {		
		modelo.addAttribute("medico",servicio.MedicoID(id));
		return "registromedico";
	}
	
	@PostMapping("/registrarMedico/{id}")
	public String registrarMedico(@PathVariable int id,@RequestParam String user,@RequestParam String password,@RequestParam String password2) {
		if(password.equals(password2)) {
			// la contraseña esta bien repetida
			if(servicio.medicoUser(user)==null) {
				// esta libre el usuario
				servicio.guardarDatos(id, user, password2);
				return "redirect:/medicos";
			}
			return "redirect:/registrar/"+id;
		}
		else {
			// la contraseña está mal repetida
			return "redirect:/registrar/"+id;
		}
		
		
		
}
	
	@GetMapping("/login")
	public String login(ModelMap modelo) {
		return "login";
	}
	@PostMapping("/loginMedico")
	public String loginMedico(ModelMap modelo, HttpSession session, @RequestParam String user, @RequestParam String password) {
	    Medico m = servicio.medicoLogin(user, password);
	    if(m == null) {
	        //login incorrecto
	        modelo.addAttribute("error","Usuario o contraseña incorrectos");
	        return "login";
	    } else {
	        //login correcto
	        session.setAttribute("medico", m);
	        
	    }
	    return "redirect:/consultas";
	}
	
	@GetMapping("/consultas")
	public String consultas(ModelMap modelo,HttpSession session) {
		Medico m = (Medico)session.getAttribute("medico");
		if(m==null) {				
			return "login";
		}
		
		
		modelo.addAttribute("consultas",servicio.consultas(m));
		return "consultas";
	}
	@PostMapping("/guardarDiagnostico")
	public String guardarDiagnostico(ModelMap modelo, HttpSession session, @RequestParam String diagnosticoInput, @RequestParam int idConsulta ) {
		servicio.guardarDiagnostico(idConsulta,diagnosticoInput);
		
		return "redirect:/consultas";
	}
	@GetMapping("/anular/{id}")
	public String anular(ModelMap modelo,@PathVariable Integer id) {		
		servicio.anularCita(id);
		return "redirect:/consultas";
}
	
}
