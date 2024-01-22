package com.example.demo2.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo2.beans.Viaje;

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
	

}
