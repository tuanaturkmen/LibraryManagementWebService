package com.demo.is550.lms_web_service.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, 
customFaultCode = "{" + StudentNotFoundException.NAMESPACE_URI + "}custom_fault", 
faultStringOrReason = "Student not found with that ID!!!")
public class StudentNotFoundException extends Exception {
    public static final String NAMESPACE_URI = "http://lms.com";
    public StudentNotFoundException(String message){
        super(message);
    }   
}