package com.stee.sel.gzm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * Project Name : GZMMgt
 * File Name    : GZoneAndLampsRelation.java
 * Author       : xiongxiaobo
 * Created      : 2016年10月11日 下午4:10:34
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STL_GZM_GZONEANDLAMPRELATION")
public class GZoneAndLampsRelation implements Serializable {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id") // 编号
	private String id;
	private String gzoneId;
	private String lampId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGzoneId() {
		return gzoneId;
	}

	public void setGzoneId(String gzoneId) {
		this.gzoneId = gzoneId;
	}

	public String getLampId() {
		return lampId;
	}

	public void setLampId(String lampId) {
		this.lampId = lampId;
	}

	public GZoneAndLampsRelation(String id, String gzoneId, String lampId) {
		this.id = id;
		this.gzoneId = gzoneId;
		this.lampId = lampId;
	}

	public GZoneAndLampsRelation() {
	}

	@Override
	public String toString() {
		return "GZoneAndLampsRelation [id=" + id + ", gzoneId=" + gzoneId + ", lampId=" + lampId + "]";
	}
}
