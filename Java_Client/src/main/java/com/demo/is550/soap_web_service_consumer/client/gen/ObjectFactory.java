package com.demo.is550.soap_web_service_consumer.client.gen;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.is550.soap_web_service_consumer.client.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStudentRequest_QNAME = new QName("http://lms.com", "GetStudentRequest");
    private final static QName _GetStudentResponse_QNAME = new QName("http://lms.com", "GetStudentResponse");
    private final static QName _GetAllBooksRequest_QNAME = new QName("http://lms.com", "GetAllBooksRequest");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://lms.com", "GetAllBooksResponse");
    private final static QName _SaveBookRequest_QNAME = new QName("http://lms.com", "SaveBookRequest");
    private final static QName _GetBookByIdRequest_QNAME = new QName("http://lms.com", "GetBookByIdRequest");
    private final static QName _GetBookByIdResponse_QNAME = new QName("http://lms.com", "GetBookByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.is550.soap_web_service_consumer.client.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentRequestType }
     * 
     */
    public GetStudentRequestType createGetStudentRequestType() {
        return new GetStudentRequestType();
    }

    /**
     * Create an instance of {@link GetStudentResponseType }
     * 
     */
    public GetStudentResponseType createGetStudentResponseType() {
        return new GetStudentResponseType();
    }

    /**
     * Create an instance of {@link GetAllBooksRequestType }
     * 
     */
    public GetAllBooksRequestType createGetAllBooksRequestType() {
        return new GetAllBooksRequestType();
    }

    /**
     * Create an instance of {@link GetAllBooksResponseType }
     * 
     */
    public GetAllBooksResponseType createGetAllBooksResponseType() {
        return new GetAllBooksResponseType();
    }

     /* Create an instance of {@link GetBookByIdRequestType }
     * 
     */
    public GetBookByIdRequestType createGetBookByIdRequestType() {
        return new GetBookByIdRequestType();
    }

    /**
     * Create an instance of {@link GetBookByIdResponseType }
     * 
     */
    public GetBookByIdResponseType createGetBookByIdResponseType() {
        return new GetBookByIdResponseType();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://lms.com", name = "GetStudentRequest")
    public JAXBElement<GetStudentRequestType> createGetStudentRequest(GetStudentRequestType value) {
        return new JAXBElement<GetStudentRequestType>(_GetStudentRequest_QNAME, GetStudentRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://lms.com", name = "GetStudentResponse")
    public JAXBElement<GetStudentResponseType> createGetStudentResponse(GetStudentResponseType value) {
        return new JAXBElement<GetStudentResponseType>(_GetStudentResponse_QNAME, GetStudentResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllBooksRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://lms.com", name = "GetAllBooksRequest")
    public JAXBElement<GetAllBooksRequestType> createGetAllBooksRequest(GetAllBooksRequestType value) {
        return new JAXBElement<GetAllBooksRequestType>(_GetAllBooksRequest_QNAME, GetAllBooksRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://lms.com", name = "GetAllBooksResponse")
    public JAXBElement<GetAllBooksResponseType> createGetAllBooksResponse(GetAllBooksResponseType value) {
        return new JAXBElement<GetAllBooksResponseType>(_GetAllBooksResponse_QNAME, GetAllBooksResponseType.class, null, value);
    }

      /* Create an instance of {@link JAXBElement }{@code <}{@link GetBookByIdRequestType }{@code >}
     * 
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBookByIdRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://lms.com", name = "GetBookByIdRequest")
    public JAXBElement<GetBookByIdRequestType> createGetBookByIdRequest(GetBookByIdRequestType value) {
        return new JAXBElement<GetBookByIdRequestType>(_GetBookByIdRequest_QNAME, GetBookByIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookByIdResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBookByIdResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://lms.com", name = "GetBookByIdResponse")
    public JAXBElement<GetBookByIdResponseType> createGetBookByIdResponse(GetBookByIdResponseType value) {
        return new JAXBElement<GetBookByIdResponseType>(_GetBookByIdResponse_QNAME, GetBookByIdResponseType.class, null, value);
    }
    
    @XmlElementDecl(namespace = "http://lms.com", name = "GetAllBooksResponseType")
    public JAXBElement<GetAllBooksResponseType> createGetAllBooksResponseType(GetAllBooksResponseType value) {
        return new JAXBElement<>(new QName("http://lms.com", "GetAllBooksResponseType"), GetAllBooksResponseType.class, value);
    }

}
