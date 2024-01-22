package com.example.demo3.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo3.beans.Viaje;

@Service
public class ViajesService {
	
	private static ArrayList<Viaje> lstViajes=new ArrayList<Viaje>();
	
	
	static {
		lstViajes.add(new Viaje("Paris",6,1100));
		lstViajes.add(new Viaje("Praga",3,6500));
	}
	
	
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
}
