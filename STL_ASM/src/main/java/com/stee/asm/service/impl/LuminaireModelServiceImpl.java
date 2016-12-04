package com.stee.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.asm.repository.LuminaireModelRepository;
import com.stee.asm.service.ILuminaireModelService;
import com.stee.sel.asm.LuminaireModelConfig;
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
 * File Name    : LuminaireModelServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午1:47:25
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("luminaireModelServiceImpl")
public class LuminaireModelServiceImpl implements ILuminaireModelService {
	@Autowired
	LuminaireModelRepository repository;

	@Override
	public ResultData<LuminaireModelConfig> getAll() {
		ResultData<LuminaireModelConfig> resultData = new ResultData<>();
		try {
			List<LuminaireModelConfig> findAll = repository.findAll();
			resultData.setData(findAll);
			resultData.setStatus(ResponseCode.SUCCESS.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			resultData.setStatus(ResponseCode.FAILED.getCode());
		}
		return resultData;
	}

	@Override
	public String save(LuminaireModelConfig config) {
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
	public boolean isIdExits(Integer id) {
		return repository.exists(id);
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

}
