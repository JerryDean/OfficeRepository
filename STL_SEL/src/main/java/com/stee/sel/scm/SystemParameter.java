package com.stee.sel.scm;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * File Name    : SystemParameter.java
 * Author       : xiongxiaobo
 * Created      : 2016年11月24日 下午3:54:18
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "stl_scm_systemparameter")
public class SystemParameter {
	@Id
	@Column(name="name")
	private String name;         //名字
	@Column(name="value")
	private String value;        //值
	@Column(name="description")
	private String description;  //描述
	@Column(name="unit")
	private String unit;         //单位
	@Column(name="prefervalue")
	private String prefervalue;  //变量默认值
	@Column(name="paramrange")
	private String paramrange;   //取值范围
	@Column(name="paramtype")
	private String paramtype;    //变量类型
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getPrefervalue() {
		return prefervalue;
	}
	public void setPrefervalue(String prefervalue) {
		this.prefervalue = prefervalue;
	}

	public SystemParameter() {
	}
	
	public String getParamrange() {
		return paramrange;
	}
	public void setParamrange(String paramrange) {
		this.paramrange = paramrange;
	}
	
	public String getParamtype() {
		return paramtype;
	}
	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}
	public SystemParameter(String name, String value, String description,
			String unit, String prefervalue, String paramrange, String paramtype) {
		this.name = name;
		this.value = value;
		this.description = description;
		this.unit = unit;
		this.prefervalue = prefervalue;
		this.paramrange = paramrange;
		this.paramtype = paramtype;
	}
	@Override
	public String toString() {
		return "SystemParameter [name=" + name + ", value=" + value
				+ ", description=" + description + ", unit=" + unit
				+ ", prefervalue=" + prefervalue + ", paramrange=" + paramrange
				+ ", paramtype=" + paramtype + "]";
	}

}
