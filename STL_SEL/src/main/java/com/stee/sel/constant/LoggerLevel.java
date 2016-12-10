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
 * File Name    : LoggerLevel.java
 * Author       : Jerry
 * Created      : 2016年11月1日 上午10:10:31
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum LoggerLevel {
	INFO("info"), DEBUG("debug"), ERROR("error"), TRACE("trace"), WARN("warn");

	private String level;

	private LoggerLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

}
