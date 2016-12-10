package com.stee.sel.gzm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
 * Project Name : GZMMgt
 * File Name    : GZone.java
 * Author       : xiongxiaobo
 * Created      : 2016年10月11日 下午4:10:18
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */

@Entity
@Table(name = "stl_gzm_gzone")
public class GZone implements Serializable {
	@Id
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid")
	@Column(name = "gzone_id")
	private String gzoneId;
	@Column(name = "name")
	private String name;
	@Column(name = "gzone_area")
	private String gzoneArea;
	// @Column(name="dimming_group_id")
	//// @ManyToOne
	// private String dimmingGroupId;
	@Column(name = "other")
	private String other;

	public String getGzoneId() {
		return gzoneId;
	}

	public void setGzoneId(String gzoneId) {
		this.gzoneId = gzoneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGzoneArea() {
		return gzoneArea;
	}

	public void setGzoneArea(String gzoneArea) {
		this.gzoneArea = gzoneArea;
	}

	// public String getDimmingGroupId() {
	// return dimmingGroupId;
	// }
	// public void setDimmingGroupId(String dimmingGroupId) {
	// this.dimmingGroupId = dimmingGroupId;
	// }
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public GZone(String gzoneId, String name, String gzoneArea, String other) {
		this.gzoneId = gzoneId;
		this.name = name;
		this.gzoneArea = gzoneArea;
		this.other = other;
	}

	public GZone() {
	}

	@Override
	public String toString() {
		return "GZone [gzoneId=" + gzoneId + ", name=" + name + ", gzoneArea=" + gzoneArea + ", other=" + other + "]";
	}
}
