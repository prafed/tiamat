//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a TRAIN IN COMPOUND TRAIN.
 * 
 * <p>Java class for TrainInCompoundTrain_VersionedChildStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrainInCompoundTrain_VersionedChildStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}VersionedChildStructure">
 *       &lt;group ref="{http://www.netex.org.uk/netex}TrainInCompoundTrainGroup"/>
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrainInCompoundTrain_VersionedChildStructure", propOrder = {
    "description",
    "compoundTrainRef",
    "trainRef",
    "train",
    "reversedOrientation",
    "label"
})
public class TrainInCompoundTrain_VersionedChildStructure
    extends VersionedChildStructure
{

    @XmlElement(name = "Description")
    protected MultilingualString description;
    @XmlElement(name = "CompoundTrainRef")
    protected CompoundTrainRef compoundTrainRef;
    @XmlElement(name = "TrainRef")
    protected TrainRefStructure trainRef;
    @XmlElement(name = "Train")
    protected Train train;
    @XmlElement(name = "ReversedOrientation", defaultValue = "false")
    protected Boolean reversedOrientation;
    @XmlElement(name = "Label")
    protected MultilingualString label;
    @XmlAttribute(name = "order")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger order;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualString }
     *     
     */
    public MultilingualString getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualString }
     *     
     */
    public void setDescription(MultilingualString value) {
        this.description = value;
    }

    /**
     * Reference to a TRAIN ELEMENT.
     * 
     * @return
     *     possible object is
     *     {@link CompoundTrainRef }
     *     
     */
    public CompoundTrainRef getCompoundTrainRef() {
        return compoundTrainRef;
    }

    /**
     * Sets the value of the compoundTrainRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompoundTrainRef }
     *     
     */
    public void setCompoundTrainRef(CompoundTrainRef value) {
        this.compoundTrainRef = value;
    }

    /**
     * Reference to a TRAIN.
     * 
     * @return
     *     possible object is
     *     {@link TrainRefStructure }
     *     
     */
    public TrainRefStructure getTrainRef() {
        return trainRef;
    }

    /**
     * Sets the value of the trainRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainRefStructure }
     *     
     */
    public void setTrainRef(TrainRefStructure value) {
        this.trainRef = value;
    }

    /**
     * Gets the value of the train property.
     * 
     * @return
     *     possible object is
     *     {@link Train }
     *     
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Sets the value of the train property.
     * 
     * @param value
     *     allowed object is
     *     {@link Train }
     *     
     */
    public void setTrain(Train value) {
        this.train = value;
    }

    /**
     * Gets the value of the reversedOrientation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReversedOrientation() {
        return reversedOrientation;
    }

    /**
     * Sets the value of the reversedOrientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReversedOrientation(Boolean value) {
        this.reversedOrientation = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualString }
     *     
     */
    public MultilingualString getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualString }
     *     
     */
    public void setLabel(MultilingualString value) {
        this.label = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrder(BigInteger value) {
        this.order = value;
    }

}