
package com.stee.cctv.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.stee.cctv.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateFelsAlarm_QNAME = new QName("http://ws.alarm.stee.com/", "updateFelsAlarm");
    private final static QName _UpdateFelsAlarmResponse_QNAME = new QName("http://ws.alarm.stee.com/", "updateFelsAlarmResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.stee.cctv.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateFelsAlarm }
     * 
     */
    public UpdateFelsAlarm createUpdateFelsAlarm() {
        return new UpdateFelsAlarm();
    }

    /**
     * Create an instance of {@link UpdateFelsAlarmResponse }
     * 
     */
    public UpdateFelsAlarmResponse createUpdateFelsAlarmResponse() {
        return new UpdateFelsAlarmResponse();
    }

    /**
     * Create an instance of {@link Alarm }
     * 
     */
    public Alarm createAlarm() {
        return new Alarm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFelsAlarm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.alarm.stee.com/", name = "updateFelsAlarm")
    public JAXBElement<UpdateFelsAlarm> createUpdateFelsAlarm(UpdateFelsAlarm value) {
        return new JAXBElement<UpdateFelsAlarm>(_UpdateFelsAlarm_QNAME, UpdateFelsAlarm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFelsAlarmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.alarm.stee.com/", name = "updateFelsAlarmResponse")
    public JAXBElement<UpdateFelsAlarmResponse> createUpdateFelsAlarmResponse(UpdateFelsAlarmResponse value) {
        return new JAXBElement<UpdateFelsAlarmResponse>(_UpdateFelsAlarmResponse_QNAME, UpdateFelsAlarmResponse.class, null, value);
    }

}
