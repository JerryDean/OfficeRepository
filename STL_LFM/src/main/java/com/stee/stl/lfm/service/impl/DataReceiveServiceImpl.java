package com.stee.stl.lfm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.sel.constant.ResponseCode;
import com.stee.sel.lfm.BurningHourAlert;
import com.stee.sel.lfm.ElectricAlertInfo;
import com.stee.sel.lfm.EventSource;
import com.stee.sel.lfm.FailureEvent;
import com.stee.sel.lfm.UsageAlertInfo;
import com.stee.stl.lfm.repository.BurningHourAlertRepository;
import com.stee.stl.lfm.repository.ElectricityAlertRepository;
import com.stee.stl.lfm.repository.EnergyUsageAlertRepository;
import com.stee.stl.lfm.repository.FailureEventRepository;
import com.stee.stl.lfm.service.IDataReceiveService;

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
 * File Name    : DataReceiveServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午4:35:08
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class DataReceiveServiceImpl implements IDataReceiveService {
	@Autowired
	BurningHourAlertRepository bhRepo;

	@Autowired
	ElectricityAlertRepository etcRepo;

	@Autowired
	EnergyUsageAlertRepository engRepo;

	@Autowired
	FailureEventRepository feRepo;

	@Override
	public String saveEnergyAlert(List<UsageAlertInfo> data) {
		if (null != data && !data.isEmpty()) {
			data.forEach(info -> {
				FailureEvent failureEvent = new FailureEvent();
				failureEvent.setOccurDate(new Date());
				failureEvent.setEventSource(EventSource.Application);
				failureEvent.setMessage(info.getAlertMsg());
				failureEvent.setObjectId(info.getModelId());
				failureEvent.setSeverityLevel(info.getSeverityLevel());
				feRepo.save(failureEvent);
			});
			try {
				engRepo.save(data);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseCode.FAILED.getCode();
			}
		} else {
			return ResponseCode.ERROR_PARAM.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public String saveElectricityAlert(List<ElectricAlertInfo> data) {
		if (null != data && !data.isEmpty()) {
			data.forEach(info -> {
				FailureEvent failureEvent = new FailureEvent();
				failureEvent.setOccurDate(new Date());
				failureEvent.setEventSource(EventSource.Application);
				failureEvent.setMessage(info.getAlertMsg());
				failureEvent.setObjectId(info.getLuminaireId());
				failureEvent.setSeverityLevel(info.getSeverityLevel());
				feRepo.save(failureEvent);
			});
			try {
				etcRepo.save(data);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseCode.FAILED.getCode();
			}
		} else {
			return ResponseCode.ERROR_PARAM.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public String saveBurningHourAlert(List<BurningHourAlert> data) {
		if (null != data && !data.isEmpty()) {
			data.forEach(info -> {
				FailureEvent failureEvent = new FailureEvent();
				failureEvent.setOccurDate(new Date());
				failureEvent.setEventSource(EventSource.Application);
				failureEvent.setMessage(info.getAlertMsg());
				failureEvent.setObjectId(info.getLuminaireId());
				failureEvent.setSeverityLevel(info.getSeverityLevel());
				feRepo.save(failureEvent);
			});
			try {
				bhRepo.save(data);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseCode.FAILED.getCode();
			}
		} else {
			return ResponseCode.ERROR_PARAM.getCode();
		}
		return ResponseCode.SUCCESS.getCode();
	}

}
