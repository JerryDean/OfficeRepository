package com.stee.sel.asm;

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
 * File Name    : LifetimeTrackingConfig.java
 * Author       : Jerry
 * Created      : 2016年12月1日 上午9:57:48
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_ASM_LIFETIME")
public class LifetimeTrackingConfig {
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * Name for this configuration
	 */
	private String name;
	/**
	 * Estimated lifetime
	 */
	private Integer lifetime;
	/**
	 * Tracking entity
	 */
	private Integer trackingEntity;
	/**
	 * A list of threshold entity,contains: Threshold Lifetime Alert text
	 * message Severity level
	 */
	private List<ThresholdsOfLifetime> thresholds;

	private String luminaireId;

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

	public Integer getLifetime() {
		return lifetime;
	}

	public void setLifetime(Integer lifetime) {
		this.lifetime = lifetime;
	}

	@Column(name = "tracking_entity")
	public Integer getTrackingEntity() {
		return trackingEntity;
	}

	public void setTrackingEntity(Integer trackingEntity) {
		this.trackingEntity = trackingEntity;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "config_id")
	public List<ThresholdsOfLifetime> getThresholds() {
		return thresholds;
	}

	public void setThresholds(List<ThresholdsOfLifetime> thresholds) {
		this.thresholds = thresholds;
	}

	public String getLuminaireId() {
		return luminaireId;
	}

	public void setLuminaireId(String luminaireId) {
		this.luminaireId = luminaireId;
	}

	@Override
	public String toString() {
		return "LifetimeTrackingConfig [id=" + id + ", name=" + name + ", lifetime=" + lifetime + ", trackingEntity="
				+ trackingEntity + ", thresholds=" + thresholds + ", luminaireId=" + luminaireId + "]";
	}

}
