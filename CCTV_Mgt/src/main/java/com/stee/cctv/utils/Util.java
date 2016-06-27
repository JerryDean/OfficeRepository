package com.stee.cctv.utils;

import org.apache.log4j.Logger;

import com.stee.dsms.properties.PropertyConfigurer;

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
public class Util {

	/**
	 * Socket 端口
	 */
	public static int port = Integer.parseInt(PropertyConfigurer.getContextProperty("port").toString());

	public static String ip = PropertyConfigurer.getContextProperty("ip").toString();

	public static final String USERNAME = PropertyConfigurer.getContextProperty("CCTV.username").toString();

	public static final String PASSWORD = PropertyConfigurer.getContextProperty("CCTV.password").toString();

	public static final Integer INTERVAL_HEARTBEAT = Integer
			.valueOf(PropertyConfigurer.getContextProperty("CCTV.heartbeat.interval").toString());

	public static final Integer INTERVAL_SNAP = Integer
			.valueOf(PropertyConfigurer.getContextProperty("CCTV.snap.interval").toString());

	public static final String TYPE_LOGIN = "1001";

	public static final String TYPE_HEARTBEAT = "1002";

	public static final String TYPE_DEVICE_STATE = "1003";

	public static final String TYPE_IMAGE = "1004";

	public static final String SUCCESS = "0";

	public static final String FAILED = "1";

	public static final String BAD_MESSAGE = "2";

	public static final String OK = "OK";

	public static final String FAUTY = "Faulty";

	public static final String ALARMCODE = "COM-2";

	/**
	 * 软件包版本
	 */
	public static String version = PropertyConfigurer.getContextProperty("version").toString();

	/**
	 * 厂商
	 */
	public static String from = PropertyConfigurer.getContextProperty("from").toString();

	/**
	 * 业务系统代码
	 */
	public static String system = PropertyConfigurer.getContextProperty("system").toString();

	public static String alarm_wsdl = PropertyConfigurer.getContextProperty("WSDL_ALARM_FORFELS").toString();

	public static String sessionId;

	public static final Logger logger = Logger.getLogger("CCS_CCTV_MGT");

	public static void setSessionId(String sessionId) {
		String[] str = sessionId.split("\\.");
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(s);
		}
		Util.sessionId = sb.toString();
	}

}
