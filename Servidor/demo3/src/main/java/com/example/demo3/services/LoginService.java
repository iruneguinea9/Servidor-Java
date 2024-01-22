package com.example.demo3.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	private static HashMap<String,String> mapaUsers=
			new HashMap<String,String>();
	
	
	static {
		mapaUsers.put("111","111");
		mapaUsers.put("222","222");
		mapaUsers.put("333","333");		
	}
	
	
	public boolean chekLogin(String email, String pass) {
		
		return (mapaUsers.containsKey(email) && 
				mapaUsers.get(email).equals(pass));	
		
	}
	

}
