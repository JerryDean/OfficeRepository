package com.stee.spm.entity;

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
 * Project Name : Street Lighting
 * File Name    : SchedulerCommand.java
 * Author       : Jerry
 * Created      : 2016年10月11日 上午11:48:01
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class SchedulerCommand {
	private String commandName;

	private Integer commandType;

	private Integer relativeTimingType;

	private Integer timingType;

	private Date commandTiming;

	private Integer commandValue;

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public Integer getCommandType() {
		return commandType;
	}

	public void setCommandType(Integer commandType) {
		this.commandType = commandType;
	}

	public Integer getRelativeTimingType() {
		return relativeTimingType;
	}

	public void setRelativeTimingType(Integer relativeTimingType) {
		this.relativeTimingType = relativeTimingType;
	}

	public Integer getTimingType() {
		return timingType;
	}

	public void setTimingType(Integer timingType) {
		this.timingType = timingType;
	}

	public Date getCommandTiming() {
		return commandTiming;
	}

	public void setCommandTiming(Date commandTiming) {
		this.commandTiming = commandTiming;
	}

	public Integer getCommandValue() {
		return commandValue;
	}

	public void setCommandValue(Integer commandValue) {
		this.commandValue = commandValue;
	}

	@Override
	public String toString() {
		return "SchedulerCommand [commandName=" + commandName + ", commandType=" + commandType + ", relativeTimingType="
				+ relativeTimingType + ", timingType=" + timingType + ", commandTiming=" + commandTiming
				+ ", commandValue=" + commandValue + "]";
	}

}
