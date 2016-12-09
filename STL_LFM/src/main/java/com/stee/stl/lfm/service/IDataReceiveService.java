package com.stee.stl.lfm.service;

import java.util.List;

import com.stee.sel.lfm.BurningHourAlert;
import com.stee.sel.lfm.ElectricAlertInfo;
import com.stee.sel.lfm.UsageAlertInfo;

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
 * File Name    : IDataReceiveService.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午4:34:45
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface IDataReceiveService {

	String saveEnergyAlert(List<UsageAlertInfo> data);

	String saveElectricityAlert(List<ElectricAlertInfo> data);

	String saveBurningHourAlert(List<BurningHourAlert> data);

}
