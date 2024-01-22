package com.example.demo3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo3.beans.Viaje;
import com.example.demo3.services.ViajesService;

import ch.qos.logback.core.model.Model;

@Controller
public class ViajesController {

	
	@Autowired ViajesService viajesService;
	
	
	
	@GetMapping("/viajes")
	public String verpagviajes(ModelMap modelo) {
		modelo.addAttribute("lstviajes",viajesService.getLstViajes());
		return "listaviajes";
	}
	
	
	
	@PostMapping("/nuevoviaje")
	public String aniadirViaje(@RequestParam String lugar,
						@RequestParam int dias,@RequestParam int kms,
						ModelMap modelo) {
		
		Viaje vNuevo=new Viaje(lugar, dias, kms);
		if (!viajesService.aniadirViaje(vNuevo)) {
			modelo.addAttribute("erroraniadir", "Viaje a " + lugar + " ya existe");
			modelo.addAttribute("lstviajes",viajesService.getLstViajes());
			return "listaviajes";
		} else {
			return "redirect:/viajes";
		}
	}
	
	@GetMapping("/borrarViaje")
	public String borrarViaje(@RequestParam String lugar) {
		viajesService.borrarViaje(lugar);	
		return "redirect:/viajes";
	}
	
	@GetMapping("/editarViaje")
	public String cargarPagEdicionViaje(@RequestParam String lugar, ModelMap modelo) {
		
		Viaje vEditar = viajesService.viajeA(lugar);
		modelo.addAttribute("viajeedit", vEditar);
		return "edicionviaje";
	}
	
	@PostMapping("/editarViaje")
	public String editarViaje(@RequestParam String lugar, ModelMap modelo) {
		
	}
	
}
