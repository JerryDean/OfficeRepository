package com.stee.lim.service;

import com.stee.lim.dto.LampInfoDetail;
import com.stee.sel.common.ResultData;
import com.stee.sel.lim.LampInfo;
import org.springframework.data.domain.Page;

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
 * Project Name : STL_LIM
 * File Name    : ILampInfoService.java
 * Author       : Jerry
 * Created      : 2016年10月15日 上午10:59:41
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface ILampInfoService {
	LampInfo update(LampInfo info);

	void delete(String id);

	ResultData<LampInfo> getAll();

	String deleteByGgz(String geoZoneId);

	String updateGz(Map<String, String> map);

	void updatePolling(List<LampInfo> list);

	List<LampInfo> getByGeoZoneId(String geoZoneId);

	Page<LampInfo> getAllByFilter(Integer pageNo, Integer pageSize, String name, String addr, String gzId);

	boolean isIdExits(String id);

    LampInfoDetail findLampDetailInfo(String id);
}
