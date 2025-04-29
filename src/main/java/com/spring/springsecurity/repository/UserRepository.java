package com.spring.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springsecurity.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

	UsersEntity findByUsername(String username);

}
