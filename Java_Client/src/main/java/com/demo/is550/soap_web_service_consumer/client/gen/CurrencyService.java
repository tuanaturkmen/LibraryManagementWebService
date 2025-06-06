
package com.demo.is550.soap_web_service_consumer.client.gen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CurrencyService", targetNamespace = "http://is550.soap.com", wsdlLocation = "file:/C:/Users/Gorkem%20Ozbay/OneDrive/Desktop/WebServiceProjectTuana/LibraryManagementWebService/Java_Client/src/main/resources/currency.wsdl")
public class CurrencyService
    extends Service
{

    private final static URL CURRENCYSERVICE_WSDL_LOCATION;
    private final static WebServiceException CURRENCYSERVICE_EXCEPTION;
    private final static QName CURRENCYSERVICE_QNAME = new QName("http://is550.soap.com", "CurrencyService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Gorkem%20Ozbay/OneDrive/Desktop/WebServiceProjectTuana/LibraryManagementWebService/Java_Client/src/main/resources/currency.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURRENCYSERVICE_WSDL_LOCATION = url;
        CURRENCYSERVICE_EXCEPTION = e;
    }

    public CurrencyService() {
        super(__getWsdlLocation(), CURRENCYSERVICE_QNAME);
    }

    public CurrencyService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CURRENCYSERVICE_QNAME, features);
    }

    public CurrencyService(URL wsdlLocation) {
        super(wsdlLocation, CURRENCYSERVICE_QNAME);
    }

    public CurrencyService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CURRENCYSERVICE_QNAME, features);
    }

    public CurrencyService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CurrencyService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CurrencyPortType
     */
    @WebEndpoint(name = "currencyServiceSOAP")
    public CurrencyPortType getCurrencyServiceSOAP() {
        return super.getPort(new QName("http://is550.soap.com", "currencyServiceSOAP"), CurrencyPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CurrencyPortType
     */
    @WebEndpoint(name = "currencyServiceSOAP")
    public CurrencyPortType getCurrencyServiceSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://is550.soap.com", "currencyServiceSOAP"), CurrencyPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CURRENCYSERVICE_EXCEPTION!= null) {
            throw CURRENCYSERVICE_EXCEPTION;
        }
        return CURRENCYSERVICE_WSDL_LOCATION;
    }

}
