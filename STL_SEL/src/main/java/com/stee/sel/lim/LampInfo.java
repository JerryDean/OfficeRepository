package com.stee.sel.lim;

import com.stee.sel.lim.configruation.LampPole;
import com.stee.sel.lim.configruation.Location;
import com.stee.sel.lim.control.LampControl;
import com.stee.sel.lim.status.LampStatus;

import javax.persistence.*;

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
 * File Name    : LampInfo.java
 * Author       : Jerry
 * Created      : 2016年10月13日 下午1:31:16
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
/**
 * <pre>
 * Lamp Information:
 *  a.	Device Name
 *	b.	Device ID (Must be Unique)
 *	c.	Luminaire Model ID
 *	d.	Geographic Data (Long/Lat)
 *	e.	GeoZone
 *	f.	Geographic Area
 *	g.	Address
 * </pre>
 */
@Entity
@Table(name = "STL_LIM_LAMP_INFO")
public class LampInfo {

	/**
	 * Device ID (Must be Unique)
	 */
	private String id;
	/**
	 * Device Name
	 */
	private String name;
	/**
	 * Luminaire Model ID
	 */
	private String moduleId;
	/**
	 * Geographic Data (Long/Lat)
	 */
	private Location location;
	/**
	 * GeoZone
	 */
	private String geoZoneId;
	/**
	 * Address
	 */
	private String address;

	/**
	 * <pre>
	 * Lamp Pole Info :
	 *  a.	Lamp Pole ID
	 *	b.	Lamp Pole Model ID
	 * </pre>
	 */
	private LampPole lampPole;

	/**
	 * <pre>
	 * Lamp Control Setting:
	 *  1.	Mode (Manual or Auto)
	 *	2.	Dimming Group
	 *	3.	Scheduling Plans
	 *	4.	Commissioned Scheduling Plan & commissioned date
	 *	5.	Currently effected Command (ON/OFF/Dim with Dimming setting)
	 * </pre>
	 */
	private LampControl lampControl;

	/**
	 * <pre>
	 * Lamp Status:
	 *  1.	Operation State (INS, OOS-LampFailure, OOS-NodeFailure, OOS-CommsFailure, Unknown
	 *	2.	Burning Hour (accumulated value)
	 *	3.	Latest accumulated energy usage & associated date/time
	 *	4.	Installation Date
	 *	5.	Lamp level feedback
	 *	6.	Lamp switch feeadback
	 *	7.	Current (mA)
	 *	8.	Voltage (V)
	 *	9.	Lamp Active Power (W)
	 *	10.	Lamp Reactive Power (Var)
	 *	11.	Lamp Apparent Power (VA)
	 *	12.	Power Factor
	 *	13.	Temperature
	 *	14.	Node Failure Message
	 * </pre>
	 */
	private LampStatus lampStatus;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "module_id")
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "location_id")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "geozone_id")
	public String getGeoZoneId() {
		return geoZoneId;
	}

	public void setGeoZoneId(String geoZoneId) {
		this.geoZoneId = geoZoneId;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "pole_id")
	public LampPole getLampPole() {
		return lampPole;
	}

	public void setLampPole(LampPole lampPole) {
		this.lampPole = lampPole;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "control_id")
	public LampControl getLampControl() {
		return lampControl;
	}

	public void setLampControl(LampControl lampControl) {
		this.lampControl = lampControl;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "status_id")
	public LampStatus getLampStatus() {
		return lampStatus;
	}

	public void setLampStatus(LampStatus lampStatus) {
		this.lampStatus = lampStatus;
	}

	@Override
	public String toString() {
		return "LampInfo [id=" + id + ", name=" + name + ", moduleId=" + moduleId + ", location=" + location
				+ ", geoZoneId=" + geoZoneId + ", address=" + address + ", lampPole=" + lampPole + ", lampControl="
				+ lampControl + ", lampStatus=" + lampStatus + "]";
	}

}
