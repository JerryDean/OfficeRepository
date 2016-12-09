package com.stee.stl.lfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stee.sel.lfm.BurningHourAlert;
import com.stee.sel.lfm.ElectricAlertInfo;
import com.stee.sel.lfm.UsageAlertInfo;
import com.stee.stl.lfm.service.IDataReceiveService;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_LFM
 * File Name    : DataReceiveController.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午4:25:21
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/failure/logging")
public class DataReceiveController {
	@Autowired
	IDataReceiveService service;

	@RequestMapping(value = "/energy/alert", method = RequestMethod.POST)
	String receiveEnergyEvent(@RequestBody List<UsageAlertInfo> data) {
		System.out.println(data);
		return service.saveEnergyAlert(data);
	}

	@RequestMapping(value = "/electricity/alert", method = RequestMethod.POST)
	String receiveElectricity(@RequestBody List<ElectricAlertInfo> data) {
		System.out.println(data);
		return service.saveElectricityAlert(data);
	}

	@RequestMapping(value = "/burninghour/alert", method = RequestMethod.POST)
	String receiveBurningHour(@RequestBody List<BurningHourAlert> data) {
		System.out.println(data);
		return service.saveBurningHourAlert(data);
	}
}
