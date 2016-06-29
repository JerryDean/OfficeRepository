
package com.stee.cctv.ws.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateFelsAlarm complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateFelsAlarm"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alarmType" type="{http://ws.alarm.stee.com/}alarmType" minOccurs="0"/&gt;
 *         &lt;element name="alarms" type="{http://ws.alarm.stee.com/}alarm" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateFelsAlarm", propOrder = {
    "alarmType",
    "alarms"
})
public class UpdateFelsAlarm {

    @XmlSchemaType(name = "string")
    protected AlarmType alarmType;
    protected List<Alarm> alarms;

    /**
     * 获取alarmType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmType }
     *     
     */
    public AlarmType getAlarmType() {
        return alarmType;
    }

    /**
     * 设置alarmType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmType }
     *     
     */
    public void setAlarmType(AlarmType value) {
        this.alarmType = value;
    }

    /**
     * Gets the value of the alarms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alarms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlarms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Alarm }
     * 
     * 
     */
    public List<Alarm> getAlarms() {
        if (alarms == null) {
            alarms = new ArrayList<Alarm>();
        }
        return this.alarms;
    }

}
