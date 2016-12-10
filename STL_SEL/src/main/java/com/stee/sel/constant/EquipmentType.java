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
 * File Name    : EquipmentType.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午2:12:20
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public enum EquipmentType {
	DEFAULT("");

	private String type;

	private EquipmentType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
