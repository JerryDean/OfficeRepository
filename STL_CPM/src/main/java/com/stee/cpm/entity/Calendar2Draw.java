package com.stee.cpm.entity;

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
 * Project Name : STL_CPM
 * File Name    : Calendar2Draw.java
 * Author       : Jerry
 * Created      : 2016年10月25日 下午4:59:40
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class Calendar2Draw {
	private List<CalendarProfile2Draw> calendarProfiles;

	public List<CalendarProfile2Draw> getCalendarProfiles() {
		return calendarProfiles;
	}

	public void setCalendarProfiles(List<CalendarProfile2Draw> calendarProfiles) {
		this.calendarProfiles = calendarProfiles;
	}

	@Override
	public String toString() {
		return "Calendar2Draw [calendarProfiles=" + calendarProfiles + "]";
	}

}
