package com.stee.sel.ocm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * Project Name : STL_SEL
 * File Name    : CarboDioxide.java
 * Author       : xiongxiaobo
 * Created      : 2016年12月1日 下午3:21:44
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */

@Entity
@Table(name="stl_ocm_carbodioxide")
public class CarboDioxide implements Serializable{
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="area")
	private String area;
	@Column(name="k_value")
	private String kValue;
	@Column(name ="other")
	private String other;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getkValue() {
		return kValue;
	}
	public void setkValue(String kValue) {
		this.kValue = kValue;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public CarboDioxide(int id, String area, String kValue, String other) {
		this.id = id;
		this.area = area;
		this.kValue = kValue;
		this.other = other;
	}
	public CarboDioxide() {
	}
	@Override
	public String toString() {
		return "CarboDioxide [id=" + id + ", area=" + area + ", kValue="
				+ kValue + ", other=" + other + "]";
	}
}

