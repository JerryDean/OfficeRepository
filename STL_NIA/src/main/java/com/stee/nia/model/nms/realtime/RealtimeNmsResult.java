package com.stee.nia.model.nms.realtime;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Jerry on 2016/12/18.
 */
@XmlRootElement(name = "NmsRESTResult")
@XmlType(propOrder = { "status", "message", "timeStamp", "resultObject" })
public class RealtimeNmsResult {
    private String status;
    private String message;
    private String timeStamp;
    private RealtimeResultObject resultObject;

    @Override
    public String toString() {
        return "RealtimeNmsResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", resultObject=" + resultObject +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public RealtimeResultObject getResultObject() {
        return resultObject;
    }

    public void setResultObject(RealtimeResultObject resultObject) {
        this.resultObject = resultObject;
    }
}
