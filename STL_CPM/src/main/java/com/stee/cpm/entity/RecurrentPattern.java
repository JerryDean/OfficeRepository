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
 * File Name    : RecurrentPattern.java
 * Author       : Jerry
 * Created      : 2016年11月3日 上午10:29:23
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum RecurrentPattern {
	DayBased("Day-based"), DateBasedDD("Date-based DD"), DateBasedDDMM("Date-based DD.MM"), DateBasedDDMMYYYY(
			"Date-based DD.MM.YYYY");

	String pattern;

	public String getPattern() {
		return pattern;
	}

	private RecurrentPattern(String pattern) {
		this.pattern = pattern;
	}

}
