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
	P1("#f8cb00"), P2("#bbbbb6"), P3("#f3565d"), P4("#1bbc9b"), P5(
			"#9b59b6"), P6("#1ffff1"), P7("#1bbc9b"), P8("#34352C"), P9("#B8F788");

	private String level;

	public String getLevel() {
		return level;
	}

	private PriorityColor(String level) {
		this.level = level;
	}

}
