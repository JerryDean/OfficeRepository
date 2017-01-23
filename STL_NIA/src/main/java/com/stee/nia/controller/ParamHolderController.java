package com.stee.nia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stee.nia.service.IParamHolderService;
import com.stee.nia.service.impl.RealTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
 * File Name    : ParamHolderController.java
 * Author       : Jerry
 * Created      : 2016年11月16日 下午5:38:10
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/northbound/interface/config")
public class ParamHolderController {
	@Autowired
	IParamHolderService service;

	/**
	 * 修改配置。(CMS-NMS 连接配置)
	 * 
	 * @param map
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public String changeParam(@RequestBody Map<String, String> map) {
		return service.changeParam(map);
	}

	/**
	 * 获取配置。 (CMS-NMS 连接配置)
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public Map<String, String> fetchConfig() {
		return RealTimeServiceImpl.map;
	}

	public static void main(String[] args) throws JsonProcessingException {
		Map<String, String> map = new HashMap<>();
		map.put("nms.auth.id", "root1");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
    }
}
