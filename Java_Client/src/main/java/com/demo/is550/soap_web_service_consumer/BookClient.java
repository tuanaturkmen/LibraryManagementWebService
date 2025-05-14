package com.demo.is550.soap_web_service_consumer;

import com.demo.is550.soap_web_service_consumer.client.gen.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import jakarta.xml.bind.*;

public class BookClient  extends WebServiceGatewaySupport{

	public GetAllBooksResponseType getBooks() throws JAXBException {
		
        ObjectFactory objectFactory = new ObjectFactory();

        // ✅ Create empty request
        GetAllBooksRequestType request = objectFactory.createGetAllBooksRequestType();

        // ✅ Wrap in correct JAXBElement (will create <GetAllBooksRequest> tag)
        JAXBElement<GetAllBooksRequestType> jaxbRequest = objectFactory.createGetAllBooksRequest(request);

        // ✅ Send request and receive response as correct type
        JAXBElement<GetAllBooksResponseType> jaxbResponse =
            (JAXBElement<GetAllBooksResponseType>) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws", jaxbRequest);

        // ✅ Return response body
        return jaxbResponse.getValue();
		
	}
	
}
