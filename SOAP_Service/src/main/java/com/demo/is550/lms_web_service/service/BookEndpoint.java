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

    @SuppressWarnings("unchecked")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllBooksRequest")
    @ResponsePayload
    public JAXBElement<GetAllBooksResponseType> getAllBooks(@RequestPayload JAXBElement<GetAllBooksRequestType> request) {

        GetAllBooksResponseType response = new GetAllBooksResponseType();
        response.getBook().addAll(bookRepository.findAll());
        return createResponseJaxbElement(response, GetAllBooksResponseType.class);
    }
    
	@SuppressWarnings("unchecked")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookByIdRequest")
	@ResponsePayload
	public JAXBElement <GetBookByIdResponseType> getBookById(@RequestPayload JAXBElement <GetBookByIdRequestType> request) {
		
		GetBookByIdRequestType requestType = request.getValue();
		GetBookByIdResponseType response = new GetBookByIdResponseType();
		response.setBook(bookRepository.findBookById(requestType.getId()));

        return createResponseJaxbElement(response, GetBookByIdResponseType.class);
	}
	
	@SuppressWarnings("unchecked")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteBookByIdRequest")
	@ResponsePayload
	public JAXBElement <DeleteBookByIdResponseType> deleteBookById(@RequestPayload JAXBElement <DeleteBookByIdRequestType> request) {
		
		DeleteBookByIdRequestType requestType = request.getValue();
		DeleteBookByIdResponseType response = new DeleteBookByIdResponseType();
		boolean result = bookRepository.deleteBookById(requestType.getId());
		response.setSuccess(result);

        return createResponseJaxbElement(response, DeleteBookByIdResponseType.class);
	}
	
	@SuppressWarnings("unchecked")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBookRequest")
	@ResponsePayload
	public JAXBElement <AddBookResponseType> addBook(@RequestPayload JAXBElement <AddBookRequestType> request) {
		
		AddBookRequestType requestType = request.getValue();
		AddBookResponseType response = new AddBookResponseType();
		int bookId = bookRepository.addNewBook(requestType.getBook());
		response.setSuccess(true);
		response.setBookId(bookId);

        return createResponseJaxbElement(response, AddBookResponseType.class);
	}
	
	@SuppressWarnings("unchecked")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateBookRequest")
	@ResponsePayload
	public JAXBElement <UpdateBookResponseType> updateBook(@RequestPayload JAXBElement <UpdateBookRequestType> request) {
		
		UpdateBookRequestType requestType = request.getValue();
		UpdateBookResponseType response = new UpdateBookResponseType();
		boolean result = bookRepository.updateBook(requestType.getBook());
		response.setSuccess(result);

        return createResponseJaxbElement(response, UpdateBookResponseType.class);
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> JAXBElement createResponseJaxbElement(T object, Class clazz) {

        return new JAXBElement<>(new QName(NAMESPACE_URI, clazz.getSimpleName()), clazz, object);

    }

}
