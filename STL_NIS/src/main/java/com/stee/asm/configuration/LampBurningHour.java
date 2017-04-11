 package com.stee.asm.configuration;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_ASM
 * File Name    : LampBurningHour.java
 * Author       : Jerry
 * Created      : 2016年12月7日 下午2:23:13
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class LampBurningHour {
	private String id;
	private Integer burningHour;
	private boolean isLampOn;
	private Integer lifetime;

	public LampBurningHour() {
		super();
	}

	public LampBurningHour(String id, Integer burningHour, boolean isLampOn,Integer lifetime) {
		super();
		this.id = id;
		this.burningHour = burningHour;
		this.isLampOn = isLampOn;
		this.lifetime=lifetime;
	}

	
	public Integer getLifetime() {
		return lifetime;
	}

	public void setLifetime(Integer lifetime) {
		this.lifetime = lifetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getBurningHour() {
		return burningHour;
	}

	public void setBurningHour(Integer burningHour) {
		this.burningHour = burningHour;
	}

	public boolean isLampOn() {
		return isLampOn;
	}

	public void setLampOn(boolean isLampOn) {
		this.isLampOn = isLampOn;
	}

}
