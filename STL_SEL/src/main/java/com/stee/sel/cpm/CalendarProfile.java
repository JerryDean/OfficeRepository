package com.stee.sel.cpm;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
 * File Name    : SchedulingPlan.java
 * Author       : Jerry
 * Created      : 2016年10月12日 下午4:16:50
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_CPM_CALENDAR_PROFILE")
public class CalendarProfile {

	private Integer id;

	private String name;

	private String status;

	private Integer statusCode;

	private String dimmingGroupId;

	private List<SchedulingRule> rules;

	private Date createDate;

	private Date commisionedDate;

	private Date updateTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id")
	public List<SchedulingRule> getRules() {
		return rules;
	}

	@Column(name = "DMG_NAME")
	public String getDimmingGroupId() {
		return dimmingGroupId;
	}

	public void setDimmingGroupId(String dimmingGroupId) {
		this.dimmingGroupId = dimmingGroupId;
	}

	public void setRules(List<SchedulingRule> rules) {
		this.rules = rules;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "COMMISIONED_DATE")
	@Temporal(TemporalType.DATE)
	public Date getCommisionedDate() {
		return commisionedDate;
	}

	public void setCommisionedDate(Date commisionedDate) {
		this.commisionedDate = commisionedDate;
	}

	@Column(name = "status_code")
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Column(name = "update_time")
	@Temporal(TemporalType.DATE)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "CalendarProfile [id=" + id + ", name=" + name + ", status=" + status + ", statusCode=" + statusCode
				+ ", dimmingGroupId=" + dimmingGroupId + ", rules=" + rules + ", createDate=" + createDate
				+ ", commisionedDate=" + commisionedDate + ", updateTime=" + updateTime + "]";
	}

}
