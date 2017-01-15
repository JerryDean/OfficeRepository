package com.stee.lcm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stee.lcm.client.UpdateLampInfoClient;
import com.stee.sel.lcm.ConfigCommand;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_LCM
 * File Name    : LampAllocationController.java
 * Author       : Jerry
 * Created      : 2016年10月14日 下午3:35:23
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/lampcontrol")
public class LampAllocationController {

	// TODO Delete..
	@Deprecated
	@RequestMapping(value = "/get/template", method = RequestMethod.GET)
	public ConfigCommand getSetTemplate() {
		ConfigCommand template = new ConfigCommand();
		return template;
	}

	/**
	 * 控制Point Device Dimming.
	 * 
	 * @param cc
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/send/command", method = RequestMethod.POST)
	public ConfigCommand save(@RequestBody ConfigCommand cc) {
		UpdateLampInfoClient updateLampInfoClient = new UpdateLampInfoClient();
		try {
			// TODO Do save action...
			System.out.println(updateLampInfoClient.sendCommand(cc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
	}

}
