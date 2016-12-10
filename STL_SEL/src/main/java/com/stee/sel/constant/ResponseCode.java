package com.stee.sel.constant;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_SEL
 * File Name    : ResponseCode.java
 * Author       : Jerry
 * Created      : 2016年10月12日 下午4:15:47
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum ResponseCode {
	SUCCESS("000000"), FAILED("999999"), NO_SUCH_OBJECT("900102"), ERROR_PARAM("900101"), SERVER_ERROR("900008");

	private String code;

	private ResponseCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
