//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeOfFuelEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TypeOfFuelEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="petrol"/>
 *     &lt;enumeration value="diesel"/>
 *     &lt;enumeration value="naturalGas"/>
 *     &lt;enumeration value="biodiesel"/>
 *     &lt;enumeration value="electricity"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TypeOfFuelEnumeration")
@XmlEnum
public enum TypeOfFuelEnumeration {

    @XmlEnumValue("petrol")
    PETROL("petrol"),
    @XmlEnumValue("diesel")
    DIESEL("diesel"),
    @XmlEnumValue("naturalGas")
    NATURAL_GAS("naturalGas"),
    @XmlEnumValue("biodiesel")
    BIODIESEL("biodiesel"),
    @XmlEnumValue("electricity")
    ELECTRICITY("electricity"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    TypeOfFuelEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeOfFuelEnumeration fromValue(String v) {
        for (TypeOfFuelEnumeration c: TypeOfFuelEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}