package com.stee.asm.service.impl;

import com.stee.asm.repository.LifetimeTrackingRepository;
import com.stee.asm.repository.LuminaireModelRepository;
import com.stee.asm.service.ILuminaireModelService;
import com.stee.sel.asm.LifetimeTrackingConfig;
import com.stee.sel.asm.LuminaireModelConfig;
import com.stee.sel.common.ResultData;
import com.stee.sel.constant.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	LifetimeTrackingRepository lifetimeRepo;

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
			LuminaireModelConfig findOne = repository.findOne(id);
			String modelId = findOne.getModelId();
			if (null != modelId && !modelId.equals("")) {
                LifetimeTrackingConfig config = lifetimeRepo.findByLuminaireId(modelId);
                lifetimeRepo.delete(config.getId());
			}
			repository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public ResultData<LuminaireModelConfig> findByModelIdLike(String modelId) {
		ResultData<LuminaireModelConfig> resultData = new ResultData<>();
		if (null == modelId || modelId.equals("")) {
			resultData.setStatus(ResponseCode.ERROR_PARAM.getCode());
			return resultData;
		}
		try {
			List<LuminaireModelConfig> findByModelIdLike = repository.findByModelIdLike(modelId);
			resultData.setStatus(ResponseCode.SUCCESS.getCode());
			resultData.setData(findByModelIdLike);
		} catch (Exception e) {
			e.printStackTrace();
			resultData.setStatus(ResponseCode.FAILED.getCode());
		}

		return resultData;
	}

}
