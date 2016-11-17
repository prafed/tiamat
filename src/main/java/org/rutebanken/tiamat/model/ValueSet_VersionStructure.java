//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Type for a VALUE SET. Abstract supertype  used to define open  classifications of  value types.
 * 
 * <p>Java class for ValueSet_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValueSet_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}DataManagedObjectStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}ValueSetGroup"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classOfValues" type="{http://www.netex.org.uk/netex}NameOfClass" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueSet_VersionStructure", propOrder = {
    "name",
    "values"
})
@XmlSeeAlso({
    ValueSet.class
})
public class ValueSet_VersionStructure
    extends DataManagedObjectStructure
{

    @XmlElement(name = "Name")
    protected MultilingualStringEntity name;
    protected TypesOfValueStructure values;
    @XmlAttribute(name = "classOfValues")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String classOfValues;

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
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link TypesOfValueStructure }
     *     
     */
    public TypesOfValueStructure getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypesOfValueStructure }
     *     
     */
    public void setValues(TypesOfValueStructure value) {
        this.values = value;
    }

    /**
     * Gets the value of the classOfValues property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassOfValues() {
        return classOfValues;
    }

    /**
     * Sets the value of the classOfValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassOfValues(String value) {
        this.classOfValues = value;
    }

}
