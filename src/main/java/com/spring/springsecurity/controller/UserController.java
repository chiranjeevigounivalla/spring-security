package com.spring.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springsecurity.entity.UsersEntity;
import com.spring.springsecurity.service.UserServices;

@RestController
public class UserController {
	@Autowired
	private UserServices service;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	
	@PostMapping("registory")
	public UsersEntity registration(@RequestBody UsersEntity user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		service.register(user);
		return user;
	}

}
