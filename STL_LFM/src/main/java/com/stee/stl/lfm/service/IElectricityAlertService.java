package com.stee.stl.lfm.service;

import org.springframework.data.domain.Page;

import com.stee.sel.lfm.ElectricAlertInfo;
import com.stee.stl.lfm.entity.QueryBean;

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
 * File Name    : IEletricParamsAlertService.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午2:25:26
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface IElectricityAlertService {

	Page<ElectricAlertInfo> getAlertPage(QueryBean query, Integer pageNo, Integer pageSize, String direction);

}