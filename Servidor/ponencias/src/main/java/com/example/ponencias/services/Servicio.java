package com.example.ponencias.services;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.example.ponencias.beans.Ponencia;

import java.time.LocalDate;
import java.time.Month;

@Service
public class Servicio {
    private static LinkedHashMap<Ponencia, Integer> mapa = new LinkedHashMap<Ponencia, Integer>();

    static {
        Ponencia p = new Ponencia("Spring Java",30, LocalDate.of(2024, Month.AUGUST,23));
        mapa.put(p, 0);
        Ponencia p2= new Ponencia("Microservicios",40, LocalDate.of(2023, Month.JANUARY, 8));
        mapa.put(p2, 0);
        Ponencia p3= new Ponencia("AWS",40, LocalDate.of(2022, Month.MARCH, 3));
        mapa.put(p3, 0);
        
    }

	public static LinkedHashMap<Ponencia, Integer> getMapa() {
		return mapa;
	}

	public static void setMapa(LinkedHashMap<Ponencia, Integer> mapa) {
		Servicio.mapa = mapa;
	}
	
	public boolean aniadirPonencia(Ponencia p) {
		if (mapa.containsKey(p))
			return false;
		mapa.put(p, 0);
		return true;
		
	}
	

	public Ponencia buscarPonencia(String titulo) {
	    for (Ponencia ponencia : mapa.keySet()) {
	        if (ponencia.getTitulo().equals(titulo)) {
	            return ponencia;
	        }
	    }
	    return null;
	}
	public boolean aniadirAsistentes(Ponencia p, int cuantos) {
		System.out.print("llega");
	    if (mapa.containsKey(p)) {
	    	System.out.print("llega2");
	        int habia = mapa.get(p);
	        int total = habia+ cuantos;
	        System.out.print("De antes-> "+habia);
	        System.out.print(" Despues-> "+total);
	        if(total<=p.getAforo()) {
	        	mapa.put(p, habia + cuantos);
	        	 return true;
	        }	        
	       
	    }
	    return false;
	}

}
