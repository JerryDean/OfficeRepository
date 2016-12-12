package com.stee.stl.lfm.service.impl;

import com.stee.sel.lfm.EventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.stee.sel.lfm.FailureEvent;
import com.stee.stl.lfm.repository.FailureEventRepository;
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
 * File Name    : FailureEventServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年12月9日 下午3:04:30
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class FailureEventServiceImpl implements IFailureEventService {
	@Autowired
	FailureEventRepository repository;

	@Override
	public Page<FailureEvent> findByEventSource(String es, Integer pageNo, Integer pageSize, String direction) {
		Page<FailureEvent> page = null;
		if (direction == null) {
			direction = "DESC";
		}
		PageRequest pageRequest = new PageRequest(pageNo, pageSize,
				new Sort(direction.equals("DESC") ? Direction.DESC : Direction.ASC, "severityLevel"));
		if (!es.equals("none")) {
			page = repository.findByEventSource(EventSource.valueOf(es), pageRequest);
		} else {
			page = repository.findAll(pageRequest);
		}
		return page;
	}

}
