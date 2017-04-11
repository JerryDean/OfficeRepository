package com.stee.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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
 * File Name    : Commands.java
 * Author       : Jerry
 * Created      : 2016年10月19日 上午10:00:54
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlRootElement
public class Commands {
	private List<Set> set;

	private List<Get> get;

	public List<Set> getSet() {
		return set;
	}

	public void setSet(List<Set> set) {
		this.set = set;
	}

	public List<Get> getGet() {
		return get;
	}

	public void setGet(List<Get> get) {
		this.get = get;
	}

	@Override
	public String toString() {
		return "Commands [set=" + set + ", get=" + get + "]";
	}

}
