package com.demo.is550.soap_web_service_consumer;

import com.demo.is550.soap_web_service_consumer.client.gen.GetAllBooksResponseType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapWebServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapWebServiceConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(BookClient bookClient) {
		return args -> {
			GetAllBooksResponseType response = bookClient.getBooks();
			response.getBook().stream().forEach(f ->
				System.err.println(f.getId() + ","+ f.getTitle())
			);
		};
	}

}
