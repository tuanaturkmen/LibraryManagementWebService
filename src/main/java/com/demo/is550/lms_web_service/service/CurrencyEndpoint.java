/* package com.demo.is550.lms_web_service.service;

import com.demo.is550.lms_web_service.repository.CurrencyRepository;
import com.soap.is550.GetCurrencyRequestType;
import com.soap.is550.GetCurrencyResponseType;
import com.soap.is550.SaveCurrencyRequestType;
import com.soap.is550.SaveCurrencyResponseType;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;

@Endpoint // so that incoming SOAP messages can be processed
public class CurrencyEndpoint {
    private static final String NAMESPACE_URI = "http://is550.soap.com";

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyEndpoint(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCurrencyRequest")
    @ResponsePayload
    public JAXBElement <GetCurrencyResponseType> getAvailableCurrencies(@RequestPayload JAXBElement  <GetCurrencyRequestType> request) throws Exception{
        GetCurrencyResponseType response = new GetCurrencyResponseType();
        response.getCurrency().addAll(currencyRepository.findAll());
        return createResponseJaxbElement(response, GetCurrencyResponseType.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCurrencyRequest")
    @ResponsePayload
    public JAXBElement <GetCurrencyResponseType> getAvailableCurrencyByName(@RequestPayload JAXBElement  <GetCurrencyRequestType> request) throws Exception{
        GetCurrencyResponseType response = new GetCurrencyResponseType();
        GetCurrencyRequestType requestCurrency= (GetCurrencyRequestType) request.getValue();
        response.getCurrency().add(currencyRepository.findCurrencyWithFault(requestCurrency.getName()));
        return createResponseJaxbElement(response, GetCurrencyResponseType.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveCurrencyRequest")
    @ResponsePayload
    public JAXBElement <SaveCurrencyResponseType> saveNewCurrency(@RequestPayload JAXBElement  <SaveCurrencyRequestType> request) throws Exception{
        GetCurrencyResponseType response = new GetCurrencyResponseType();
        SaveCurrencyRequestType requestCurrency= (SaveCurrencyRequestType) request.getValue();
        response.getCurrency().add(currencyRepository.save(requestCurrency.getNewCurrency()));
        return createResponseJaxbElement(response, GetCurrencyResponseType.class);
    }

    private <T>JAXBElement createResponseJaxbElement(T object, Class clazz) {

        return new JAXBElement<>(new QName(NAMESPACE_URI, clazz.getSimpleName()), clazz, object);

    }
}
 */