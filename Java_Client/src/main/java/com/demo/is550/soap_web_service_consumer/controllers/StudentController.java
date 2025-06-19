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
	public Student[] getAllStudents() {
		System.out.println("[REST] getAllStudents request is received.");
		return restClient.getStudents();
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		System.out.println("[REST] deleteStudent request is received.");
		return restClient.deleteStudent(id);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		System.out.println("[REST] addStudent request is received.");
		return restClient.addStudent(student);
	}
	
	@PutMapping()
	public Student updateStudent(@RequestBody Student updatedStudent) {
		System.out.println("[REST] updateStudent request is received.");
		return restClient.updateStudent(updatedStudent);
	}
	
	@GetMapping("/{id}/reviews")
	public Review[] getReviewsByStudentId(@PathVariable int id) {
		System.out.println("[REST] getReviewsByStudentId request is received.");
		return restClient.getReviewByStudentId(id);
	}
	
	@DeleteMapping("/{studentId}/reviews/{reviewId}")
	public String deleteReviewByStudentId(@PathVariable int studentId, @PathVariable int reviewId) {
		System.out.println("[REST] deleteReviewByStudentId request is received.");
		return restClient.deleteReviewOfStudent(studentId, reviewId);
	}
	
}
