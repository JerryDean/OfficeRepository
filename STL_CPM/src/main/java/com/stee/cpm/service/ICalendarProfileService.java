package com.stee.cpm.service;

import com.stee.cpm.entity.Calendar2Draw;
import com.stee.cpm.entity.Config;
import com.stee.sel.common.ResultData;
import com.stee.sel.cpm.CalendarProfile;

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
 * File Name    : ISchedulingPlanService.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午3:34:19
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface ICalendarProfileService {
	CalendarProfile save(CalendarProfile cp);

	String deleteById(Integer id);

	CalendarProfile update(CalendarProfile cp);

	CalendarProfile findById(Integer id);

	ResultData<CalendarProfile> getAll();

	boolean searchByName(String name);

	Calendar2Draw getCalendar2Draw(Config config);

	void commission(CalendarProfile cp);
}
