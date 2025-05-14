
package com.demo.is550.soap_web_service_consumer.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCurrencyRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCurrencyRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ParityType" type="{http://is550.soap.com}parityType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCurrencyRequestType", propOrder = {
    "name",
    "parityType"
})
public class GetCurrencyRequestType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "ParityType", required = true)
    @XmlSchemaType(name = "string")
    protected ParityType parityType;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parityType property.
     * 
     * @return
     *     possible object is
     *     {@link ParityType }
     *     
     */
    public ParityType getParityType() {
        return parityType;
    }

    /**
     * Sets the value of the parityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParityType }
     *     
     */
    public void setParityType(ParityType value) {
        this.parityType = value;
    }

}
