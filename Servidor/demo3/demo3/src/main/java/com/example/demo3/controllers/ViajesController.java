package com.example.demo3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo3.beans.Pais;
import com.example.demo3.beans.Viaje;
import com.example.demo3.beans.Viajero;
import com.example.demo3.services.ViajesService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@SessionAttributes("viajeorganizar")
@Controller
public class ViajesController {

	
	@Autowired ViajesService viajesService;
	
	
	
	
	@ModelAttribute("arrPaises")
	public Pais[] paises() {
		return new Pais[]
				{new Pais("Francia","FR"),
				new Pais("Reino Unido","UK"), 
				new Pais("España","ES")};
	}	
	
	
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
	public String editarViaje(@RequestParam String lugar, @RequestParam int dias,@RequestParam int kms) {
		Viaje vEditar = new Viaje(lugar, dias, kms);
		viajesService.editarViaje(vEditar);
		return "redirect:/viajes";
	}
	
	@GetMapping("/aniadirViajero")
	public String verPagAniadirViajero(@ModelAttribute ("viajero") Viajero viajero,
										ModelMap modelo) {
		modelo.addAttribute("todosviajeros",viajesService.todosViajeros());
		
		viajero.setNombre("Desconocido");
		viajero.setEdad(18);
		return "nuevoviajero";
	}
	
	@PostMapping("/aniadirViajero")
	public String aniadirViajero(@Valid @ModelAttribute ("viajero") Viajero viajero,
								BindingResult result,
								ModelMap modelo) {		
				
		viajesService.aniadirViajero(viajero);	
		modelo.addAttribute("todosviajeros",viajesService.todosViajeros());
		return "nuevoviajero";
		
	}
	
	@GetMapping("/gestionarViaje/{lugar}")
	public String inicioGestionViaje(@PathVariable String lugar, ModelMap modelo ) {
		
		Viaje v=viajesService.viajeA(lugar);
		modelo.addAttribute("viajeorganizar",v);  //Va a la sesion pq está identificado
													//con @SessionAttributes
	
		return "gestionviaje";
	
	}
	
	
	@PostMapping("/aniadeParada")
	public String aniadirParadaDelForm(@RequestParam String parada,
										ModelMap modelo) {
	
		Viaje v=(Viaje) modelo.getAttribute("viajeorganizar");
		v.aniadirParada(parada);
	
		return "redirect:/vergestionviaje";
	}
	
	@GetMapping("/vergestionviaje")
	public String iraljsp(){
		return "gestionviaje";
	}
	
	
	
}
