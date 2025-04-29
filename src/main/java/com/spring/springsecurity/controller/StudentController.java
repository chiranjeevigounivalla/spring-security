package com.spring.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springsecurity.entity.StudentEntity;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	private List<StudentEntity> students = new ArrayList<>(List.of(
			new StudentEntity(1, "Chiru", "80"),
			new StudentEntity(2, "Krishna", "100") ));
	
	@GetMapping("/students")
	public List<StudentEntity> studentDetails(){
		
		return students;
		
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken csrfToken(HttpServletRequest request){
		
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	
	@PostMapping("/addstudents")
	public StudentEntity addStudentDetails(@RequestBody StudentEntity student){
		students.add(student);
		return student;
		
	}

}
