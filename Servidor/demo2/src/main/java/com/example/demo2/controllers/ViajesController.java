package com.example.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo2.services.ViajesService;

@Controller
public class ViajesController {

	
	@Autowired ViajesService viajesService;
	public ViajesController() {		
		
	}
	
	
	@GetMapping("/viajes")
	public String verpagviajes(ModelMap modelo) {
		modelo.addAttribute("lstviajes",viajesService.getLstViajes());
		return "listaviajes";
	}
}
