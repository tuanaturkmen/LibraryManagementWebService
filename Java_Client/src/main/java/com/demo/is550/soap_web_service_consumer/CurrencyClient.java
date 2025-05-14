package com.demo.is550.soap_web_service_consumer;

import com.demo.is550.soap_web_service_consumer.client.gen.*;
import jakarta.xml.bind.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.namespace.QName;

public class CurrencyClient extends WebServiceGatewaySupport {

    public GetCurrencyResponseType getCurrency(String country) throws JAXBException {

    	return null;
    	/*
        GetCurrencyRequestType request = new GetCurrencyRequestType();
        request.setName("USD");
        GetCurrencyResponseType response = (GetCurrencyResponseType) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/currencies", request);

        return response;
*/
    	/*
        ObjectFactory objectFactory = new ObjectFactory();
        GetCurrencyRequestType request = objectFactory.createGetCurrencyRequestType();
        request.setName("USD");

        JAXBElement jaxbRequest = objectFactory.createGetCurrencyRequest(request);

        GetCurrencyResponseType response =
                (GetCurrencyResponseType) getWebServiceTemplate()
                        .marshalSendAndReceive("http://localhost:8080/ws", jaxbRequest);
        return response;
        */
    }
}
