//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for RUBBISH DISPOSAL EQUIPMENT.
 * 
 * <p>Java class for RubbishDisposalEquipment_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RubbishDisposalEquipment_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}PassengerEquipment_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}RubbishDisposalEquipmentGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RubbishDisposalEquipment_VersionStructure", propOrder = {
    "sharpsDispsal",
    "recycling"
})
@XmlSeeAlso({
    RubbishDisposalEquipment.class
})
public class RubbishDisposalEquipment_VersionStructure
    extends PassengerEquipment_VersionStructure
{

    @XmlElement(name = "SharpsDispsal")
    protected Boolean sharpsDispsal;
    @XmlElement(name = "Recycling")
    protected Boolean recycling;

    /**
     * Gets the value of the sharpsDispsal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSharpsDispsal() {
        return sharpsDispsal;
    }

    /**
     * Sets the value of the sharpsDispsal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSharpsDispsal(Boolean value) {
        this.sharpsDispsal = value;
    }

    /**
     * Gets the value of the recycling property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecycling() {
        return recycling;
    }

    /**
     * Sets the value of the recycling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecycling(Boolean value) {
        this.recycling = value;
    }

}