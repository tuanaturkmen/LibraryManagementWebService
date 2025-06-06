package com.demo.is550.soap_web_service_consumer;

import com.demo.is550.soap_web_service_consumer.client.gen.GetAllBooksResponseType;
import com.demo.is550.soap_web_service_consumer.rest.RestClient;
import com.demo.is550.soap_web_service_consumer.soap.SoapClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner{

	private final SoapClient soapClient;
	private final RestClient restClient;
	
	public ClientApplication(SoapClient soapClient, RestClient restClient) {
		this.soapClient = soapClient;
		this.restClient = restClient;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		soapClient.testSoapClient();
		restClient.testRestClient();
		restClient.testRestToGRPCClient();
	}

}
