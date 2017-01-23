package com.stee.nia.model.nms.auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 * File Name    : AuthMessage.java
 * Author       : Jerry
 * Created      : 2016年10月21日 下午2:24:56
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlRootElement(name = "NmsRESTResult")
@XmlType(propOrder = { "status", "message", "timeStamp", "authResult" })
public class AuthMessage {
	private String status;
	private String message;
	private String timeStamp;
	private AuthResult authResult;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@XmlElement(name = "resultObject")
	public AuthResult getAuthResult() {
		return authResult;
	}

	public void setAuthResult(AuthResult authResult) {
		this.authResult = authResult;
	}

	@Override
	public String toString() {
		return "AuthMessage [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + ", authResult="
				+ authResult + "]";
	}



}
