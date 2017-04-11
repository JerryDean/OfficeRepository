package com.stee.dto.schedule;

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
 * File Name    : Rule.java
 * Author       : Jerry
 * Created      : 2016年11月28日 下午3:46:23
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType(propOrder = { "controlProgram", "priority", "start", "end" })
public class Rule {
	private String profile;
	private String controlProgram;
	private String priority;
	private String start;
	private String end;

	@XmlAttribute
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getControlProgram() {
		return controlProgram;
	}

	public void setControlProgram(String controlProgram) {
		this.controlProgram = controlProgram;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Rule [profile=" + profile + ", controlProgram=" + controlProgram + ", priority=" + priority + ", start="
				+ start + ", end=" + end + "]";
	}

}
