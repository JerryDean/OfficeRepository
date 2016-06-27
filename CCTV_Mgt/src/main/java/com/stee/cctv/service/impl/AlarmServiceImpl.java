package com.stee.cctv.service.impl;

import java.util.List;

import com.stee.cctv.service.IAlarmService;
import com.stee.cctv.utils.Util;
import com.stee.cctv.ws.AWebServiceClient;
import com.stee.cctv.ws.ICallBack;
import com.stee.cctv.ws.client.Alarm;
import com.stee.cctv.ws.client.AlarmType;
import com.stee.cctv.ws.client.IAlarmWebServiceForFels;

/**
 * Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD All rights
 * reserved.
 *
 * This software is confidential and proprietary property of ST Electronics
 * Info-comm Systems PTE. LTD. The user shall not disclose the contents of this
 * software and shall only use it in accordance with the terms and conditions
 * stated in the contract or licence agreement with ST Electronics Info-comm
 * Systems PTE. LTD.
 *
 * @author Jerry
 * @version 1.0
 *
 */
public class AlarmServiceImpl extends AWebServiceClient implements IAlarmService {

	@Override
	public String updateFelsAlarm(final AlarmType type, final List<Alarm> alarmList) {
		final StringBuilder sb = new StringBuilder();
		super.getClient(Util.alarm_wsdl, new ICallBack() {
			@Override
			public void call(IAlarmWebServiceForFels port) {
				sb.append(port.updateFelsAlarm(type, alarmList));
			}
		});
		return sb.toString();
	}

}
