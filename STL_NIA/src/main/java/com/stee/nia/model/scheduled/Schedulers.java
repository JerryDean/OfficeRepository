package com.stee.nia.model.scheduled;

import java.util.List;

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
 * File Name    : Schedulers.java
 * Author       : Jerry
 * Created      : 2016年11月28日 下午1:52:10
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType(propOrder = { "controlPrograms", "calendars" })
public class Schedulers {
	private List<ControlProgram> controlPrograms;
	private List<Calendar> calendars;

	@XmlElementWrapper(name = "controlPrograms")
	@XmlElement(name = "controlProgram")
	public List<ControlProgram> getControlPrograms() {
		return controlPrograms;
	}

	public void setControlPrograms(List<ControlProgram> controlPrograms) {
		this.controlPrograms = controlPrograms;
	}

	@XmlElementWrapper(name = "calendars")
	@XmlElement(name = "calendar")
	public List<Calendar> getCalendars() {
		return calendars;
	}

	public void setCalendars(List<Calendar> calendars) {
		this.calendars = calendars;
	}

	@Override
	public String toString() {
		return "Schedulers [controlPrograms=" + controlPrograms + ", calendars=" + calendars + "]";
	}

}
