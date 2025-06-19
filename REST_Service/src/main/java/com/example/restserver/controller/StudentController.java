package com.example.restserver.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpc.ReviewProto;
import com.example.grpc.ReviewServiceGrpc;
import com.example.restserver.model.Review;
import com.example.restserver.model.Student;
import com.example.restserver.service.StudentService;

import io.grpc.ManagedChannel;

@RestController
@RequestMapping("api/students")
public class StudentController {

	private final StudentService studentService;
	private final ReviewServiceGrpc.ReviewServiceBlockingStub reviewStub;
	
	public StudentController(StudentService studentService, ManagedChannel grpcChannel) {
		this.studentService = studentService;
		this.reviewStub = ReviewServiceGrpc.newBlockingStub(grpcChannel);
	}
	
	@GetMapping
	public Collection<Student> getAllStudents() {
		System.out.println("[REST] getAllStudents request is received.");
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentByID(@PathVariable Long id) {
		System.out.println("[REST] getStudentByID request is received.");
		return studentService.getStudentByID(id);
	}
	
	@GetMapping("/{id}/reviews")
	public Collection<Review> getReviewsOfStudent(@PathVariable Long id) {
		System.out.println("[REST] getReviewsOfStudent request is received.");
		System.out.println("[GRPC] getReviewsOfStudent request is send.");
		ReviewProto.GetReviewsRequest request = ReviewProto.GetReviewsRequest.newBuilder()
				.setStudentId(id)
				.build();
		
		ReviewProto.GetReviewsResponse grpcResponse = reviewStub.getReviewsByStudentID(request);
		
		return grpcResponse.getReviewsList().stream().map(r -> new Review(
				r.getId(), 
				r.getStudentId(), 
				r.getStudentName(), 
				r.getBookName(), 
				r.getRating(), 
				r.getReviewText()
			))
			.toList();
		
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		System.out.println("[REST] addStudent request is received.");
		return studentService.addStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		System.out.println("[REST] updateStudent request is received.");
		return studentService.updateStudent(id, updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		System.out.println("[REST] deleteStudent request is received.");
		boolean isDeleted = studentService.deleteStudent(id);
		return isDeleted ? "Deleted" : "Student does not exists";
	}
	
	@DeleteMapping("/{studentId}/reviews/{reviewId}")
	public String deleteReviewOfStudent(@PathVariable Long studentId, @PathVariable Long reviewId) {
	    System.out.println("[REST] deleteReviewOfStudent request is received.");
	    System.out.println("[GRPC] deleteReviewOfStudent request is sent.");

	    ReviewProto.DeleteReviewRequest grpcRequest = ReviewProto.DeleteReviewRequest.newBuilder()
	            .setReviewId(reviewId)
	            .build();

	    ReviewProto.DeleteReviewResponse grpcResponse = reviewStub.deleteReview(grpcRequest);
	    
	    System.err.println(grpcResponse);
	    
	    return grpcResponse.getMessage();
	}
	
}
