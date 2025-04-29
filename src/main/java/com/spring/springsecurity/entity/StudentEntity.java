package com.spring.springsecurity.entity;

public class StudentEntity {

	private Integer id;
	private String name;
	private String marks;
	
	
	
	public StudentEntity(Integer id, String name, String marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}


	
}
