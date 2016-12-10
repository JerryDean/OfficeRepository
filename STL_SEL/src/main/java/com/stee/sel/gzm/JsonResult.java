package com.stee.sel.gzm;

import java.io.Serializable;

import com.stee.sel.constant.ResponseCode;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : GZMMgt
 * File Name    : JsonResult.java
 * Author       : xiongxiaobo
 * Created      : 2016年10月11日 下午4:10:47
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */

public class JsonResult implements Serializable {
	private String statusCode;
	private String message;
	private Object data;

	public static JsonResult ok() {
		JsonResult result = new JsonResult();
		result.setStatusCode(ResponseCode.SUCCESS.getCode());
		return result;
	}

	public static JsonResult ok(Object object) {
		JsonResult result = new JsonResult();
		result.setStatusCode(ResponseCode.SUCCESS.getCode());
		result.setData(object);
		return result;
	}

	public static JsonResult fail() {
		JsonResult result = new JsonResult();
		result.setStatusCode(ResponseCode.FAILED.getCode());
		return result;
	}

	public static JsonResult fail(String message) {
		JsonResult result = new JsonResult();
		result.setStatusCode(ResponseCode.FAILED.getCode());
		result.setMessage(message);
		return result;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonResult(String statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public JsonResult() {
	}

}
