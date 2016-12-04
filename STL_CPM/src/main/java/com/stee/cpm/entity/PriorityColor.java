package com.stee.cpm.entity;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_CPM
 * File Name    : PriorityColor.java
 * Author       : Jerry
 * Created      : 2016年11月2日 下午5:11:52
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum PriorityColor {
	P1("rgba(125,125,125,1)"), P2("rgba(125,125,125,1)"), P3("rgba(125,125,125,1)"), P4("rgba(125,125,125,1)"), P5(
			"rgba(0,255,0,1)"), P6("rgba(0,0,255,1)"), P7("rgba(255,0,0,1)");

	private String level;

	public String getLevel() {
		return level;
	}

	private PriorityColor(String level) {
		this.level = level;
	}

}
