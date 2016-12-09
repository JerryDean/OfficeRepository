package com.stee.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.stee.asm.repository.PoleModelRepository;
import com.stee.asm.service.IPoleModelService;
import com.stee.sel.asm.PoleModelConfig;
import com.stee.sel.common.ResultData;
import com.stee.sel.constant.ResponseCode;

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
 * File Name    : PoleModelServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午1:47:42
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("poleModelServiceImpl")
public class PoleModelServiceImpl implements IPoleModelService {
	@Autowired
	PoleModelRepository repository;

	@Override
	public ResultData<PoleModelConfig> getAll() {
		ResultData<PoleModelConfig> resultData = new ResultData<>();
		try {
			List<PoleModelConfig> findAll = repository.findAll();
			resultData.setData(findAll);
			resultData.setStatus(ResponseCode.SUCCESS.getCode());
		} catch (Exception e) {
			resultData.setStatus(ResponseCode.FAILED.getCode());
			e.printStackTrace();
		}
		return resultData;
	}

	@Override
	public String save(PoleModelConfig config) {
		if (null != config) {
			try {
				repository.save(config);
				return ResponseCode.SUCCESS.getCode();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseCode.FAILED.getCode();
			}
		} else {
			return ResponseCode.ERROR_PARAM.getCode();
		}
	}

	@Override
	public boolean isNameExits(String name) {
		PoleModelConfig poleModelConfig = new PoleModelConfig();
		poleModelConfig.setName(name);
		ExampleMatcher NAME_MATCHER = ExampleMatcher.matching().withMatcher("name",
				GenericPropertyMatchers.ignoreCase());
		Example<PoleModelConfig> example = Example.<PoleModelConfig>of(poleModelConfig, NAME_MATCHER);

		return repository.exists(example);
	}

	@Override
	public String delete(Integer id) {
		try {
			repository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public ResultData<PoleModelConfig> findByNameLike(String name) {
		ResultData<PoleModelConfig> resultData = new ResultData<>();
		if (null == name || name.equals("")) {
			resultData.setStatus(ResponseCode.ERROR_PARAM.getCode());
		}
		try {
			List<PoleModelConfig> findByNameLike = repository.findByNameLike(name);
			resultData.setStatus(ResponseCode.SUCCESS.getCode());
			resultData.setData(findByNameLike);
		} catch (Exception e) {
			e.printStackTrace();
			resultData.setStatus(ResponseCode.FAILED.getCode());
		}

		return resultData;
	}

}
