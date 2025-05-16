
package com.demo.is550.soap_web_service_consumer.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for currency complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="currency"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="shortName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="currentValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="askValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="bidValue" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currency", propOrder = {
    "name",
    "shortName",
    "currentValue",
    "askValue",
    "bidValue"
})
public class Currency {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String shortName;
    protected double currentValue;
    protected double askValue;
    protected double bidValue;

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
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the currentValue property.
     * 
     */
    public double getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the value of the currentValue property.
     * 
     */
    public void setCurrentValue(double value) {
        this.currentValue = value;
    }

    /**
     * Gets the value of the askValue property.
     * 
     */
    public double getAskValue() {
        return askValue;
    }

    /**
     * Sets the value of the askValue property.
     * 
     */
    public void setAskValue(double value) {
        this.askValue = value;
    }

    /**
     * Gets the value of the bidValue property.
     * 
     */
    public double getBidValue() {
        return bidValue;
    }

    /**
     * Sets the value of the bidValue property.
     * 
     */
    public void setBidValue(double value) {
        this.bidValue = value;
    }

}
