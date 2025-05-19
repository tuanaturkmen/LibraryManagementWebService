package com.example.restserver.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.restserver.model.Student;

import jakarta.annotation.PostConstruct;

@Service
public class StudentService {

	private Map<Long, Student> studentList = new HashMap<>();
	private long currentID = 1;
	
	@PostConstruct
	public void initStudentList() {
        addStudent(new Student(null, "Ali",    "A", "Computer Science", 1));
        addStudent(new Student(null, "Ayşe",   "B", "Mathematics",      1));
        addStudent(new Student(null, "Mehmet", "C", "Physics",          2));
	}
	
	public Student addStudent(Student student) {
		student.setId(currentID++);
		studentList.put(student.getId(), student);
		return student;
	}
	
	public Collection<Student> getAllStudents() {
		return studentList.values();
	}
	
	public Student getStudentByID(Long studentID) {
		return studentList.get(studentID);
	}
	
	public Student updateStudent(Long studentID, Student updatedStudent) {
		Student existing = studentList.get(studentID);
		if (existing != null) {
			existing.setName(updatedStudent.getName());
			existing.setSurname(updatedStudent.getSurname());
			existing.setDepartment(updatedStudent.getDepartment());
			existing.setYear(updatedStudent.getYear());
		}
		return existing;
	}
	
	public boolean deleteStudent(Long studentID) {
		Student existing = studentList.get(studentID);
		if (existing != null) {
			studentList.remove(studentID);
			return true;
		}
		return false;
	}
	
}
