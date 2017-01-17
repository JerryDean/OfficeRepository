package com.stee.stl.lfm.controller;

import com.google.common.collect.Lists;
import com.stee.sel.lfm.EventSource;
import com.stee.sel.lfm.EventTypeEnum;
import com.stee.sel.lfm.FailureEvent;
import com.stee.stl.lfm.entity.FailureEventQueryBean;
import com.stee.stl.lfm.service.IFailureEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

	@Deprecated
	@RequestMapping(value = "/findByEventSource", method = RequestMethod.GET)
	Page<FailureEvent> findByEventSource(@RequestParam(name = "eventSource", defaultValue = "none") String es,
			@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
			@RequestParam(name = "sort", defaultValue = "DESC") String direction) {
        System.out.printf(es);
        return service.findByEventSource(es, pageNo, pageSize, direction);
	}

	@RequestMapping(value = "/findby/querybean", method = RequestMethod.POST)
	Page<FailureEvent> findByQueryBean(@RequestParam(name = "pageNo",defaultValue = "0") Integer pageNo,
                                       @RequestParam(name = "pageSize",defaultValue = "15") Integer pageSize,
                                       @RequestParam(name = "sort", defaultValue = "DESC") String direction,
                                       @RequestParam(name = "sortBy", defaultValue = "severityLevel") String sortBy,
                                       @RequestBody FailureEventQueryBean queryBean) {
	    return service.findByQueryBean(pageNo, pageSize, direction, sortBy, queryBean);
    }

	@RequestMapping(value = "/fetch/enum", method = RequestMethod.GET)
	List<String> getEventSoureEnum() {
		List<String> list = Lists.newArrayList();
		for (EventSource es : EventSource.values()) {
			list.add(es.toString());
		}
		return list;
	}

	@RequestMapping(value = "/fetch/type", method = RequestMethod.GET)
	List<String> getEventTypeEnum() {
        List<String> list = Lists.newArrayList();
        for (EventTypeEnum eventTypeEnum : EventTypeEnum.values()) {
            list.add(eventTypeEnum.toString());
        }
        return list;
    }

}
