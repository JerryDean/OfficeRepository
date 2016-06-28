package com.stee.cctv.utils;

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
public class PacketUtil {
	public static int length = 0;

	public static StringBuilder stringBuilder = null;

	public static void append(String str) {
		stringBuilder.append(str);
	}

	public static void renew() {
		stringBuilder = new StringBuilder();
	}

	// public static StringBuilder getStringBuilder() {
	// if (null == stringBuilder) {
	// synchronized (PacketUtil.class) {
	// if (null == stringBuilder) {
	// stringBuilder = new StringBuilder();
	// }
	// }
	// }
	// return stringBuilder;
	// }
	//
	// public static int getLength() {
	// if (0 != length) {
	// return length;
	// }
	// return 0;
	// }
	//
	// public static void setLength(int length) {
	// PacketUtil.length = length;
	// }
	//
	// public static void setStringBuilder(StringBuilder stringBuilder) {
	// PacketUtil.stringBuilder = stringBuilder;
	// }

}
