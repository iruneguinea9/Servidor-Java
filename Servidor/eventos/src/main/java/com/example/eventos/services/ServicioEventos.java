package com.example.eventos.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventos.entities.Evento;
import com.example.eventos.entities.Venta;
import com.example.eventos.repositories.EventoRepo;
import com.example.eventos.repositories.VentaRepo;


@Service
public class ServicioEventos {
	@Autowired EventoRepo repoEvento;
	@Autowired VentaRepo repoVenta;

	/* ---------- PARTE DE EVENTOS ----------- */

	public ArrayList<Evento> todosEventos(){
		
		return (ArrayList<Evento>) repoEvento.findAll();
	}
	
	public ArrayList<Evento> eventosFuturos(){
	    LocalDateTime now = LocalDateTime.now();
	    return (ArrayList<Evento>) repoEvento.findAll().stream()
	            .filter(evento -> evento.getFecha().isAfter(now))
	            .collect(Collectors.toList());
	}
	
	public Evento guardarEvento(Evento ev) {
		return repoEvento.save(ev);
	}
	
	public Evento actualizarEvento(int id, Evento ev) {
		if (!repoEvento.findById(id).isPresent())
			return ev; // si la ruta del id no existe no hace nada
		else
		{
				ev.setId(id);
				repoEvento.save(ev);
				return ev;
			
		}
	}

	public Evento masAforo(int id, int cuanto) {
			Evento ev = repoEvento.findById(id).get();
			ev.setAforo(ev.getAforo()+cuanto);
			repoEvento.save(ev);
			return ev;
			
		
	}
	
	/* ---------- PARTE DE VENTAS ----------- */

	public ArrayList<Venta> todasVentas(){
		
		return (ArrayList<Venta>) repoVenta.findAll();
	}

	public ArrayList<Venta> ventasSegunComprador(String comprador) {
		ArrayList<Venta> ventas  = new ArrayList<Venta>(repoVenta.findByComprador(comprador));
		return ventas;
	}

	public List<String> compradoresDeEventos(List<Integer> idsEventos) {
		List<String> compradores = new ArrayList<>();
	    for (Integer id : idsEventos) {
	    	List<Venta> ventas = repoVenta.findByEventoId(id);
	        for (Venta venta : ventas) {
	            compradores.add(venta.getComprador());
	        }
	    }
	    return compradores;
	}

	public Venta guardarNuevaVenta(Venta venta) {
	    Evento evento = repoEvento.findById(venta.getEvento().getId()).orElseThrow(() -> new IllegalArgumentException("El evento no existe"));
	    if (evento.getAforo() >= venta.getNum_entradas()) {
	        venta.setPrecio(evento.getPrecio() * venta.getNum_entradas());
	        return repoVenta.save(venta);
	    } else {
	        throw new IllegalArgumentException("No hay suficientes entradas disponibles");
	    }
	}
	
	public void borrarEventosPasados() {
	    LocalDateTime now = LocalDateTime.now();
	    List<Evento> eventosPasados = repoEvento.findAll().stream()
	            .filter(evento -> evento.getFecha().isBefore(now))
	            .collect(Collectors.toList());
	    
	    for (Evento evento : eventosPasados) {
	        repoVenta.deleteByEventoId(evento.getId());
	        repoEvento.delete(evento);
	    }
	}

	public void borrarEventosConEntradasCompletas() {
	    List<Evento> eventosConEntradasCompletas = repoEvento.findAll().stream()
	            .filter(evento -> evento.getAforo() <= 0)
	            .collect(Collectors.toList());
	    
	    for (Evento evento : eventosConEntradasCompletas) {
	        repoVenta.deleteByEventoId(evento.getId());
	        repoEvento.delete(evento);
	    }
	}

}
