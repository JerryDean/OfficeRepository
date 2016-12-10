package com.stee.sel.lfm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
 * File Name    : BurningHourAlert.java
 * Author       : Jerry
 * Created      : 2016年12月1日 下午3:44:30
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LFM_BURNING_HOUR_ALERT")
public class BurningHourAlert {
	private Integer id;
	private String luminaireId;
	private Integer burningHour;
	private Integer ratio;
	private String alertMsg;
	private Integer severityLevel;
	private Integer trackingType;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "luminarire_id")
	public String getLuminaireId() {
		return luminaireId;
	}

	public void setLuminaireId(String luminaireId) {
		this.luminaireId = luminaireId;
	}

	@Column(name = "burning_hour")
	public Integer getBurningHour() {
		return burningHour;
	}

	public void setBurningHour(Integer burningHour) {
		this.burningHour = burningHour;
	}

	public Integer getRatio() {
		return ratio;
	}

	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}

	@Column(name = "alert_msg")
	public String getAlertMsg() {
		return alertMsg;
	}

	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}

	@Column(name = "severity_level")
	public Integer getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(Integer severityLevel) {
		this.severityLevel = severityLevel;
	}

	@Column(name = "tracking_type")
	public Integer getTrackingType() {
		return trackingType;
	}

	public void setTrackingType(Integer trackingType) {
		this.trackingType = trackingType;
	}

	@Override
	public String toString() {
		return "BurningHourAlert [id=" + id + ", luminaireId=" + luminaireId + ", burningHour=" + burningHour
				+ ", ratio=" + ratio + ", alertMsg=" + alertMsg + ", severityLevel=" + severityLevel + ", trackingType="
				+ trackingType + "]";
	}

}
