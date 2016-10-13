package com.stee.spm.entity;

import java.util.Date;
import java.util.List;

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
 * File Name    : Scheduler.java
 * Author       : Jerry
 * Created      : 2016年10月11日 上午11:38:06
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class Scheduler {
	private String id;
	private String name;
	private List<SchedulerCommand> commands;

	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SchedulerCommand> getCommands() {
		return commands;
	}

	public void setCommands(List<SchedulerCommand> commands) {
		this.commands = commands;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Scheduler [id=" + id + ", name=" + name + ", commands=" + commands + ", createTime=" + createTime + "]";
	}

}
