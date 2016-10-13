package com.stee.spm.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stee.spm.entity.ResultData;
import com.stee.spm.entity.SchedulingPlan;
import com.stee.spm.service.ISchedulingPlanService;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : Street Lighting
 * File Name    : SchedulingPlanController.java
 * Author       : Jerry
 * Created      : 2016年10月11日 上午11:55:34
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/schedulingplan")
public class SchedulingPlanController {
	@Resource(name = "schedulingPlanServiceImpl")
	ISchedulingPlanService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public SchedulingPlan save(@RequestBody SchedulingPlan plan) {
		return service.save(plan);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable("id") String id) {
		return service.deleteById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public SchedulingPlan update(@RequestBody SchedulingPlan plan) {
		return service.update(plan);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public SchedulingPlan findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResultData<SchedulingPlan> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/searchByName", method = RequestMethod.GET)
	public boolean searchByName(@RequestParam(value = "name", required = true) String name) {
		if (null != name && !name.equals("")) {
			return service.searchByName(name);
		}
		return false;
	}
}
