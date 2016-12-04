package com.stee.nia.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.stee.nia.client.RealtimeConfigClient;
import com.stee.nia.model.realtime.Commands;
import com.stee.nia.model.realtime.Set;
import com.stee.nia.service.IRealTimeService;
import com.stee.sel.lcm.ConfigCommand;

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
 * File Name    : RealTimeServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年10月18日 下午3:13:25
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("realTimeServiceImpl")
public class RealTimeServiceImpl implements IRealTimeService {
	private static RealtimeConfigClient client = new RealtimeConfigClient();

	@Override
	public String send(ConfigCommand cc) throws Throwable {
		String id = cc.getDeviceId();
		Commands commands = new Commands();
		List<Set> list = Lists.newArrayList();
		if (null != cc.getControlMode()) {
			Set set = new Set();
			set.setId(id);
			set.setMeaning("LampCommandMode");
			set.setValue(cc.getControlMode() == 0 ? "MANUAL" : "AUTOMATIC");
			list.add(set);
		}
		if (null != cc.getLampLevel()) {
			Set set = new Set();
			set.setId(id);
			set.setMeaning("LampLevelCommand");
			set.setValue(String.valueOf(cc.getLampLevel()));
			list.add(set);
		}
		Set set = new Set();
		set.setId(id);
		set.setMeaning("LampCommandSwitch");
		set.setValue(cc.isLampSwitch() == false ? String.valueOf(0) : String.valueOf(100));
		list.add(set);
		commands.setSet(list);
		String response = "Can not connect to NMS...";
		response = client.sendRealTime(commands);
		return response;
	}
}
