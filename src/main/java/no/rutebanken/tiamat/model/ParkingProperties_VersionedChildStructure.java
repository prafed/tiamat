//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Type for a PARKING PROPERTies.
 * 
 * <p>Java class for ParkingProperties_VersionedChildStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParkingProperties_VersionedChildStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}VersionedChildStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}ParkingPropertiesGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParkingProperties_VersionedChildStructure", propOrder = {
    "parkingUserTypes",
    "parkingVehicleTypes",
    "parkingStayList",
    "maximumStay",
    "spaces",
    "charges"
})
@XmlSeeAlso({
    ParkingProperties.class
})
public class ParkingProperties_VersionedChildStructure
    extends VersionedChildStructure
{

    @XmlList
    @XmlElement(name = "ParkingUserTypes")
    @XmlSchemaType(name = "anySimpleType")
    protected List<ParkingUserEnumeration> parkingUserTypes;
    @XmlList
    @XmlElement(name = "ParkingVehicleTypes")
    @XmlSchemaType(name = "anySimpleType")
    protected List<ParkingVehicleEnumeration> parkingVehicleTypes;
    @XmlList
    @XmlElement(name = "ParkingStayList")
    @XmlSchemaType(name = "anySimpleType")
    protected List<ParkingStayEnumeration> parkingStayList;
    @XmlElement(name = "MaximumStay")
    protected Duration maximumStay;
    protected ParkingCapacities_RelStructure spaces;
    protected ParkingTariffRefs_RelStructure charges;

    /**
     * Gets the value of the parkingUserTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parkingUserTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParkingUserTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParkingUserEnumeration }
     * 
     * 
     */
    public List<ParkingUserEnumeration> getParkingUserTypes() {
        if (parkingUserTypes == null) {
            parkingUserTypes = new ArrayList<ParkingUserEnumeration>();
        }
        return this.parkingUserTypes;
    }

    /**
     * Gets the value of the parkingVehicleTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parkingVehicleTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParkingVehicleTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParkingVehicleEnumeration }
     * 
     * 
     */
    public List<ParkingVehicleEnumeration> getParkingVehicleTypes() {
        if (parkingVehicleTypes == null) {
            parkingVehicleTypes = new ArrayList<ParkingVehicleEnumeration>();
        }
        return this.parkingVehicleTypes;
    }

    /**
     * Gets the value of the parkingStayList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parkingStayList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParkingStayList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParkingStayEnumeration }
     * 
     * 
     */
    public List<ParkingStayEnumeration> getParkingStayList() {
        if (parkingStayList == null) {
            parkingStayList = new ArrayList<ParkingStayEnumeration>();
        }
        return this.parkingStayList;
    }

    /**
     * Gets the value of the maximumStay property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMaximumStay() {
        return maximumStay;
    }

    /**
     * Sets the value of the maximumStay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMaximumStay(Duration value) {
        this.maximumStay = value;
    }

    /**
     * Gets the value of the spaces property.
     * 
     * @return
     *     possible object is
     *     {@link ParkingCapacities_RelStructure }
     *     
     */
    public ParkingCapacities_RelStructure getSpaces() {
        return spaces;
    }

    /**
     * Sets the value of the spaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParkingCapacities_RelStructure }
     *     
     */
    public void setSpaces(ParkingCapacities_RelStructure value) {
        this.spaces = value;
    }

    /**
     * Gets the value of the charges property.
     * 
     * @return
     *     possible object is
     *     {@link ParkingTariffRefs_RelStructure }
     *     
     */
    public ParkingTariffRefs_RelStructure getCharges() {
        return charges;
    }

    /**
     * Sets the value of the charges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParkingTariffRefs_RelStructure }
     *     
     */
    public void setCharges(ParkingTariffRefs_RelStructure value) {
        this.charges = value;
    }

}