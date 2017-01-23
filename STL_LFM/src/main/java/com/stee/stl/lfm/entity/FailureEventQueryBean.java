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

    private Integer pageNo;

    private Integer pageSize;

    private SeveritySort severitySort;

    private DateSort dateSort;

    public class SeveritySort {
        public String sort;
    }

    public class DateSort {
        public String sort;
    }

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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SeveritySort getSeveritySort() {
        return severitySort;
    }

    public void setSeveritySort(SeveritySort severitySort) {
        this.severitySort = severitySort;
    }

    public DateSort getDateSort() {
        return dateSort;
    }

    public void setDateSort(DateSort dateSort) {
        this.dateSort = dateSort;
    }
}
