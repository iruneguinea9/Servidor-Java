package com.ejercicios.JPA1ToMany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejercicios.JPA1ToMany.services.ServicioPedidos;

import lombok.Getter;

//@Controller
public class ControladorPedidos {
	
	
	@Autowired ServicioPedidos service;
	
	
	@GetMapping("/pedidos")
	
	public String todosPedidos(ModelMap modelo) {		
		modelo.addAttribute("pedidos",service.todosPedidos());
		return "pedidospage";
		
	}
	
	
	@GetMapping("/clientes")	
	public String todosClientes(ModelMap modelo) {		
		modelo.addAttribute("clientes",service.todosClientes());
		return "clientespage";
		
	}
	

}
