package com.stee.nia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stee.nia.service.IScheduledService;
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
 * Project Name : STL_NIA
 * File Name    : ScheduledConfigController.java
 * Author       : Jerry
 * Created      : 2016年10月18日 上午9:49:27
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/scheduled")
public class ScheduledConfigController {
	@Autowired
	IScheduledService service;

	/**
	 * Commission Calendar Profile
	 * 
	 * @param cp
	 * @author Jerry
	 */
	@RequestMapping(value = "/commission", method = RequestMethod.POST)
	public void commission(CalendarProfile cp) {
		service.commission(cp);
	}
}
