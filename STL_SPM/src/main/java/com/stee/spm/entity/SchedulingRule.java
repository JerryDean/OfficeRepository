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
 * File Name    : SchedulingRule.java
 * Author       : Jerry
 * Created      : 2016年10月11日 上午11:38:06
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class SchedulingRule {
	private String id;

	private String desc;

	private Date startDate;

	private Date endDate;

	private Scheduler scheduler;

	private String recurrentPattern;

	private Integer priority;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public String getRecurrentPattern() {
		return recurrentPattern;
	}

	public void setRecurrentPattern(String recurrentPattern) {
		this.recurrentPattern = recurrentPattern;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "SchedulingRule [id=" + id + ", desc=" + desc + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", scheduler=" + scheduler + ", recurrentPattern=" + recurrentPattern + ", priority=" + priority
				+ "]";
	}

}
