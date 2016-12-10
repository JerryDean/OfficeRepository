package com.stee.sel.lim.configruation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
 * File Name    : LampRole.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午1:29:54
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LIM_LAMP_POLE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LampPole {

	/**
	 * Unique Code
	 */
	private Integer id;

	/**
	 * Lamp Pole ID
	 */
	private String poleId;

	/**
	 * Lamp Pole Model ID
	 */
	private String moduleId;

	public LampPole() {
		super();
	}

	@JsonCreator(mode = Mode.PROPERTIES)
	public LampPole(@JsonProperty("poleId") String poleId, @JsonProperty("moduleId") String moduleId) {
		super();
		this.poleId = poleId;
		this.moduleId = moduleId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pole_id")
	public String getPoleId() {
		return poleId;
	}

	public void setPoleId(String poleId) {
		this.poleId = poleId;
	}

	@Column(name = "module_id")
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@Override
	public String toString() {
		return "LampPole [id=" + id + ", poleId=" + poleId + ", moduleId=" + moduleId + "]";
	}

}
