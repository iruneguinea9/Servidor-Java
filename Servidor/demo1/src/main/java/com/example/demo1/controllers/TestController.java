package com.example.demo1.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class TestController {
	
	
	
	
	
	
	@GetMapping ("/saludar")
	@ResponseBody
	public String saludar() {		
		return "Egunon!";
	}
	
	
	@GetMapping ("/saludar-html")
	@ResponseBody
	public String saludarhtml() {		
		
		LocalDate fecha=LocalDate.now();
		
		StringBuffer str=new StringBuffer();
		str.append("<body>");
		str.append("<h2>Egunon!</h2>");
		str.append("<p>Hoy es " +
				fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))  
				+ "</p>");		
		str.append("</body>");
		return str.toString();
		
	}
	
	
	@GetMapping("/xxx")
	public String saludarjsp() {
		return "saludarpage";
		
	}
	

}
