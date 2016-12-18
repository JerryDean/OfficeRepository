package com.stee.nia.service.impl;

import com.stee.nia.repository.ConnectionParamsRepository;
import com.stee.nia.service.IParamHolderService;
import com.stee.nia.utils.PropertiesUtils;
import com.stee.sel.constant.ResponseCode;
import com.stee.sel.nia.ConnectionParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
 * File Name    : ParamHolderServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年11月16日 下午10:23:35
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class ParamHolderServiceImpl implements IParamHolderService {

	@Autowired
	ConnectionParamsRepository repository;

	@Override
	public String changeParam(Map<String, String> map) {
		if (null == map || map.isEmpty()) {
			return ResponseCode.ERROR_PARAM.getCode();
		}
		try {
			map.forEach((k, v) -> {
				repository.update(k, v);
			});
			List<ConnectionParams> findAll = repository.findAll();
			RealTimeServiceImpl.map.clear();
			findAll.forEach(t -> {
				RealTimeServiceImpl.map.put(t.getKey(), t.getValue());
			});
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public Map<String, String> fetchConfig() {
		Map<String, String> readWhole = null;
		try {
			readWhole = PropertiesUtils.readWhole("nia-config.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readWhole;
	}

}
