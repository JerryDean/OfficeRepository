/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : lfm
 * File Name    : FailureEventQueryBean
 * Author       : Jerry
 * Created      : 2017/1/16
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
package com.stee.stl.lfm.entity;

import java.util.Date;

/**
 * Created by SerryMiano on 2017/1/16.
 */
public class FailureEventQueryBean {
    private String eventSource;
    private Date start;
    private Date end;
    private String objectId;
    private String message;
    private Integer severityStart;
    private Integer severityEnd;
    private String eventType;

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSeverityStart() {
        return severityStart;
    }

    public void setSeverityStart(Integer severityStart) {
        this.severityStart = severityStart;
    }

    public Integer getSeverityEnd() {
        return severityEnd;
    }

    public void setSeverityEnd(Integer severityEnd) {
        this.severityEnd = severityEnd;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "FailureEventQueryBean{" +
                "eventSource='" + eventSource + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", objectId='" + objectId + '\'' +
                ", message='" + message + '\'' +
                ", severityStart=" + severityStart +
                ", severityEnd=" + severityEnd +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
