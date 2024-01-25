package com.example.ponencias.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ponencias.beans.Ponencia;
import com.example.ponencias.services.Servicio;

import jakarta.validation.Valid;

@SessionAttributes("organizarPonencia,mapa")

@Controller
public class Controlador {
	@Autowired Servicio servicio;
	

	@GetMapping("/ponencias")
	public String ponencias(ModelMap modelo) {
	    modelo.addAttribute("mapaPonencias", servicio.getMapa());
	    Ponencia ponencia = new Ponencia();
	    modelo.addAttribute("ponencia", ponencia);
	    return "listaponencias";
	}

	@PostMapping("/nuevaPonencia")
	public String aniadirPonencia(@Valid @ModelAttribute ("ponencia") Ponencia ponencia,
								BindingResult result,
								ModelMap modelo) {		
				
		if (!servicio.aniadirPonencia(ponencia)) {
			modelo.addAttribute("erroraniadir", "Ponencia " + ponencia.getTitulo() + " ya existe");
			modelo.addAttribute("mapaPonencias",servicio.getMapa());
			return "listaponencias";
		} else {
			return "redirect:/ponencias";
		}
		
	}
	
	@GetMapping("/organizarPonencia/{titulo}")
	public String organizarPonencia(@PathVariable String titulo, ModelMap modelo ) {
		
		Ponencia p = servicio.buscarPonencia(titulo);
		modelo.addAttribute("organizarPonencia",p);  
		modelo.addAttribute("mapa",servicio.getMapa());  
		return "organizarPonencia";
	
	}
	
	@PostMapping("/aniadeAsistentes")
	public String aniadeAsistentes(@RequestParam int asistentes,String tituloPonencia, ModelMap modelo) {
	    Ponencia p= servicio.buscarPonencia(tituloPonencia);
	    if(!servicio.aniadirAsistentes(p,asistentes)) {
	    	// se supera el aforo
	    	modelo.addAttribute("errorAforo","No se puedo añadir, superado el aforo permitido");
	    }
	    modelo.addAttribute("organizarPonencia", p);
	    //return "listaponencias";
	    return "redirect:/organizarPonencia/"+p.getTitulo();
	}

	
}
