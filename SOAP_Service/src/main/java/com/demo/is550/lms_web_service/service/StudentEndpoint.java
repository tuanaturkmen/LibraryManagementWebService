package com.demo.is550.lms_web_service.service;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.is550.lms_web_service.exception.StudentNotFoundException;
import com.demo.is550.lms_web_service.generatedSources.*;
import com.demo.is550.lms_web_service.repository.*;

import jakarta.xml.bind.JAXBElement;

@Endpoint
public class StudentEndpoint {
	
	private static final String NAMESPACE_URI = "http://lms.com";

	private StudentRepository studentRepository;

	@Autowired
	public StudentEndpoint(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@SuppressWarnings("unchecked")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentRequest")
	@ResponsePayload
	public JAXBElement <GetStudentResponseType>  getStudent(@RequestPayload JAXBElement <GetStudentRequestType> request) throws StudentNotFoundException{
		
		GetStudentRequestType requestType = request.getValue();
		GetStudentResponseType response = new GetStudentResponseType();
		response.setStudent(studentRepository.findStudent(requestType.getStudentId()));

		try {
			response.setStudent(studentRepository.findStudentWithFault(requestType.getStudentId()));
		} catch (Exception e) {
			System.err.println("Exception caught: " + e.getMessage()); // Print to console
			throw e;
		}
        return createResponseJaxbElement(response, GetStudentResponseType.class);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T>JAXBElement createResponseJaxbElement(T object, Class clazz) {

        return new JAXBElement<>(new QName(NAMESPACE_URI, clazz.getSimpleName()), clazz, object);

    }
}

