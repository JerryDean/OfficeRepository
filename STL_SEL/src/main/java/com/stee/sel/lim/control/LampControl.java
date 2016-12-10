package com.stee.sel.lim.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stee.sel.constant.ControlMode;

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
 * File Name    : LampControl.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午1:31:58
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LIM_LAMP_CONTROL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LampControl {

	/**
	 * Unique Code
	 */
	private Integer id;

	/**
	 * Mode (Manual or Auto)
	 */
	private ControlMode controlMode;

	/**
	 * Dimming Group
	 */
	private String dimmingGroupId;

	/**
	 * Scheduling Plan(1.Commissioned Scheduling Plan & commissioned date 2.
	 * Currently effected Command (ON/OFF/Dim with Dimming setting))
	 */
	private String schedulingPlanId;

	@Column(name = "control_mode")
	@Enumerated(EnumType.STRING)
	public ControlMode getControlMode() {
		return controlMode;
	}

	public void setControlMode(ControlMode controlMode) {
		this.controlMode = controlMode;
	}

	@Column(name = "dimg_id")
	public String getDimmingGroupId() {
		return dimmingGroupId;
	}

	public void setDimmingGroupId(String dimmingGroupId) {
		this.dimmingGroupId = dimmingGroupId;
	}

	@Column(name = "scheduling_plan_id")
	public String getSchedulingPlanId() {
		return schedulingPlanId;
	}

	public void setSchedulingPlanId(String schedulingPlanId) {
		this.schedulingPlanId = schedulingPlanId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LampControl [id=" + id + ", controlMode=" + controlMode + ", dimmingGroupId=" + dimmingGroupId
				+ ", schedulingPlanId=" + schedulingPlanId + "]";
	}

}
