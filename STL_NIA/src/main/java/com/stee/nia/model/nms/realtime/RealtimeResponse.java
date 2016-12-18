package com.stee.nia.model.nms.realtime;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by Jerry on 2016/12/18.
 */
@XmlType(name = "response", propOrder = { "status", "date", "value", "statusInfo" })
public class RealtimeResponse {
    private String status;

    private Date date;

    private Object value;

    private String statusInfo;

    @Override
    public String toString() {
        return "RealtimeResponse{" +
                "status='" + status + '\'' +
                ", date=" + date +
                ", value=" + value +
                ", statusInfo='" + statusInfo + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
}
