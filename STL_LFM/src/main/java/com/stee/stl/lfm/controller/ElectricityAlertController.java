package com.stee.stl.lfm.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stee.sel.lfm.AlertParam;
import com.stee.sel.lfm.ElectricAlertInfo;
import com.stee.stl.lfm.entity.QueryBean;
import com.stee.stl.lfm.service.IElectricityAlertService;

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
 * File Name    : ElectricParamsAlertController.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午2:24:42
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/eletricparams/alert")
public class ElectricityAlertController {
	@Autowired
	IElectricityAlertService service;

	@RequestMapping(value = "/pagingAndSort", method = RequestMethod.POST)
	Page<ElectricAlertInfo> getAlertPage(@RequestBody(required = false) QueryBean query,
			@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
			@RequestParam(name = "sort", defaultValue = "DESC") String direction) {
		return service.getAlertPage(query, pageNo, pageSize, direction);
	}

	@RequestMapping(value = "/fetch/enum", method = RequestMethod.GET)
	Set<String> getAlertParam() {
		Set<String> hashSet = new HashSet<String>();
		for (AlertParam param : AlertParam.values()) {
			hashSet.add(param.toString());
		}
		return hashSet;
	}

}
