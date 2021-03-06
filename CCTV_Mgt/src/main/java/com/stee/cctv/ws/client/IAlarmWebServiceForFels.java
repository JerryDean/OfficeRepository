package com.stee.cctv.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.6
 * 2016-06-16T13:22:11.878+08:00
 * Generated source version: 3.0.6
 * 
 */
@WebService(targetNamespace = "http://ws.alarm.stee.com/", name = "IAlarmWebServiceForFels")
@XmlSeeAlso({ObjectFactory.class})
public interface IAlarmWebServiceForFels {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "updateFelsAlarm", targetNamespace = "http://ws.alarm.stee.com/", className = "com.stee.cctv.ws.client.UpdateFelsAlarm")
    @WebMethod
    @ResponseWrapper(localName = "updateFelsAlarmResponse", targetNamespace = "http://ws.alarm.stee.com/", className = "com.stee.cctv.ws.client.UpdateFelsAlarmResponse")
    public java.lang.String updateFelsAlarm(
        @WebParam(name = "alarmType", targetNamespace = "")
        com.stee.cctv.ws.client.AlarmType alarmType,
        @WebParam(name = "alarms", targetNamespace = "")
        java.util.List<com.stee.cctv.ws.client.Alarm> alarms
    );
}
