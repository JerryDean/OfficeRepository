package com.stee.lim.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.lim.repository.LampInfoRepository;
import com.stee.lim.service.ILampInfoService;
import com.stee.sel.common.ResultData;
import com.stee.sel.constant.ResponseCode;
import com.stee.sel.lim.LampInfo;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_LIM
 * File Name    : LampInfoServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年10月15日 上午11:00:31
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("lampInfoServiceImpl")
public class LampInfoServiceImpl implements ILampInfoService {
	@Autowired
	LampInfoRepository repository;

	@Override
	public String update(LampInfo info) {
		try {
			repository.save(info);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public ResultData<LampInfo> getAll() {
		ResultData<LampInfo> data = new ResultData<>();
		try {
			data.setData(repository.findAll());
		} catch (Exception e) {
			data.setStatus(ResponseCode.FAILED.getCode());
		}
		data.setStatus(ResponseCode.SUCCESS.getCode());
		return data;
	}

	@Override
	public String deleteByGgz(String geoZoneId) {
		try {
			List<LampInfo> findByGeoZoneId = repository.findByGeoZoneId(geoZoneId);
			if (!findByGeoZoneId.isEmpty()) {
				findByGeoZoneId.forEach(lampInfo -> {
					lampInfo.setGeoZoneId(null);
					repository.save(lampInfo);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public String updateGz(Map<String, String> map) {
		try {
			map.forEach((k, v) -> {
				LampInfo findOne = repository.findOne(k);
				findOne.setGeoZoneId(v);
			});
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public void updatePolling(List<LampInfo> list) {
		if (list.isEmpty()) {
			try {
				repository.save(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<LampInfo> getByGeoZoneId(String geoZoneId) {
		return repository.findByGeoZoneId(geoZoneId);
	}

}
