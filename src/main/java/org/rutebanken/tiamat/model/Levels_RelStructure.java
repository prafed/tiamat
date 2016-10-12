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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a list of LEVELs.
 * 
 * <p>Java class for levels_RelStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="levels_RelStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}containmentAggregationStructure">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{http://www.netex.org.uk/netex}LevelRef"/>
 *         &lt;element ref="{http://www.netex.org.uk/netex}Level"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "levels_RelStructure", propOrder = {
    "levelRefOrLevel"
})
public class Levels_RelStructure
    extends ContainmentAggregationStructure
{

    @XmlElements({
        @XmlElement(name = "LevelRef", type = LevelRefStructure.class),
        @XmlElement(name = "Level", type = Level.class)
    })
    protected List<Object> levelRefOrLevel;

    /**
     * Gets the value of the levelRefOrLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the levelRefOrLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLevelRefOrLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelRefStructure }
     * {@link Level }
     * 
     * 
     */
    public List<Object> getLevelRefOrLevel() {
        if (levelRefOrLevel == null) {
            levelRefOrLevel = new ArrayList<Object>();
        }
        return this.levelRefOrLevel;
    }

}