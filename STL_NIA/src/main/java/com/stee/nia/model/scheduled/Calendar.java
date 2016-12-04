package com.stee.nia.model.scheduled;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
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
 * File Name    : Calendar.java
 * Author       : Jerry
 * Created      : 2016年11月28日 下午3:45:57
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType
public class Calendar {
	private String id;
	private List<Rule> rule;

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Rule> getRule() {
		return rule;
	}

	public void setRule(List<Rule> rule) {
		this.rule = rule;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", rule=" + rule + "]";
	}

}
