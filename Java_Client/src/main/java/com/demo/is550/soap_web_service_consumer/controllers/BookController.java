package com.demo.is550.soap_web_service_consumer.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.is550.soap_web_service_consumer.client.gen.AddBookResponseType;
import com.demo.is550.soap_web_service_consumer.client.gen.Book;
import com.demo.is550.soap_web_service_consumer.client.gen.DeleteBookByIdResponseType;
import com.demo.is550.soap_web_service_consumer.client.gen.GetAllBooksResponseType;
import com.demo.is550.soap_web_service_consumer.client.gen.UpdateBookResponseType;
import com.demo.is550.soap_web_service_consumer.rest.RestClient;
import com.demo.is550.soap_web_service_consumer.soap.SoapClient;


import jakarta.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final SoapClient soapClient;
	
	public BookController(SoapClient soapClient, RestClient restClient) {
		this.soapClient = soapClient;
	}

	@GetMapping()
	public GetAllBooksResponseType getAllBooks() {
		try {
			return soapClient.getBooks();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping
	public AddBookResponseType addBook(@RequestBody Book book) {
		try {
			return soapClient.addBook(book);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public DeleteBookByIdResponseType deleteBook(@PathVariable int id) {
		try {
			return soapClient.deleteBook(id);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping()
	public UpdateBookResponseType updateBook(@RequestBody Book updatedBook) {
		return soapClient.updateBook(updatedBook);
	}
	
}
