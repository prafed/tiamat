//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a list of STOP POINTs IN JOURNEY PATTERN.
 * 
 * <p>Java class for stopPointsInJourneyPattern_RelStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stopPointsInJourneyPattern_RelStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}strictContainmentAggregationStructure">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.netex.org.uk/netex}StopPointInJourneyPattern" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stopPointsInJourneyPattern_RelStructure", propOrder = {
    "stopPointInJourneyPattern"
})
public class StopPointsInJourneyPattern_RelStructure
    extends StrictContainmentAggregationStructure
{

    @XmlElement(name = "StopPointInJourneyPattern", required = true)
    protected List<StopPointInJourneyPattern> stopPointInJourneyPattern;

    /**
     * Gets the value of the stopPointInJourneyPattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stopPointInJourneyPattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStopPointInJourneyPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StopPointInJourneyPattern }
     * 
     * 
     */
    public List<StopPointInJourneyPattern> getStopPointInJourneyPattern() {
        if (stopPointInJourneyPattern == null) {
            stopPointInJourneyPattern = new ArrayList<StopPointInJourneyPattern>();
        }
        return this.stopPointInJourneyPattern;
    }

}