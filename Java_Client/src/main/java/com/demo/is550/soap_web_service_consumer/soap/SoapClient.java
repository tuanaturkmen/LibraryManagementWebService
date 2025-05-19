package com.demo.is550.soap_web_service_consumer.soap;

import com.demo.is550.soap_web_service_consumer.client.gen.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import jakarta.xml.bind.*;

public class SoapClient  extends WebServiceGatewaySupport{

	public GetAllBooksResponseType getBooks() throws JAXBException {
		
        ObjectFactory objectFactory = new ObjectFactory();

        GetAllBooksRequestType request = objectFactory.createGetAllBooksRequestType();

        JAXBElement<GetAllBooksRequestType> jaxbRequest = objectFactory.createGetAllBooksRequest(request);

        JAXBElement<GetAllBooksResponseType> jaxbResponse =
            (JAXBElement<GetAllBooksResponseType>) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws", jaxbRequest);

        return jaxbResponse.getValue();
		
	}
	
	public void testSoapClient() {
		try {
			GetAllBooksResponseType response = getBooks();
			response.getBook().stream().forEach(f ->
				System.err.println("[SOAP]" + f.getId() + ","+ f.getTitle()));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
