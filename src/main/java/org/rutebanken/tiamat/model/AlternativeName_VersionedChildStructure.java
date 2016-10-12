//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Type for ALTERNATIVE NAME.
 * <p>
 * <p>Java class for AlternativeName_VersionedChildStructure complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="AlternativeName_VersionedChildStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}VersionedChildStructure">
 *       &lt;sequence>
 *         &lt;element name="NamedObjectRef" type="{http://www.netex.org.uk/netex}VersionOfObjectRefStructure" minOccurs="0"/>
 *         &lt;element name="Lang" type="{http://www.w3.org/2001/XMLSchema}language" minOccurs="0"/>
 *         &lt;element name="NameType" type="{http://www.netex.org.uk/netex}NameTypeEnumeration" minOccurs="0"/>
 *         &lt;element name="TypeOfName" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.netex.org.uk/netex}MultilingualString"/>
 *         &lt;element name="ShortName" type="{http://www.netex.org.uk/netex}MultilingualString" minOccurs="0"/>
 *         &lt;element name="Abbreviation" type="{http://www.netex.org.uk/netex}MultilingualString" minOccurs="0"/>
 *         &lt;element name="QualifierName" type="{http://www.netex.org.uk/netex}MultilingualString" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlternativeName_VersionedChildStructure", propOrder = {
        "namedObjectRef",
        "lang",
        "nameType",
        "typeOfName",
        "name",
        "shortName",
        "abbreviation",
        "qualifierName"
})
@XmlSeeAlso({
        AlternativeName.class,
        AlternativeQuayDescriptor_VersionedChildStructure.class
})
@MappedSuperclass
public class AlternativeName_VersionedChildStructure
        extends VersionedChildStructure {

    @XmlElement(name = "NamedObjectRef")
    protected VersionOfObjectRefStructure namedObjectRef;

    @XmlElement(name = "Lang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;

    @XmlElement(name = "NameType", defaultValue = "alias")
    @XmlSchemaType(name = "string")
    protected NameTypeEnumeration nameType;

    @XmlElement(name = "TypeOfName")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String typeOfName;

    @XmlElement(name = "Name", required = true)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected MultilingualString name;

    @XmlElement(name = "ShortName")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected MultilingualString shortName;

    @XmlElement(name = "Abbreviation")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected MultilingualString abbreviation;

    @XmlElement(name = "QualifierName")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected MultilingualString qualifierName;

    @XmlAttribute(name = "order")
    @Transient
    protected BigInteger order;

    /**
     * Gets the value of the namedObjectRef property.
     *
     * @return possible object is
     * {@link VersionOfObjectRefStructure }
     */
    public VersionOfObjectRefStructure getNamedObjectRef() {
        return namedObjectRef;
    }

    /**
     * Sets the value of the namedObjectRef property.
     *
     * @param value allowed object is
     *              {@link VersionOfObjectRefStructure }
     */
    public void setNamedObjectRef(VersionOfObjectRefStructure value) {
        this.namedObjectRef = value;
    }

    /**
     * Gets the value of the lang property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the nameType property.
     *
     * @return possible object is
     * {@link NameTypeEnumeration }
     */
    public NameTypeEnumeration getNameType() {
        return nameType;
    }

    /**
     * Sets the value of the nameType property.
     *
     * @param value allowed object is
     *              {@link NameTypeEnumeration }
     */
    public void setNameType(NameTypeEnumeration value) {
        this.nameType = value;
    }

    /**
     * Gets the value of the typeOfName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTypeOfName() {
        return typeOfName;
    }

    /**
     * Sets the value of the typeOfName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTypeOfName(String value) {
        this.typeOfName = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link MultilingualString }
     */
    public MultilingualString getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link MultilingualString }
     */
    public void setName(MultilingualString value) {
        this.name = value;
    }

    /**
     * Gets the value of the shortName property.
     *
     * @return possible object is
     * {@link MultilingualString }
     */
    public MultilingualString getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     *
     * @param value allowed object is
     *              {@link MultilingualString }
     */
    public void setShortName(MultilingualString value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the abbreviation property.
     *
     * @return possible object is
     * {@link MultilingualString }
     */
    public MultilingualString getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the value of the abbreviation property.
     *
     * @param value allowed object is
     *              {@link MultilingualString }
     */
    public void setAbbreviation(MultilingualString value) {
        this.abbreviation = value;
    }

    /**
     * Gets the value of the qualifierName property.
     *
     * @return possible object is
     * {@link MultilingualString }
     */
    public MultilingualString getQualifierName() {
        return qualifierName;
    }

    /**
     * Sets the value of the qualifierName property.
     *
     * @param value allowed object is
     *              {@link MultilingualString }
     */
    public void setQualifierName(MultilingualString value) {
        this.qualifierName = value;
    }

    /**
     * Gets the value of the order property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setOrder(BigInteger value) {
        this.order = value;
    }

}