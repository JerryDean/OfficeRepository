package com.stee.sel.lim.status;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stee.sel.constant.OperationState;

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
 * File Name    : LampStatus.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午1:32:27
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LIM_LAMP_STATUS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LampStatus {

	/**
	 * Unique Code
	 */
	private Integer id;

	/**
	 * Operation State (INS, OOS-LampFailure, OOS-NodeFailure, OOS-CommsFailure,
	 * Unknown
	 */
	private OperationState operationState;

	/**
	 * Burning Hour (accumulated value)
	 */
	private Integer burningHour;

	/**
	 * Latest accumulated energy usage & associated date/time
	 */
	private EnergyUsage energyUsage;

	/**
	 * Installation Date
	 */
	private Date installedDate;

	/**
	 * Lamp level feedback
	 */
	private Integer lampLevel;

	/**
	 * Lamp switch feeadback
	 */
	private boolean lampSwitch;

	/**
	 * Current (mA)
	 */
	private Float currentFlow;

	/**
	 * Voltage (V)
	 */
	private Float voltage;

	/**
	 * Lamp Active Power (W)
	 */
	private Float activePower;

	/**
	 * Lamp Reactive Power (Var)
	 */
	private Float reactivePower;

	/**
	 * Lamp Apparent Power (VA)
	 */
	private Float apparentPower;

	/**
	 * Power Factor
	 */
	private Float powerFactor;

	/**
	 * Temperature
	 */
	private Float temperature;

	/**
	 * Node Failure Message
	 */
	private String nodeFailureMessage;

	@Column(name = "operation_state")
	@Enumerated(EnumType.STRING)
	public OperationState getOperationState() {
		return operationState;
	}

	public void setOperationState(OperationState operationState) {
		this.operationState = operationState;
	}

	@Column(name = "burn_hour")
	public Integer getBurningHour() {
		return burningHour;
	}

	public void setBurningHour(Integer burningHour) {
		this.burningHour = burningHour;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usage_id")
	public EnergyUsage getEnergyUsage() {
		return energyUsage;
	}

	public void setEnergyUsage(EnergyUsage energyUsage) {
		this.energyUsage = energyUsage;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "installed_date")
	public Date getInstalledDate() {
		return installedDate;
	}

	public void setInstalledDate(Date installedDate) {
		this.installedDate = installedDate;
	}

	@Column(name = "lamp_level")
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

	public Float getCurrentFlow() {
		return currentFlow;
	}

	public void setCurrentFlow(Float currentFlow) {
		this.currentFlow = currentFlow;
	}

	public Float getVoltage() {
		return voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	@Column(name = "active_power")
	public Float getActivePower() {
		return activePower;
	}

	public void setActivePower(Float activePower) {
		this.activePower = activePower;
	}

	@Column(name = "reactive_power")
	public Float getReactivePower() {
		return reactivePower;
	}

	public void setReactivePower(Float reactivePower) {
		this.reactivePower = reactivePower;
	}

	@Column(name = "apparent_power")
	public Float getApparentPower() {
		return apparentPower;
	}

	public void setApparentPower(Float apparentPower) {
		this.apparentPower = apparentPower;
	}

	@Column(name = "power_factor")
	public Float getPowerFactor() {
		return powerFactor;
	}

	public void setPowerFactor(Float powerFactor) {
		this.powerFactor = powerFactor;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	@Column(name = "node_fail_message")
	public String getNodeFailureMessage() {
		return nodeFailureMessage;
	}

	public void setNodeFailureMessage(String nodeFailureMessage) {
		this.nodeFailureMessage = nodeFailureMessage;
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
		return "LampStatus [id=" + id + ", operationState=" + operationState + ", burningHour=" + burningHour
				+ ", energyUsage=" + energyUsage + ", installedDate=" + installedDate + ", lampLevel=" + lampLevel
				+ ", lampSwitch=" + lampSwitch + ", currentFlow=" + currentFlow + ", voltage=" + voltage
				+ ", activePower=" + activePower + ", reactivePower=" + reactivePower + ", apparentPower="
				+ apparentPower + ", powerFactor=" + powerFactor + ", temperature=" + temperature
				+ ", nodeFailureMessage=" + nodeFailureMessage + "]";
	}

}
