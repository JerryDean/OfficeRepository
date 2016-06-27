package com.stee.cctv.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class TimeUtil {

	public static String getCurrentTimeStr() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
		String dateStr = sdf.format(date);
		String[] dateArray = dateStr.split("-");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dateArray.length; i++) {
			sb.append(dateArray[i]);
		}
		return sb.toString();
	}

	public static String getTimeByYMD() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		String[] dateArray = dateStr.split("-");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dateArray.length; i++) {
			sb.append(dateArray[i]);
		}
		return sb.toString();
	}
}
