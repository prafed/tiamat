//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Type for a VERSION.
 * 
 * <p>Java class for Version_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Version_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}DataManagedObjectStructure">
 *       &lt;sequence>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.netex.org.uk/netex}VersionStatusEnumeration" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.netex.org.uk/netex}MultilingualStringEntity" minOccurs="0"/>
 *         &lt;element name="VersionType" type="{http://www.netex.org.uk/netex}VersionTypeEnumeration" minOccurs="0"/>
 *         &lt;element name="DerivedFromVersionRef" type="{http://www.netex.org.uk/netex}VersionRefStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version_VersionStructure", propOrder = {
    "rest"
})
@XmlSeeAlso({
    Version.class
})
public class Version_VersionStructure
    extends DataManagedObjectStructure
{

    @XmlElementRefs({
        @XmlElementRef(name = "Description", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DerivedFromVersionRef", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Status", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EndDate", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VersionType", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Status" is used by two different parts of a schema. See: 
     * line 199 of file:/Users/cris/git/NeTEx/xsd/netex_framework/netex_responsibility/netex_version_version-v1.0.xsd
     * line 158 of file:/Users/cris/git/NeTEx/xsd/netex_framework/netex_responsibility/netex_version_support-v1.0.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MultilingualStringEntity }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionTypeEnumeration }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionStatusEnumeration }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

}
