package com.ejercicios.JPA1ToMany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicios.JPA1ToMany.entities.Cliente;
import com.ejercicios.JPA1ToMany.services.ServicioPedidos;

@RestController
public class ControlRestClientes {
	
	@Autowired ServicioPedidos servicio;
	
	
	@GetMapping("/clientes")
	public List<Cliente> clientes(){
		return servicio.todosClientes();
	}
	
	
	@GetMapping("/clientes/get/{id}")
	public Cliente clienteDeId(@PathVariable String id){
		return servicio.clienteDeId("111A");
	}
	
	
	@PostMapping("/clientes/guardar")
	public Cliente guardarCliente(@RequestBody Cliente cliNuevo) {
		
		return servicio.insertarNuevoCliente(cliNuevo);
	}
	
	@PutMapping("/clientes/actualizar/{id}")
	public Cliente actualizarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
		
		return servicio.actualizarCliente(id,cliente);
		
		
	}
	
	
	
	
	
	
	@PostMapping("/clientes/guardarVarios")
	public List<Cliente> guardarClientes(@RequestBody List<Cliente> lstClientes) {
		
		return servicio.insertarClientes(lstClientes);
	}
	
	
	
	@DeleteMapping("/clientes/borrar/{id}")
	public void borrarCliente(@PathVariable String id) {
			servicio.borrarCliente(id);
		
	}
	

}
