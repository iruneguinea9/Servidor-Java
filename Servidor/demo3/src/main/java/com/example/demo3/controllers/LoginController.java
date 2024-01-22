package com.example.demo3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo3.services.LoginService;

@Controller
public class LoginController {
	
	/*
	public LoginController(LoginService service) {		
	}
	*/
	@Autowired LoginService loginService;
	
	@GetMapping ("/")
	public String inicio() {
		return "inicio";
	}
	
	
	
	@GetMapping("/login")
	public String login() {
		return "loginpage";	
		
	}
	
	@PostMapping("/login")
	public String checklogin(@RequestParam String email,
							@RequestParam String pass,
							ModelMap modelo) {
		
		if (loginService.chekLogin(email, pass)) {
			return "loginexito";
		}
		else {
			//Dejo en request un atributo errorLogin
			modelo.addAttribute("errorlogin","Erron en login de " + email);
			return "loginpage";	
		}
	}

}
