package com.demo.is550.soap_web_service_consumer.soap;

import com.demo.is550.soap_web_service_consumer.client.gen.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import jakarta.xml.bind.*;

public class SoapClient extends WebServiceGatewaySupport{

	
	@SuppressWarnings("unchecked")
	public GetAllBooksResponseType getBooks() throws JAXBException {
		System.out.println("[SOAP] getBooks request is send.");
	    
		ObjectFactory objectFactory = new ObjectFactory();
	    GetAllBooksRequestType requestType = objectFactory.createGetAllBooksRequestType();
	    
	    JAXBElement<GetAllBooksRequestType> request   = objectFactory.createGetAllBooksRequest(requestType);
	    JAXBElement<GetAllBooksResponseType> response = (JAXBElement<GetAllBooksResponseType>)
	        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws", request);

	    return response.getValue();
	}
	
	
	@SuppressWarnings("unchecked")
	public AddBookResponseType addBook(Book book) throws JAXBException {
		System.out.println("[SOAP] addBook request is send.");
		
	    ObjectFactory objectFactory = new ObjectFactory();
	    AddBookRequestType requestType = objectFactory.createAddBookRequestType();
	    requestType.setBook(book);
	    
	    JAXBElement<AddBookRequestType> request   = objectFactory.createAddBookRequest(requestType);
	    JAXBElement<AddBookResponseType> response = (JAXBElement<AddBookResponseType>)
		        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws", request);
	    
		return response.getValue();
	}
	
	
	@SuppressWarnings("unchecked")
	public DeleteBookByIdResponseType deleteBook(int id) throws JAXBException {
		System.out.println("[SOAP] deleteBook request is send.");
		
	    ObjectFactory objectFactory = new ObjectFactory();
	    DeleteBookByIdRequestType requestType = objectFactory.createDeleteBookByIdRequestType();
	    requestType.setId(id);
	    
	    JAXBElement<DeleteBookByIdRequestType> request   = objectFactory.createDeleteBookByIdRequest(requestType);
	    JAXBElement<DeleteBookByIdResponseType> response = (JAXBElement<DeleteBookByIdResponseType>)
		        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws", request);
	    
		return response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	public UpdateBookResponseType updateBook(Book updatedBook) {
		System.out.println("[SOAP] updateBook request is send.");
		
	    ObjectFactory objectFactory = new ObjectFactory();
	    UpdateBookRequestType requestType = objectFactory.createUpdateBookRequestType();
	    requestType.setBook(updatedBook);
	    
	    JAXBElement<UpdateBookRequestType> request   = objectFactory.createUpdateBookRequest(requestType);
	    JAXBElement<UpdateBookResponseType> response = (JAXBElement<UpdateBookResponseType>)
		        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws", request);
	    
		return response.getValue();
	}
}
