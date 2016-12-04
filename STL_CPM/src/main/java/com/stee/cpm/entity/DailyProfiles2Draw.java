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
 * File Name    : DailyProfile.java
 * Author       : Jerry
 * Created      : 2016年10月25日 下午5:07:53
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class DailyProfiles2Draw {
	private List<DailyProfile2Draw> dailyProfile;

	public List<DailyProfile2Draw> getDailyProfile() {
		return dailyProfile;
	}

	public void setDailyProfile(List<DailyProfile2Draw> dailyProfile) {
		this.dailyProfile = dailyProfile;
	}

	@Override
	public String toString() {
		return "DailyProfiles [dailyProfile=" + dailyProfile + "]";
	}

}
