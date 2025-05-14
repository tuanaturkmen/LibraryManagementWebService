package com.demo.is550.lms_web_service.repository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.demo.is550.lms_web_service.generatedSources.*;

import jakarta.annotation.PostConstruct;

@Component
public class BookRepository {

    private static final Map<Integer, Book> books = new HashMap<>();
    private int bookID = 0;

    @PostConstruct
	public void initData() throws Exception {
    	Book b1 = new Book();
    	b1.setId(bookID);
    	b1.setTitle("The Hunger Games");
    	b1.setAuthor("Suzanne Collins");
    	b1.setPublicationYear(formatDate(2008, 9, 14));
    	b1.setIsAvailable(true);
    	books.put(b1.getId(), b1);
    	bookID++;

    	Book b2 = new Book();
    	b2.setId(bookID);
    	b2.setTitle("Mockingjay");
    	b2.setAuthor("Suzanne Collins");
    	b2.setPublicationYear(formatDate(2010, 8, 24));
    	b2.setIsAvailable(false);
    	books.put(b2.getId(), b2);
    	bookID++;

    	Book b3 = new Book();
    	b3.setId(bookID);
    	b3.setTitle("Divergent");
    	b3.setAuthor("Veronica Roth");
    	b3.setPublicationYear(formatDate(2011, 4, 25));
    	b3.setIsAvailable(true);
    	books.put(b3.getId(), b3);
    	bookID++;

    	Book b4 = new Book();
    	b4.setId(bookID);
    	b4.setTitle("Insurgent");
    	b4.setAuthor("Veronica Roth");
    	b4.setPublicationYear(formatDate(2012, 5, 1));
    	b4.setIsAvailable(true);
    	books.put(b4.getId(), b4);
    	bookID++;
    	
    	Book b5 = new Book();
    	b5.setId(bookID);
    	b5.setTitle("Allegiant");
    	b5.setAuthor("Veronica Roth");
    	b5.setPublicationYear(formatDate(2013, 10, 22));
    	b5.setIsAvailable(false);
    	books.put(b5.getId(), b5);
    	bookID++;

    	Book b6 = new Book();
    	b6.setId(bookID);
    	b6.setTitle("Harry Potter and the Sorcerer's Stone");
    	b6.setAuthor("J.K. Rowling");
    	b6.setPublicationYear(formatDate(1997, 6, 26));
    	b6.setIsAvailable(true);
    	books.put(b6.getId(), b6);
    	bookID++;

    	Book b7 = new Book();
    	b7.setId(bookID);
    	b7.setTitle("Harry Potter and the Chamber of Secrets");
    	b7.setAuthor("J.K. Rowling");
    	b7.setPublicationYear(formatDate(1998, 7, 2));
    	b7.setIsAvailable(false);
    	books.put(b7.getId(), b7);
    	bookID++;

    	Book b8 = new Book();
    	b8.setId(bookID);
    	b8.setTitle("The Maze Runner");
    	b8.setAuthor("James Dashner");
    	b8.setPublicationYear(formatDate(2009, 10, 6));
    	b8.setIsAvailable(true);
    	books.put(b8.getId(), b8);
    	bookID++;

    	Book b9 = new Book();
    	b9.setId(bookID);
    	b9.setTitle("The Scorch Trials");
    	b9.setAuthor("James Dashner");
    	b9.setPublicationYear(formatDate(2010, 9, 18));
    	b9.setIsAvailable(false);
    	books.put(b9.getId(), b9);
    	bookID++;

    	Book b10 = new Book();
    	b10.setId(bookID);
    	b10.setTitle("The Death Cure");
    	b10.setAuthor("James Dashner");
    	b10.setPublicationYear(formatDate(2011, 10, 11));
    	b10.setIsAvailable(true);
    	books.put(b10.getId(), b10);
    	bookID++;

	}

    private XMLGregorianCalendar formatDate(int year, int month, int day) throws Exception{
        GregorianCalendar c = new GregorianCalendar(year, month, day);
        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return date;
    }

    public List<Book> findAll() {
    	return new ArrayList<>(books.values());
    }
    
    public Book findBookById(Integer bookdID) {
    	return books.get(bookdID);
    }
    
    public int addNewBook(Book newBook) {
    	newBook.setId(bookID);
    	books.put(bookID, newBook);
    	bookID++;
    	return bookID;
    }
    
    public boolean deleteBookById(Integer bookID) {
    	if (books.containsKey(bookID)) {
        	books.remove(bookID);
        	return true;
    	}
    	return false;
    }
    
    public Boolean updateBook(Book newBook) {
    	int bookId = newBook.getId();
    	if (books.containsKey(bookId)) {
        	books.put(bookId, newBook);
        	return true;
    	}
    	return false;
    }
  
}
