package com.example.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping ("/")
	public String inicio() {
		return "inicio";
	}
	
	
	
	@GetMapping("/login")
	public String login() {
		return "loginpage";	
		
	}

}
