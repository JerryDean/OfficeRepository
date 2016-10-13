package com.stee.spm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

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
 * File Name    : SchedulingPlan.java
 * Author       : Jerry
 * Created      : 2016年10月11日 上午11:38:06
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_SPM_SCHEDULING_PLAN")
@DynamicUpdate
public class SchedulingPlan {

	private String id;

	private String name;

	private String status;

	private String dimmingGroupId;

	private List<SchedulingRule> rules;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "DMG_ID")
	public String getDimmingGroupId() {
		return dimmingGroupId;
	}

	public void setDimmingGroupId(String dimmingGroupId) {
		this.dimmingGroupId = dimmingGroupId;
	}

	@Transient
	public List<SchedulingRule> getRules() {
		return rules;
	}

	public void setRules(List<SchedulingRule> rules) {
		this.rules = rules;
	}

	@Override
	public String toString() {
		return "SchedulingPlan [id=" + id + ", name=" + name + ", status=" + status + ", dimmingGroupId="
				+ dimmingGroupId + ", rules=" + rules + "]";
	}

}
