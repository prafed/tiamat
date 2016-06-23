//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * End of Flight of stairs.
 * 
 * <p>Java class for StairEndStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StairEndStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContinuingHandrail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TexturedSurface" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VisualContrast" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StairEndStructure", propOrder = {
    "continuingHandrail",
    "texturedSurface",
    "visualContrast"
})
public class StairEndStructure {

    @XmlElement(name = "ContinuingHandrail")
    protected Boolean continuingHandrail;
    @XmlElement(name = "TexturedSurface")
    protected Boolean texturedSurface;
    @XmlElement(name = "VisualContrast")
    protected Boolean visualContrast;

    /**
     * Gets the value of the continuingHandrail property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContinuingHandrail() {
        return continuingHandrail;
    }

    /**
     * Sets the value of the continuingHandrail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContinuingHandrail(Boolean value) {
        this.continuingHandrail = value;
    }

    /**
     * Gets the value of the texturedSurface property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTexturedSurface() {
        return texturedSurface;
    }

    /**
     * Sets the value of the texturedSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTexturedSurface(Boolean value) {
        this.texturedSurface = value;
    }

    /**
     * Gets the value of the visualContrast property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVisualContrast() {
        return visualContrast;
    }

    /**
     * Sets the value of the visualContrast property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVisualContrast(Boolean value) {
        this.visualContrast = value;
    }

}