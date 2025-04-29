package com.spring.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.springsecurity.entity.UsersEntity;
import com.spring.springsecurity.model.UserPrinciples;
import com.spring.springsecurity.repository.UserRepository;

@Service
public class UserDetailServiceSecurity implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	
		UsersEntity user = userRepo.findByUsername(username);
		
		if(user==null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("User Not Found: "+username);
		}
		
		return new UserPrinciples(user);
		
	}
	

}
