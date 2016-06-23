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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Type for TIMING POINT IN JOURNEY PATTERN.
 * 
 * <p>Java class for TimingPointInJourneyPattern_VersionedChildStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimingPointInJourneyPattern_VersionedChildStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}PointInLinkSequence_VersionedChildStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}TimingPointInJourneyPatternGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimingPointInJourneyPattern_VersionedChildStructure", propOrder = {
    "timingPointRef",
    "onwardTimingLinkRef",
    "isWaitPoint",
    "waitTime",
    "waitTimes",
    "headways",
    "noticeAssignments"
})
@XmlSeeAlso({
    TimingPointInJourneyPattern.class
})
public class TimingPointInJourneyPattern_VersionedChildStructure
    extends PointInLinkSequence_VersionedChildStructure
{

    @XmlElementRef(name = "TimingPointRef", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class)
    protected JAXBElement<? extends TimingPointRefStructure> timingPointRef;
    @XmlElement(name = "OnwardTimingLinkRef")
    protected TimingLinkRefStructure onwardTimingLinkRef;
    @XmlElement(name = "IsWaitPoint", defaultValue = "false")
    protected Boolean isWaitPoint;
    @XmlElement(name = "WaitTime")
    protected Duration waitTime;
    protected JourneyPatternWaitTimes_RelStructure waitTimes;
    protected JourneyPatternHeadways_RelStructure headways;
    protected NoticeAssignments_RelStructure noticeAssignments;

    /**
     * Gets the value of the timingPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ParkingPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ScheduledStopPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link GaragePointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link FareScheduledStopPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimingPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link BorderPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReliefPointRefStructure }{@code >}
     *     
     */
    public JAXBElement<? extends TimingPointRefStructure> getTimingPointRef() {
        return timingPointRef;
    }

    /**
     * Sets the value of the timingPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ParkingPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ScheduledStopPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link GaragePointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link FareScheduledStopPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimingPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link BorderPointRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReliefPointRefStructure }{@code >}
     *     
     */
    public void setTimingPointRef(JAXBElement<? extends TimingPointRefStructure> value) {
        this.timingPointRef = value;
    }

    /**
     * Gets the value of the onwardTimingLinkRef property.
     * 
     * @return
     *     possible object is
     *     {@link TimingLinkRefStructure }
     *     
     */
    public TimingLinkRefStructure getOnwardTimingLinkRef() {
        return onwardTimingLinkRef;
    }

    /**
     * Sets the value of the onwardTimingLinkRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimingLinkRefStructure }
     *     
     */
    public void setOnwardTimingLinkRef(TimingLinkRefStructure value) {
        this.onwardTimingLinkRef = value;
    }

    /**
     * Gets the value of the isWaitPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsWaitPoint() {
        return isWaitPoint;
    }

    /**
     * Sets the value of the isWaitPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsWaitPoint(Boolean value) {
        this.isWaitPoint = value;
    }

    /**
     * Gets the value of the waitTime property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getWaitTime() {
        return waitTime;
    }

    /**
     * Sets the value of the waitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setWaitTime(Duration value) {
        this.waitTime = value;
    }

    /**
     * Gets the value of the waitTimes property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternWaitTimes_RelStructure }
     *     
     */
    public JourneyPatternWaitTimes_RelStructure getWaitTimes() {
        return waitTimes;
    }

    /**
     * Sets the value of the waitTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternWaitTimes_RelStructure }
     *     
     */
    public void setWaitTimes(JourneyPatternWaitTimes_RelStructure value) {
        this.waitTimes = value;
    }

    /**
     * Gets the value of the headways property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternHeadways_RelStructure }
     *     
     */
    public JourneyPatternHeadways_RelStructure getHeadways() {
        return headways;
    }

    /**
     * Sets the value of the headways property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternHeadways_RelStructure }
     *     
     */
    public void setHeadways(JourneyPatternHeadways_RelStructure value) {
        this.headways = value;
    }

    /**
     * Gets the value of the noticeAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link NoticeAssignments_RelStructure }
     *     
     */
    public NoticeAssignments_RelStructure getNoticeAssignments() {
        return noticeAssignments;
    }

    /**
     * Sets the value of the noticeAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoticeAssignments_RelStructure }
     *     
     */
    public void setNoticeAssignments(NoticeAssignments_RelStructure value) {
        this.noticeAssignments = value;
    }

}