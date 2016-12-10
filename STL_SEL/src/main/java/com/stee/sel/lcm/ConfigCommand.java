package com.stee.sel.lcm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
 * File Name    : SetTemplate.java
 * Author       : Jerry
 * Created      : 2016年10月14日 下午3:36:44
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LCM_COMMAND")
public class ConfigCommand {
	/**
	 * Unique Code
	 */
	private String deviceId;

	/**
	 * Dimming of lamp,range of [0 - 100]
	 */
	private Integer lampLevel;

	/**
	 * Lamp [On/Off]
	 */
	private boolean lampSwitch;

	/**
	 * Control mode: Manual/Automatic
	 */
	private Integer controlMode;

	private Date commissionDate;

	@Id
	@Column(name = "device_id")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "lamp_level", length = 3)
	public Integer getLampLevel() {
		return lampLevel;
	}

	public void setLampLevel(Integer lampLevel) {
		this.lampLevel = lampLevel;
	}

	@Column(name = "lamp_switch")
	public boolean isLampSwitch() {
		return lampSwitch;
	}

	public void setLampSwitch(boolean lampSwitch) {
		this.lampSwitch = lampSwitch;
	}

	@Temporal(TemporalType.DATE)
	public Date getCommissionDate() {
		return commissionDate;
	}

	public void setCommissionDate(Date commissionDate) {
		this.commissionDate = commissionDate;
	}

	@Column(name = "comtrol_mode")
	public Integer getControlMode() {
		return controlMode;
	}

	public void setControlMode(Integer controlMode) {
		this.controlMode = controlMode;
	}

	@Override
	public String toString() {
		return "ConfigCommand [deviceId=" + deviceId + ", lampLevel=" + lampLevel + ", lampSwitch=" + lampSwitch
				+ ", controlMode=" + controlMode + ", commissionDate=" + commissionDate + "]";
	}

}
