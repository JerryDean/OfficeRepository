package com.stee.dto.schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

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
 * File Name    : Configuration.java
 * Author       : Jerry
 * Created      : 2016年11月25日 下午5:26:05
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlRootElement
@XmlType(propOrder = { "devices", "schedulers" })
public class Configuration {
	private List<Device> devices;

	private List<Schedulers> schedulers;

	@XmlElementWrapper(name = "devices")
	@XmlElement(name = "device")
	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<Schedulers> getSchedulers() {
		return schedulers;
	}

	public void setSchedulers(List<Schedulers> schedulers) {
		this.schedulers = schedulers;
	}

	@Override
	public String toString() {
		return "Configuration [devices=" + devices + ", schedulers=" + schedulers + "]";
	}

}
