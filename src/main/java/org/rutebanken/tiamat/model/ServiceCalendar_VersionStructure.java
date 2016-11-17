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
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Type for a SERVICE CALENDAR.
 * 
 * <p>Java class for ServiceCalendar_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceCalendar_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}DataManagedObjectStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}ServiceCalendarGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceCalendar_VersionStructure", propOrder = {
    "name",
    "shortName",
    "fromDate",
    "toDate",
    "earliestTime",
    "dayLength",
    "dayTypes",
    "timebands",
    "operatingDays",
    "operatingPeriods",
    "dayTypeAssignments"
})
@XmlSeeAlso({
    ServiceCalendar.class
})
public class ServiceCalendar_VersionStructure
    extends DataManagedObjectStructure
{

    @XmlElement(name = "Name")
    protected MultilingualStringEntity name;
    @XmlElement(name = "ShortName")
    protected MultilingualStringEntity shortName;
    @XmlElement(name = "FromDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fromDate;
    @XmlElement(name = "ToDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDate;
    @XmlElement(name = "EarliestTime", defaultValue = "00:00:00")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar earliestTime;
    @XmlElement(name = "DayLength", defaultValue = "PT24H")
    protected Duration dayLength;
    protected DayTypes_RelStructure dayTypes;
    protected Timebands_RelStructure timebands;
    protected OperatingDays_RelStructure operatingDays;
    protected OperatingPeriods_RelStructure operatingPeriods;
    protected DayTypeAssignments_RelStructure dayTypeAssignments;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualStringEntity }
     *     
     */
    public MultilingualStringEntity getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualStringEntity }
     *     
     */
    public void setName(MultilingualStringEntity value) {
        this.name = value;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualStringEntity }
     *     
     */
    public MultilingualStringEntity getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualStringEntity }
     *     
     */
    public void setShortName(MultilingualStringEntity value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDate(XMLGregorianCalendar value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the earliestTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEarliestTime() {
        return earliestTime;
    }

    /**
     * Sets the value of the earliestTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEarliestTime(XMLGregorianCalendar value) {
        this.earliestTime = value;
    }

    /**
     * Gets the value of the dayLength property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDayLength() {
        return dayLength;
    }

    /**
     * Sets the value of the dayLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDayLength(Duration value) {
        this.dayLength = value;
    }

    /**
     * Gets the value of the dayTypes property.
     * 
     * @return
     *     possible object is
     *     {@link DayTypes_RelStructure }
     *     
     */
    public DayTypes_RelStructure getDayTypes() {
        return dayTypes;
    }

    /**
     * Sets the value of the dayTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayTypes_RelStructure }
     *     
     */
    public void setDayTypes(DayTypes_RelStructure value) {
        this.dayTypes = value;
    }

    /**
     * Gets the value of the timebands property.
     * 
     * @return
     *     possible object is
     *     {@link Timebands_RelStructure }
     *     
     */
    public Timebands_RelStructure getTimebands() {
        return timebands;
    }

    /**
     * Sets the value of the timebands property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timebands_RelStructure }
     *     
     */
    public void setTimebands(Timebands_RelStructure value) {
        this.timebands = value;
    }

    /**
     * Gets the value of the operatingDays property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingDays_RelStructure }
     *     
     */
    public OperatingDays_RelStructure getOperatingDays() {
        return operatingDays;
    }

    /**
     * Sets the value of the operatingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingDays_RelStructure }
     *     
     */
    public void setOperatingDays(OperatingDays_RelStructure value) {
        this.operatingDays = value;
    }

    /**
     * Gets the value of the operatingPeriods property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingPeriods_RelStructure }
     *     
     */
    public OperatingPeriods_RelStructure getOperatingPeriods() {
        return operatingPeriods;
    }

    /**
     * Sets the value of the operatingPeriods property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingPeriods_RelStructure }
     *     
     */
    public void setOperatingPeriods(OperatingPeriods_RelStructure value) {
        this.operatingPeriods = value;
    }

    /**
     * Gets the value of the dayTypeAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link DayTypeAssignments_RelStructure }
     *     
     */
    public DayTypeAssignments_RelStructure getDayTypeAssignments() {
        return dayTypeAssignments;
    }

    /**
     * Sets the value of the dayTypeAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayTypeAssignments_RelStructure }
     *     
     */
    public void setDayTypeAssignments(DayTypeAssignments_RelStructure value) {
        this.dayTypeAssignments = value;
    }

}
