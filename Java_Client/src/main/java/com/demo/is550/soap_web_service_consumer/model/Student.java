package com.demo.is550.soap_web_service_consumer.model;

public class Student {

	private Long id;
	private String name;
	private String surname;
	private String department;
	private Integer year;
	
	
	public Student() {}
	public Student(Long id, String name, String surname, String department, Integer year) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.year = year;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	
}
