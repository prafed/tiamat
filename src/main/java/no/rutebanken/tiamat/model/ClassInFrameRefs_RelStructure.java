//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a list of Class Filter references.
 * 
 * <p>Java class for ClassInFrameRefs_RelStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassInFrameRefs_RelStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}oneToManyRelationshipStructure">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.netex.org.uk/netex}ClassInFrameRef" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassInFrameRefs_RelStructure", propOrder = {
    "classInFrameRef"
})
public class ClassInFrameRefs_RelStructure
    extends OneToManyRelationshipStructure
{

    @XmlElement(name = "ClassInFrameRef", required = true)
    protected List<ClassInFrameRefStructure> classInFrameRef;

    /**
     * Gets the value of the classInFrameRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classInFrameRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassInFrameRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassInFrameRefStructure }
     * 
     * 
     */
    public List<ClassInFrameRefStructure> getClassInFrameRef() {
        if (classInFrameRef == null) {
            classInFrameRef = new ArrayList<ClassInFrameRefStructure>();
        }
        return this.classInFrameRef;
    }

}