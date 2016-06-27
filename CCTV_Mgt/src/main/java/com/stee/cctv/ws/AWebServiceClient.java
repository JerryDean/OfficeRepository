package com.stee.cctv.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.stee.cctv.ws.client.AlarmMgtWebServiceForFels;

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
public abstract class AWebServiceClient {
	private static final QName SERVICE_NAME = new QName("http://impl.ws.alarm.stee.com/", "AlarmMgtWebServiceForFels");

	public void getClient(String uri, ICallBack callBack) {
		if (null == uri || uri.equals("")) {
			return;
		}
		try {
			URL url = new URL(uri);
			AlarmMgtWebServiceForFels alarmForFels = new AlarmMgtWebServiceForFels(url, SERVICE_NAME);
			callBack.call(alarmForFels.getAlarmWebServiceForFelsImplPort());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
