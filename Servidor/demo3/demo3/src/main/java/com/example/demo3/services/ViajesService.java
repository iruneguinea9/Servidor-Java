package com.example.demo3.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo3.beans.Viaje;
import com.example.demo3.beans.Viajero;

@Service
public class ViajesService {
	
	private static ArrayList<Viaje> lstViajes=new ArrayList<Viaje>();
	static {
		lstViajes.add(new Viaje("Paris",6,1100));
		lstViajes.add(new Viaje("Praga",3,6500));
	}
	
	private static ArrayList<Viajero> lstViajeros=new ArrayList<Viajero>();
	
	
	
	
	
	public static ArrayList<Viaje> getLstViajes() {
		return lstViajes;
	}
	
	public boolean aniadirViaje(Viaje vNuevo) {
		if (lstViajes.contains(vNuevo))
			return false;
		lstViajes.add(vNuevo);
		return true;
		
	}
	
	
	public void borrarViaje(String lugar) {
		Viaje v=new Viaje();
		v.setLugar(lugar);		
		lstViajes.remove(v);		
	}
	
	public Viaje viajeA(String lugar) {
		Viaje v=new Viaje();
		v.setLugar(lugar);
		int iViaje=lstViajes.indexOf(v);
		return lstViajes.get(iViaje);
		
	}
	
	public void editarViaje(Viaje viajeCambiado) {
		Viaje v = viajeA(viajeCambiado.getLugar());
		v.setDias(viajeCambiado.getDias());
		v.setKms(viajeCambiado.getKms());
	}	
	
	public void aniadirViajero(Viajero viajero) {
		lstViajeros.add(viajero);
	}
	
	public ArrayList<Viajero> todosViajeros(){
		return lstViajeros;
	}
	
	
	
	
}
