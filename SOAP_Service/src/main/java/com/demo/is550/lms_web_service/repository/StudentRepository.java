package com.demo.is550.lms_web_service.repository;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.demo.is550.lms_web_service.exception.StudentNotFoundException;
import com.demo.is550.lms_web_service.generatedSources.*;

@Component
public class StudentRepository {
	private static final Map<String, Student> students = new HashMap<>();

	@PostConstruct
	public void initData() {
		Student tuana = new Student();
		tuana.setName("tuana");
        tuana.setSurname("turkmen");
        tuana.setStudentId("1234");
        tuana.setDepartment("CS");
        tuana.setYear(4);

		students.put(tuana.getStudentId(), tuana);

        Student gorkem = new Student();
		gorkem.setName("gorkem");
        gorkem.setSurname("ozbay");
        gorkem.setStudentId("5678");
        gorkem.setDepartment("EE");
        gorkem.setYear(3);

		students.put(gorkem.getStudentId(), gorkem);


	}

	public Student findStudent(String studentId) {
		Assert.notNull(studentId, "Student id must not be null");
		return students.get(studentId);
	}

	public Student findStudentWithFault(String studentId) throws StudentNotFoundException {

		Student student = findStudent(studentId);
        if (Objects.isNull(student)) {
            throw new StudentNotFoundException("No such student!");
        }else{
            return student;
        }
	}
}

