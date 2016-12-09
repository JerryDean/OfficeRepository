package com.stee.stl.lfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.stee.sel.lfm.EventSource;
import com.stee.sel.lfm.FailureEvent;
import com.stee.stl.lfm.service.IFailureEventService;

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
 * File Name    : FailureEventController.java
 * Author       : Jerry
 * Created      : 2016年12月9日 下午2:44:49
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/failure/event")
public class FailureEventController {
	@Autowired
	IFailureEventService service;

	@RequestMapping(value = "/findByEventSource", method = RequestMethod.GET)
	Page<FailureEvent> findByEventSource(@RequestParam(name = "eventSource", defaultValue = "none") String es,
			@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
			@RequestParam(name = "sort", defaultValue = "DESC") String direction) {
		return service.findByEventSource(es, pageNo, pageSize, direction);
	}

	@RequestMapping(value = "/fetch/enum", method = RequestMethod.GET)
	List<String> getEventSoureEnum() {
		List<String> list = Lists.newArrayList();
		for (EventSource es : EventSource.values()) {
			list.add(es.toString());
		}
		return list;
	}
}
