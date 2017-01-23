package com.stee.nia.model.nms.scheduled;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Jerry on 2017/1/22.
 */
@XmlRootElement(name = "NmsRESTResult")
@XmlType(propOrder = { "status", "message", "timeStamp", "resultObject" })
public class ScheduledResult {
    private String status;
    private String message;
    private String timeStamp;
    private ScheduledObject resultObject;

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

    public ScheduledObject getResultObject() {
        return resultObject;
    }

    public void setResultObject(ScheduledObject resultObject) {
        this.resultObject = resultObject;
    }

    @Override
    public String toString() {
        return "ScheduledResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", resultObject=" + resultObject +
                '}';
    }
}
