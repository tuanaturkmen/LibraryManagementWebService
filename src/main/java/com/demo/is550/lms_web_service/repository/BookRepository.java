package com.demo.is550.lms_web_service.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
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

    private static final ArrayList<Book> books = new ArrayList<>();

    @PostConstruct
	public void initData() throws Exception {
		Book thg = new Book();
		thg.setTitle("The Hunger Games");
        thg.setAuthor("Suzanne Collins");
        thg.setPublicationYear(formatDate(2025, 12, 3));
        thg.setIsAvailable(true);

        Book cf = new Book();
		cf.setTitle("Catching Fire");
        cf.setAuthor("Suzanne Collins");
        cf.setPublicationYear(formatDate(2009, 9, 1));
        cf.setIsAvailable(false);
        
		books.addAll(Arrays.asList(thg, cf));
	}

    private XMLGregorianCalendar formatDate(int year, int month, int day) throws Exception{
        GregorianCalendar c = new GregorianCalendar(year, month, day);
        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return date;
    }

    public List<Book> findAll() {
        return books;
    }
    
}
