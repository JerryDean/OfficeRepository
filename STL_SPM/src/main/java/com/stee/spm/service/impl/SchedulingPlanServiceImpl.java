package com.stee.spm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stee.spm.constant.ResponseCode;
import com.stee.spm.entity.ResultData;
import com.stee.spm.entity.SchedulingPlan;
import com.stee.spm.repository.SchedulingPlanRepository;
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
 * File Name    : SchedulingPlanServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午3:38:03
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("schedulingPlanServiceImpl")
public class SchedulingPlanServiceImpl implements ISchedulingPlanService {
	@Autowired
	SchedulingPlanRepository repository;

	@Override
	@Transactional
	public SchedulingPlan save(SchedulingPlan plan) {
		return repository.save(plan);
	}

	@Override
	public String deleteById(String id) {
		repository.delete(id);
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	@Transactional
	public SchedulingPlan update(SchedulingPlan plan) {
		return repository.saveAndFlush(plan);
	}

	@Override
	public SchedulingPlan findById(String id) {
		return repository.findById(id);
	}

	@Override
	public ResultData<SchedulingPlan> getAll() {
		ResultData<SchedulingPlan> resultData = new ResultData<>();
		List<SchedulingPlan> list = repository.findAll();
		resultData.setData(list);
		return resultData;
	}

	@Override
	public boolean searchByName(String name) {
		return repository.findByName(name) == null ? false : true;
	}

}
