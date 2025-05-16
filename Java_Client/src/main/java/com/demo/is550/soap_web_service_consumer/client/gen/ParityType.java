
package com.demo.is550.soap_web_service_consumer.client.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="parityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="bid"/&gt;
 *     &lt;enumeration value="ask"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "parityType")
@XmlEnum
public enum ParityType {

    @XmlEnumValue("bid")
    BID("bid"),
    @XmlEnumValue("ask")
    ASK("ask");
    private final String value;

    ParityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParityType fromValue(String v) {
        for (ParityType c: ParityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
