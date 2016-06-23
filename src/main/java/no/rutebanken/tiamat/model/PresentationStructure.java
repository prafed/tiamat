//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.06 at 10:37:32 AM CET 
//


package no.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Types describing common presentation properties.
 * 
 * <p>Java class for PresentationStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PresentationStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Colour" type="{http://www.netex.org.uk/netex}ColourValueType" minOccurs="0"/>
 *         &lt;element name="ColourName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TextColour" type="{http://www.netex.org.uk/netex}ColourValueType" minOccurs="0"/>
 *         &lt;element name="TextColourName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TextFont" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *         &lt;element name="TextFontName" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *         &lt;element name="TextLanguage" type="{http://www.w3.org/2001/XMLSchema}language" minOccurs="0"/>
 *         &lt;element name="infoLinks" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.netex.org.uk/netex}InfoLink" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PresentationStructure", propOrder = {
    "colour",
    "colourName",
    "textColour",
    "textColourName",
    "textFont",
    "textFontName",
    "textLanguage",
    "infoLinks"
})
public class PresentationStructure {

    @XmlElement(name = "Colour", type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] colour;
    @XmlElement(name = "ColourName")
    protected String colourName;
    @XmlElement(name = "TextColour", type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] textColour;
    @XmlElement(name = "TextColourName")
    protected String textColourName;
    @XmlElement(name = "TextFont")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String textFont;
    @XmlElement(name = "TextFontName")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String textFontName;
    @XmlElement(name = "TextLanguage")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String textLanguage;
    protected InfoLinks infoLinks;

    /**
     * Gets the value of the colour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getColour() {
        return colour;
    }

    /**
     * Sets the value of the colour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColour(byte[] value) {
        this.colour = value;
    }

    /**
     * Gets the value of the colourName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColourName() {
        return colourName;
    }

    /**
     * Sets the value of the colourName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColourName(String value) {
        this.colourName = value;
    }

    /**
     * Gets the value of the textColour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getTextColour() {
        return textColour;
    }

    /**
     * Sets the value of the textColour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextColour(byte[] value) {
        this.textColour = value;
    }

    /**
     * Gets the value of the textColourName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextColourName() {
        return textColourName;
    }

    /**
     * Sets the value of the textColourName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextColourName(String value) {
        this.textColourName = value;
    }

    /**
     * Gets the value of the textFont property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextFont() {
        return textFont;
    }

    /**
     * Sets the value of the textFont property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextFont(String value) {
        this.textFont = value;
    }

    /**
     * Gets the value of the textFontName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextFontName() {
        return textFontName;
    }

    /**
     * Sets the value of the textFontName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextFontName(String value) {
        this.textFontName = value;
    }

    /**
     * Gets the value of the textLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextLanguage() {
        return textLanguage;
    }

    /**
     * Sets the value of the textLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextLanguage(String value) {
        this.textLanguage = value;
    }

    /**
     * Gets the value of the infoLinks property.
     * 
     * @return
     *     possible object is
     *     {@link InfoLinks }
     *     
     */
    public InfoLinks getInfoLinks() {
        return infoLinks;
    }

    /**
     * Sets the value of the infoLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoLinks }
     *     
     */
    public void setInfoLinks(InfoLinks value) {
        this.infoLinks = value;
    }

}