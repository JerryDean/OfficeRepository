package com.stee.asm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stee.asm.service.INorthboundInterfaceConfigService;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_ASM
 * File Name    : NorthboundInterfaceConfigController.java
 * Author       : Jerry
 * Created      : 2016年11月16日 下午5:42:19
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/northbound/interface/config")
public class NorthboundInterfaceConfigController {
	@Autowired
	INorthboundInterfaceConfigService service;

	/**
	 * 配置CMS-NMS 连接配置。
	 * 
	 * @param json
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public Map<String, String> doConfig(@RequestBody String json) {
		Map<String, String> map = new HashMap<>();
		map.put("status", service.doConfig(json));
		return map;
	}

	/**
	 * 获取CMS-NMS 配置信息。
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public Map<String, String> fetchConfig() {
		return service.fetchConfig();
	}

}
