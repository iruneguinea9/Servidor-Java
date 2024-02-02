package com.ejercicios.JPA1ToMany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.JPA1ToMany.entities.Cliente;
import com.ejercicios.JPA1ToMany.entities.Pedido;
import com.ejercicios.JPA1ToMany.repositories.ClienteRepo;
import com.ejercicios.JPA1ToMany.repositories.PedidoRepo;

@Service
public class ServicioPedidos {
	
	@Autowired ClienteRepo repoCliente;
	@Autowired PedidoRepo repoPedido;
	
	
	
	
	public ArrayList<Pedido> todosPedidos(){
		
		return (ArrayList<Pedido>) repoPedido.findAll();
	}
	
	
	public ArrayList<Cliente> todosClientes(){
		
		return (ArrayList<Cliente>) repoCliente.findAll();
	}
	
	
	public Cliente clienteDeId(String id) {
		return repoCliente.findById(id).get();
	}
	
	
	public Cliente insertarNuevoCliente(Cliente cliente) {
		return repoCliente.save(cliente);
	}
	
	public List<Cliente> insertarClientes(List<Cliente> lstClientes) {
		
		return repoCliente.saveAll(lstClientes);
	
	}
	
	public void borrarCliente(String id) {
		
		repoCliente.deleteById(id);
	}


	public Cliente actualizarCliente(String id, Cliente cliente) {
		if (!repoCliente.findById(id).isPresent())
			return cliente;
		else
		{
				cliente.setDni(id);
				repoCliente.save(cliente);
				return cliente;
			
		}
	}
	
	
	
	
	

}
