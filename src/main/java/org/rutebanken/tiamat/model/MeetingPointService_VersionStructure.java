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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a MEETING POINT SERVICE.
 * 
 * <p>Java class for MeetingPointService_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeetingPointService_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}CustomerService_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}MeetingPointServiceGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeetingPointService_VersionStructure", propOrder = {
    "meetingPointServiceType",
    "label"
})
@XmlSeeAlso({
    MeetingPointService.class
})
public class MeetingPointService_VersionStructure
    extends CustomerService_VersionStructure
{

    @XmlElement(name = "MeetingPointServiceType", required = true)
    @XmlSchemaType(name = "NMTOKEN")
    protected MeetingPointEnumeration meetingPointServiceType;
    @XmlElement(name = "Label")
    protected MultilingualStringEntity label;

    /**
     * Gets the value of the meetingPointServiceType property.
     * 
     * @return
     *     possible object is
     *     {@link MeetingPointEnumeration }
     *     
     */
    public MeetingPointEnumeration getMeetingPointServiceType() {
        return meetingPointServiceType;
    }

    /**
     * Sets the value of the meetingPointServiceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeetingPointEnumeration }
     *     
     */
    public void setMeetingPointServiceType(MeetingPointEnumeration value) {
        this.meetingPointServiceType = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualStringEntity }
     *     
     */
    public MultilingualStringEntity getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualStringEntity }
     *     
     */
    public void setLabel(MultilingualStringEntity value) {
        this.label = value;
    }

}
