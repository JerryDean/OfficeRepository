package com.stee.cctv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD All rights
 * reserved.
 *
 * This software is confidential and proprietary property of ST Electronics
 * Info-comm Systems PTE. LTD. The user shall not disclose the contents of this
 * software and shall only use it in accordance with the terms and conditions
 * stated in the contract or licence agreement with ST Electronics Info-comm
 * Systems PTE. LTD.
 *
 * @author Jerry
 * @version 1.0
 *
 */
@Table(name = "TR_CCTV_SNAP_DEVICE")
@Entity
public class SnapDeviceInfo {
	private String id;
	private String deviceId;
	private String roadStake;
	private String roadDirection;
	private String roadId;

	@Column(name = "ROAD_STAKE")
	public String getRoadStake() {
		return roadStake;
	}

	public void setRoadStake(String roadStake) {
		this.roadStake = roadStake;
	}

	@Column(name = "ROAD_DIRECTION")
	public String getRoadDirection() {
		return roadDirection;
	}

	public void setRoadDirection(String roadDirection) {
		this.roadDirection = roadDirection;
	}

	@Column(name = "ROAD_ID")
	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "DEVICE_ID")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "SnapDeviceInfo [id=" + id + ", deviceId=" + deviceId + "]";
	}

}
