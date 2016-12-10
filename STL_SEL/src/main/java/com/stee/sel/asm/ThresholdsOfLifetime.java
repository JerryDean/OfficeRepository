package com.stee.sel.asm;

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
 * File Name    : ThresholdsOfLifetime.java
 * Author       : Jerry
 * Created      : 2016年12月1日 上午10:09:55
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_ASM_THRESHOLDS_LIFETIME")
public class ThresholdsOfLifetime {
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * A threshold with range 0% - 100%
	 */
	private String threshold;
	/**
	 * Alert text message
	 */
	private String alertMsg;
	/**
	 * Severity level
	 */
	private Integer severityLevel;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
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

	@Override
	public String toString() {
		return "ThresholdsOfLifetime [id=" + id + ", threshold=" + threshold + ", alertMsg=" + alertMsg
				+ ", severityLevel=" + severityLevel + "]";
	}

}
