package com.spring.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.spring.springsecurity.entity.UsersEntity;
import com.spring.springsecurity.repository.UserRepository;

@Service
public class UserServices {
@Autowired
AuthenticationManager authManager;

@Autowired
JWTService jwtservice;
	
	private UserRepository repo;
	
	
	public UserServices(UserRepository repo) {
		this.repo=repo;
	}
	
	public UsersEntity register(UsersEntity users) {
		Optional<UsersEntity> entity = repo.findById(users.getId());
		if(entity.isPresent()) {
			UsersEntity userData = entity.get();
			userData.setPassword(users.getPassword());
			userData.setUsername(users.getUsername());
			return repo.save(userData);
		}
		return repo.save(users);
	}

	public String verify(UsersEntity user) {
		
		Authentication authentication = authManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtservice.generateToken(user.getUsername());
		}
		return "Fail";
	}
} 
