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
 * File Name    : OperationState.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午4:17:04
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum OperationState {

	INS("INS"), LampFailure("LampFailure"), NodeFailure("NodeFailure"), CommsFailure("CommsFailure"), Unknown(
			"Unknown");

	private String state;

	private OperationState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
