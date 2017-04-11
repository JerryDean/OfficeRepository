package com.stee.dto.schedule;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_NIA
 * File Name    : Device.java
 * Author       : Jerry
 * Created      : 2016年11月28日 上午11:19:22
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType
public class Device {
	private String id;
	private List<ParamTypeOne> params;

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElementWrapper(name = "params")
	@XmlElement(name = "param")
	public List<ParamTypeOne> getParams() {
		return params;
	}

	public void setParams(List<ParamTypeOne> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", params=" + params + "]";
	}

}
