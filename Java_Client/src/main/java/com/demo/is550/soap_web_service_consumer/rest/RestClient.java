package com.demo.is550.soap_web_service_consumer.rest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.is550.soap_web_service_consumer.model.Review;
import com.demo.is550.soap_web_service_consumer.model.Student;

@Component
public class RestClient {

	private final RestTemplate restTemplate = new RestTemplate();
	private final String baseUrl = "http://localhost:8082/api/students";
	
	public Student[] getStudents() {
		System.out.println("[REST] getStudents request is send.");
		Student[] students = restTemplate.getForObject(baseUrl, Student[].class);
		return students;
	}
	
	public String deleteStudent(int id) {
		System.out.println("[REST] deleteStudent request is send.");
	    String url = baseUrl + "/" + id;
	    return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
	}
	
	public Student addStudent(Student student) {
		System.out.println("[REST] addStudent request is send.");
		Student createdStudent = restTemplate.postForObject(baseUrl, student, Student.class);
		return createdStudent;
	}
	
	public Student updateStudent(Student updatedStudent) {
		System.out.println("[REST] updateStudent request is send.");
		Long studentId = updatedStudent.getId();
	    String url = baseUrl + "/" + studentId;
	    restTemplate.put(url, updatedStudent);
	    return updatedStudent;
	}
	
	public Review[] getReviewByStudentId(int id) {
		System.out.println("[REST] getReviewByStudentId request is send.");
		String url = baseUrl + "/" + id + "/reviews";
		Review[] reviews = restTemplate.getForObject(url, Review[].class);		
		return reviews;
	}
	
	public String deleteReviewOfStudent(int studentId, int reviewId) {
		System.out.println("[REST] deleteReviewOfStudent request is send.");
		String url = baseUrl + "/" + studentId + "/reviews/" + reviewId;
	    return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
	}
}
