package com.demo.is550.lms_web_service.service;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.demo.is550.lms_web_service.generatedSources.*;
import com.demo.is550.lms_web_service.repository.*;

import jakarta.xml.bind.JAXBElement;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://lms.com";

    private BookRepository bookRepository;

    @Autowired
	public BookEndpoint(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllBooksRequest")
    @ResponsePayload
    public JAXBElement<GetAllBooksResponseType> getAllBooks(@RequestPayload JAXBElement<GetAllBooksRequestType> request) throws Exception {

        GetAllBooksResponseType response = new GetAllBooksResponseType();
        response.getBook().addAll(bookRepository.findAll());
        return createResponseJaxbElement(response, GetAllBooksResponseType.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveBookRequest")
    @ResponsePayload
    public JAXBElement <GetAllBooksResponseType> saveNewBook(@RequestPayload JAXBElement  <SaveBookRequestType> request) throws Exception{
        GetAllBooksResponseType response = new GetAllBooksResponseType();
        SaveBookRequestType requestBook = (SaveBookRequestType) request.getValue();
        bookRepository.save(requestBook.getNewBook());
        response.getBook().addAll(bookRepository.findAll());
        return createResponseJaxbElement(response, GetAllBooksResponseType.class);
    }

    private <T> JAXBElement createResponseJaxbElement(T object, Class clazz) {

        return new JAXBElement<>(new QName(NAMESPACE_URI, clazz.getSimpleName()), clazz, object);

    }

}
