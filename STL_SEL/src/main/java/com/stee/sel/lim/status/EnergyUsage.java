package com.stee.sel.lim.status;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
 * File Name    : EnergyUsage.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午4:21:57
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_LIM_ENERGY_USAGE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EnergyUsage {

	/**
	 * Unique Code
	 */
	private Integer id;

	/**
	 * Latest accumulated energy usage
	 */
	private Double usage;

	/**
	 * associated date/time
	 */
	private Date associatedTime;

	public EnergyUsage() {
		super();
	}

	@JsonCreator(mode = Mode.PROPERTIES)
	public EnergyUsage(@JsonProperty("usage") Double usage, @JsonProperty("associatedTime") Date associatedTime) {
		super();
		this.usage = usage;
		this.associatedTime = associatedTime;
	}

	@Column(name = "energy_usage")
	public Double getUsage() {
		return usage;
	}

	public void setUsage(Double usage) {
		this.usage = usage;
	}

	@Temporal(TemporalType.DATE)
	public Date getAssociatedTime() {
		return associatedTime;
	}

	public void setAssociatedTime(Date associatedTime) {
		this.associatedTime = associatedTime;
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
		return "EnergyUsage [id=" + id + ", usage=" + usage + ", associatedTime=" + associatedTime + "]";
	}

}
