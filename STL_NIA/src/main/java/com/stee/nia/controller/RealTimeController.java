package com.stee.nia.controller;

import com.stee.nia.service.IRealTimeService;
import com.stee.sel.lcm.ConfigCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
 * File Name    : WebController.java
 * Author       : Jerry
 * Created      : 2016年10月18日 上午9:44:09
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/realtime")
public class RealTimeController {
	@Resource(name = "realTimeServiceImpl")
	IRealTimeService realTimeService;

	/**
	 * Lamp Point 控制。
	 * 
	 * @param cc
	 * @return
	 * @throws Throwable
	 * @author Jerry
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(@RequestBody ConfigCommand cc) throws Throwable {
		return realTimeService.send(cc);
	}

}
