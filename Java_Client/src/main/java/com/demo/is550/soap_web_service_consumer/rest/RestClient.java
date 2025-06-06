package com.demo.is550.soap_web_service_consumer.rest;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.is550.soap_web_service_consumer.model.Review;
import com.demo.is550.soap_web_service_consumer.model.Student;

@Component
public class RestClient {

	private final RestTemplate restTemplate = new RestTemplate();
	private final String baseUrl = "http://localhost:8082/api/students";
	
	public void testRestClient() {
		Student student = new Student(null, "Test Name", "Test Surname", "Test Dep.", 1);
		Student createdStudent = restTemplate.postForObject(baseUrl, student, Student.class);
		
		System.out.println("[REST] Created Student with ID: " + createdStudent.getId());
		
		Student[] students = restTemplate.getForObject(baseUrl, Student[].class);
		Arrays.stream(students).forEach(s -> System.out.println("[REST] " + s.getName()));
	}
	
	public void testRestToGRPCClient() {
		Long studentID = 1L;
		String url = baseUrl + "/" + studentID;
		Student student = restTemplate.getForObject(url, Student.class);
		System.out.println("[REST -> GRPC] " + "For review test, student: " + student.getName() 
										   + " " +  student.getSurname());
		
		url += "/reviews";
		Review[] reviews = restTemplate.getForObject(url, Review[].class);
		Arrays.stream(reviews).forEach(r -> System.out.println("[REST -> GRPC] " + r.getReviewText()));
		
	}
}
