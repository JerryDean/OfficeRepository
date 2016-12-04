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
 * File Name    : Calendar.java
 * Author       : Jerry
 * Created      : 2016年10月25日 下午5:07:00
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class CalendarProfile2Draw {
	private List<DailyProfiles2Draw> monthProfile;

	public List<DailyProfiles2Draw> getMonthProfile() {
		return monthProfile;
	}

	public void setMonthProfile(List<DailyProfiles2Draw> monthProfile) {
		this.monthProfile = monthProfile;
	}

	@Override
	public String toString() {
		return "CalendarProfile2Draw [monthProfile=" + monthProfile + "]";
	}

}
