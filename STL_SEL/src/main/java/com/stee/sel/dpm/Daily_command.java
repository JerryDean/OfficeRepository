package com.stee.sel.dpm;

import java.io.Serializable;

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
 * Project Name : STL_DPM
 * File Name    : Daily_Command.java
 * Package Name : com.stee.dpm.entity
 * Author       : chenshaoyin
 * Created      : 2016年11月2日 ---- 下午1:52:42
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name="STL_DPM_COMMAND")
public class Daily_command implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@Column(name="DAILY_NAME")
//	private String dailyName;
	
	@Column(name="COMMANDTYPE")
	private int commandType;
	
	@Column(name="TIMMINGTYPE")
	private int timingType;
	
	@Column(name="STARTTIME")
	private String startTime;
	
	@Column(name="COMMANDTIMING")
	private String commandTiming;
	
	@Column(name="COMMANDVALUE")
	private int commandValue;

//	public String getDailyName() {
//		return dailyName;
//	}
//
//	public void setDailyName(String dailyName) {
//		this.dailyName = dailyName;
//	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCommandType() {
		return commandType;
	}

	public void setCommandType(int commandType) {
		this.commandType = commandType;
	}

	public int getTimingType() {
		return timingType;
	}

	public void setTimingType(int timingType) {
		this.timingType = timingType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCommandTiming() {
		return commandTiming;
	}

	public void setCommandTiming(String commandTiming) {
		this.commandTiming = commandTiming;
	}

	public int getCommandValue() {
		return commandValue;
	}

	public void setCommandValue(int commandValue) {
		this.commandValue = commandValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
