//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a STOP PLACE COMPONENT.
 * 
 * <p>Java class for StopPlaceComponent_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopPlaceComponent_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}SiteComponent_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}StopPlaceComponentPropertyGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StopPlaceComponent_VersionStructure", propOrder = {
    "transportMode",
    "airSubmode",
    "busSubmode",
    "coachSubmode",
    "funicularSubmode",
    "metroSubmode",
    "tramSubmode",
    "telecabinSubmode",
    "railSubmode",
    "waterSubmode",
    "otherTransportModes"
})
@XmlSeeAlso({
    StopPlaceSpace_VersionStructure.class
})
@MappedSuperclass
public abstract class StopPlaceComponent_VersionStructure
    extends SiteComponent_VersionStructure
{

    @XmlElement(name = "TransportMode")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected VehicleModeEnumeration transportMode;

    @XmlElement(name = "AirSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected AirSubmodeEnumeration airSubmode;

    @XmlElement(name = "BusSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected BusSubmodeEnumeration busSubmode;

    @XmlElement(name = "CoachSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected CoachSubmodeEnumeration coachSubmode;

    @XmlElement(name = "FunicularSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected FunicularSubmodeEnumeration funicularSubmode;

    @XmlElement(name = "MetroSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected MetroSubmodeEnumeration metroSubmode;

    @XmlElement(name = "TramSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected TramSubmodeEnumeration tramSubmode;

    @XmlElement(name = "TelecabinSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected TelecabinSubmodeEnumeration telecabinSubmode;

    @XmlElement(name = "RailSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected RailSubmodeEnumeration railSubmode;

    @XmlElement(name = "WaterSubmode", defaultValue = "unknown")
    @XmlSchemaType(name = "NMTOKEN")
    @Transient
    protected WaterSubmodeEnumeration waterSubmode;

    @XmlList
    @XmlElement(name = "OtherTransportModes")
    @XmlSchemaType(name = "anySimpleType")
    @Transient
    protected List<VehicleModeEnumeration> otherTransportModes;

    public StopPlaceComponent_VersionStructure(EmbeddableMultilingualString name) {
        super(name);
    }

    public StopPlaceComponent_VersionStructure() { }

    /**
     * Gets the value of the transportMode property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleModeEnumeration }
     *     
     */
    public VehicleModeEnumeration getTransportMode() {
        return transportMode;
    }

    /**
     * Sets the value of the transportMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleModeEnumeration }
     *     
     */
    public void setTransportMode(VehicleModeEnumeration value) {
        this.transportMode = value;
    }

    /**
     * Gets the value of the airSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link AirSubmodeEnumeration }
     *     
     */
    public AirSubmodeEnumeration getAirSubmode() {
        return airSubmode;
    }

    /**
     * Sets the value of the airSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirSubmodeEnumeration }
     *     
     */
    public void setAirSubmode(AirSubmodeEnumeration value) {
        this.airSubmode = value;
    }

    /**
     * Gets the value of the busSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link BusSubmodeEnumeration }
     *     
     */
    public BusSubmodeEnumeration getBusSubmode() {
        return busSubmode;
    }

    /**
     * Sets the value of the busSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusSubmodeEnumeration }
     *     
     */
    public void setBusSubmode(BusSubmodeEnumeration value) {
        this.busSubmode = value;
    }

    /**
     * Gets the value of the coachSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link CoachSubmodeEnumeration }
     *     
     */
    public CoachSubmodeEnumeration getCoachSubmode() {
        return coachSubmode;
    }

    /**
     * Sets the value of the coachSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoachSubmodeEnumeration }
     *     
     */
    public void setCoachSubmode(CoachSubmodeEnumeration value) {
        this.coachSubmode = value;
    }

    /**
     * Gets the value of the funicularSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link FunicularSubmodeEnumeration }
     *     
     */
    public FunicularSubmodeEnumeration getFunicularSubmode() {
        return funicularSubmode;
    }

    /**
     * Sets the value of the funicularSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunicularSubmodeEnumeration }
     *     
     */
    public void setFunicularSubmode(FunicularSubmodeEnumeration value) {
        this.funicularSubmode = value;
    }

    /**
     * Gets the value of the metroSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link MetroSubmodeEnumeration }
     *     
     */
    public MetroSubmodeEnumeration getMetroSubmode() {
        return metroSubmode;
    }

    /**
     * Sets the value of the metroSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetroSubmodeEnumeration }
     *     
     */
    public void setMetroSubmode(MetroSubmodeEnumeration value) {
        this.metroSubmode = value;
    }

    /**
     * Gets the value of the tramSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link TramSubmodeEnumeration }
     *     
     */
    public TramSubmodeEnumeration getTramSubmode() {
        return tramSubmode;
    }

    /**
     * Sets the value of the tramSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TramSubmodeEnumeration }
     *     
     */
    public void setTramSubmode(TramSubmodeEnumeration value) {
        this.tramSubmode = value;
    }

    /**
     * Gets the value of the telecabinSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link TelecabinSubmodeEnumeration }
     *     
     */
    public TelecabinSubmodeEnumeration getTelecabinSubmode() {
        return telecabinSubmode;
    }

    /**
     * Sets the value of the telecabinSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecabinSubmodeEnumeration }
     *     
     */
    public void setTelecabinSubmode(TelecabinSubmodeEnumeration value) {
        this.telecabinSubmode = value;
    }

    /**
     * Gets the value of the railSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link RailSubmodeEnumeration }
     *     
     */
    public RailSubmodeEnumeration getRailSubmode() {
        return railSubmode;
    }

    /**
     * Sets the value of the railSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RailSubmodeEnumeration }
     *     
     */
    public void setRailSubmode(RailSubmodeEnumeration value) {
        this.railSubmode = value;
    }

    /**
     * Gets the value of the waterSubmode property.
     * 
     * @return
     *     possible object is
     *     {@link WaterSubmodeEnumeration }
     *     
     */
    public WaterSubmodeEnumeration getWaterSubmode() {
        return waterSubmode;
    }

    /**
     * Sets the value of the waterSubmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link WaterSubmodeEnumeration }
     *     
     */
    public void setWaterSubmode(WaterSubmodeEnumeration value) {
        this.waterSubmode = value;
    }

    /**
     * Gets the value of the otherTransportModes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherTransportModes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherTransportModes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleModeEnumeration }
     * 
     * 
     */
    public List<VehicleModeEnumeration> getOtherTransportModes() {
        if (otherTransportModes == null) {
            otherTransportModes = new ArrayList<VehicleModeEnumeration>();
        }
        return this.otherTransportModes;
    }

}
