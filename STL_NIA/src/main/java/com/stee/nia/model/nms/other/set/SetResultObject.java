package com.stee.nia.model.nms.other.set;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

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
 * File Name    : ResultObject.java
 * Author       : Jerry
 * Created      : 2016年10月21日 上午10:58:06
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType
public class SetResultObject {
	private String clazz;

	private List<SetResponse> responses;

	@XmlAttribute(name = "class")
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	@XmlElementWrapper(name = "responses")
	@XmlElement(name = "response")
	public List<SetResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<SetResponse> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "ResultObject [clazz=" + clazz + ", responses=" + responses + "]";
	}

}
