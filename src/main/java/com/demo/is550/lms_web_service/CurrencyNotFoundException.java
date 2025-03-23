/* package com.demo.is550.lms_web_service;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
customFaultCode = "{" + CurrencyNotFoundException.NAMESPACE_URI + "}custom_fault",
faultStringOrReason =  "Currency not found")
public class CurrencyNotFoundException extends Exception {
    public static final String NAMESPACE_URI  = "http://is550.soap.com";
    public CurrencyNotFoundException(String message){
        super(message);
    }
}
 */