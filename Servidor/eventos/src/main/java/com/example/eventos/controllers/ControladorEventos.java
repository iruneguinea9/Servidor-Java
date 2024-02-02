package com.example.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventos.entities.Evento;
import com.example.eventos.entities.Venta;
import com.example.eventos.services.ServicioEventos;


@RestController
public class ControladorEventos {

	@Autowired ServicioEventos servicio;
	
	
	/* ---------- PARTE DE EVENTOS ----------- */
	@GetMapping("/eventos")
	public List<Evento> eventos(){
		return servicio.todosEventos();
	}
	
	
	@GetMapping("/eventos/future")
	public List<Evento> eventosFuturos(){
		return servicio.eventosFuturos();
	}
	
	@PostMapping("/eventos/nuevo")
	public Evento guardarEvento(@RequestBody Evento evPasado) {
		
		return servicio.guardarEvento(evPasado);
	}

	@PutMapping("/eventos/update/{id}")
	public Evento actualizarEvento(@PathVariable int id, @RequestBody Evento ev) {
		
		return servicio.actualizarEvento(id,ev);
		
	}
	
	@PostMapping("/eventos/aforo-up")
	public Evento masAforo(@RequestParam int id, @RequestParam int cuanto) {
		
		return servicio.masAforo(id,cuanto);
	}
	
	/* ---------- PARTE DE VENTAS ----------- */
	@GetMapping("/ventas")
	public List<Venta> ventas(){
		return servicio.todasVentas();
	}
	
	@GetMapping("/ventas/{comprador}")
	public List<Venta> ventasSegunComprador(@PathVariable String comprador){
		return servicio.ventasSegunComprador(comprador);
	}
	
	@GetMapping("/ventas/compradores")
	public List<String> compradoresDeEventos(@RequestBody List<Integer> idsEventos) {
	    return servicio.compradoresDeEventos(idsEventos);
	}

	@PostMapping("/ventas/nuevo")
	public Venta guardarNuevaVenta(@RequestBody Venta venta) {
	    return servicio.guardarNuevaVenta(venta);
	}
	
	@DeleteMapping("/eventos/past")
	public void borrarEventosPasados() {
	    servicio.borrarEventosPasados();
	}
	
	@DeleteMapping("/eventos/full")
	public void borrarEventosConEntradasCompletas() {
	    servicio.borrarEventosConEntradasCompletas();
	}


}
