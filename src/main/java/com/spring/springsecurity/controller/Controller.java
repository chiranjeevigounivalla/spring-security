package com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String welcome(HttpServletRequest request) {
		
		return  "Hello Security "+request.getSession().getId();
	}

}
