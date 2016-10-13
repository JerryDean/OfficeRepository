package com.stee.spm.service;

import com.stee.spm.entity.ResultData;
import com.stee.spm.entity.SchedulingPlan;

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
 * File Name    : ISchedulingPlanService.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午3:34:19
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface ISchedulingPlanService {
	SchedulingPlan save(SchedulingPlan plan);

	String deleteById(String id);

	SchedulingPlan update(SchedulingPlan plan);

	SchedulingPlan findById(String id);

	ResultData<SchedulingPlan> getAll();

	boolean searchByName(String name);
}
