package com.stee.sel.lfm;

import javax.persistence.*;
import java.util.Date;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_SEL
 * File Name    : FailureEvent.java
 * Author       : Jerry
 * Created      : 2016年12月9日 下午2:29:41
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LFM_EVENT_LOG")
public class FailureEvent {
	/**
	 * Event ID
	 */
	private Integer id;
	/**
	 * Event Source(Luminaire,Gateway,NMS,Application)
	 */
	private EventSource eventSource;
	/**
	 * Date and time
	 */
	private Date occurDate;
	/**
	 * Event/Alert/Alarm ID
	 */
	private String objectId;
	/**
	 * Event/Alert/Alarm Message
	 */
	private String message;
	/**
	 * Only for Alert or Alarm.Severity level.
	 */
	private Integer severityLevel;
    /**
     * Event Type.(Burning Hour Alert, Electricity Params Alert,Energy Usage Alert,Lamp failure)
     */
	private EventTypeEnum eventType;

	@Column(name = "event_type")
    @Enumerated(value = EnumType.STRING)
    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    @Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "event_source")
	@Enumerated(EnumType.STRING)
	public EventSource getEventSource() {
		return eventSource;
	}

	public void setEventSource(EventSource eventSource) {
		this.eventSource = eventSource;
	}

	@Column(name = "object_id")
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

	@Column(name = "severity_level")
	public Integer getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(Integer severityLevel) {
		this.severityLevel = severityLevel;
	}

	@Column(name = "occur_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOccurDate() {
		return occurDate;
	}

	public void setOccurDate(Date occurDate) {
		this.occurDate = occurDate;
	}

    @Override
    public String toString() {
        return "FailureEvent{" +
                "id=" + id +
                ", eventSource=" + eventSource +
                ", occurDate=" + occurDate +
                ", objectId='" + objectId + '\'' +
                ", message='" + message + '\'' +
                ", severityLevel=" + severityLevel +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
