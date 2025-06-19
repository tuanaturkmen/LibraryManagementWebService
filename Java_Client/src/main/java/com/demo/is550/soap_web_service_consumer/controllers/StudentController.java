package com.demo.is550.soap_web_service_consumer.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.is550.soap_web_service_consumer.model.Review;
import com.demo.is550.soap_web_service_consumer.model.Student;
import com.demo.is550.soap_web_service_consumer.rest.RestClient;


@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final RestClient restClient;
	
	public StudentController(RestClient restClient) {
		this.restClient = restClient;
	}
	
	@GetMapping()
	public Student[] getAllBooks() {
		return restClient.getStudents();
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		return restClient.deleteStudent(id);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return restClient.addStudent(student);
	}
	
	@PutMapping()
	public Student updateStudent(@RequestBody Student updatedStudent) {
		return restClient.updateStudent(updatedStudent);
	}
	
	@GetMapping("/{id}/reviews")
	public Review[] getReviwesByStudentId(@PathVariable int id) {
		return restClient.getReviewByStudentId(id);
	}
	
}
