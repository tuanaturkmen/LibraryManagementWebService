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

import com.example.restserver.model.Student;
import com.example.restserver.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentByID(@PathVariable Long id) {
		return studentService.getStudentByID(id);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		return studentService.updateStudent(id, updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		boolean isDeleted = studentService.deleteStudent(id);
		return isDeleted ? "Deleted" : "Student does not exists";
	}
	
}
