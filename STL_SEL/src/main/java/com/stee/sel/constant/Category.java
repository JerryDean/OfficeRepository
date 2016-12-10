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
 * File Name    : Category.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午2:03:30
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum Category {
	STREET_LIGHT("Streetlight"), LAMP("Lamp"), LCU("Lcu");

	private String name;

	private Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
