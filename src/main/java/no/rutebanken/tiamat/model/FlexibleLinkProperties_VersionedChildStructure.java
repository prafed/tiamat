//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for FLEXIBLE LINK PROPERTies.
 * 
 * <p>Java class for FlexibleLinkProperties_VersionedChildStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlexibleLinkProperties_VersionedChildStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}VersionedChildStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}FlexibleLinkPropertiesGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlexibleLinkProperties_VersionedChildStructure", propOrder = {
    "linkRef",
    "mayBeSkipped",
    "onMainRoute",
    "unscheduledPath",
    "flexibleLinkType"
})
@XmlSeeAlso({
    FlexibleLinkProperties.class
})
public class FlexibleLinkProperties_VersionedChildStructure
    extends VersionedChildStructure
{

    @XmlElementRef(name = "LinkRef", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends LinkRefStructure> linkRef;
    @XmlElement(name = "MayBeSkipped")
    protected Boolean mayBeSkipped;
    @XmlElement(name = "OnMainRoute")
    protected Boolean onMainRoute;
    @XmlElement(name = "UnscheduledPath")
    protected Boolean unscheduledPath;
    @XmlElement(name = "FlexibleLinkType")
    @XmlSchemaType(name = "string")
    protected FlexibleLinkTypeEnumeration flexibleLinkType;

    /**
     * Gets the value of the linkRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TimingLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link RouteLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ActivationLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link RailwayLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoadLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link InfrastructureLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link LinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link WireLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link LineLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link PathLinkRefStructure }{@code >}
     *     
     */
    public JAXBElement<? extends LinkRefStructure> getLinkRef() {
        return linkRef;
    }

    /**
     * Sets the value of the linkRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TimingLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link RouteLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ActivationLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link RailwayLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoadLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link InfrastructureLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link LinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link WireLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ServiceLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link LineLinkRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link PathLinkRefStructure }{@code >}
     *     
     */
    public void setLinkRef(JAXBElement<? extends LinkRefStructure> value) {
        this.linkRef = value;
    }

    /**
     * Gets the value of the mayBeSkipped property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMayBeSkipped() {
        return mayBeSkipped;
    }

    /**
     * Sets the value of the mayBeSkipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMayBeSkipped(Boolean value) {
        this.mayBeSkipped = value;
    }

    /**
     * Gets the value of the onMainRoute property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnMainRoute() {
        return onMainRoute;
    }

    /**
     * Sets the value of the onMainRoute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnMainRoute(Boolean value) {
        this.onMainRoute = value;
    }

    /**
     * Gets the value of the unscheduledPath property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnscheduledPath() {
        return unscheduledPath;
    }

    /**
     * Sets the value of the unscheduledPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnscheduledPath(Boolean value) {
        this.unscheduledPath = value;
    }

    /**
     * Gets the value of the flexibleLinkType property.
     * 
     * @return
     *     possible object is
     *     {@link FlexibleLinkTypeEnumeration }
     *     
     */
    public FlexibleLinkTypeEnumeration getFlexibleLinkType() {
        return flexibleLinkType;
    }

    /**
     * Sets the value of the flexibleLinkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexibleLinkTypeEnumeration }
     *     
     */
    public void setFlexibleLinkType(FlexibleLinkTypeEnumeration value) {
        this.flexibleLinkType = value;
    }

}