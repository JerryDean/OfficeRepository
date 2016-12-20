package com.stee.sel.asm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
 * File Name    : LuminaireModelCofnig.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午1:15:41
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "STL_ASM_LUMINAIRE_MODEL")
public class LuminaireModelConfig {
	private Integer id;

	private String modelId;

	private String description;

	private String lampType;

	private Double ratedWatt;

	private String manufacturer;

	private boolean lightSensor;

	private boolean motionSensor;

	private boolean pollingMethod;

	private String picStr;

	// private byte[] picture;

	private String controlProtocol;

	private boolean isLifeTimeExits;

    public boolean isLifeTimeExits() {
        return isLifeTimeExits;
    }

    public void setLifeTimeExits(boolean lifeTimeExits) {
        isLifeTimeExits = lifeTimeExits;
    }

    @Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "lamp_type")
	public String getLampType() {
		return lampType;
	}

	public void setLampType(String lampType) {
		this.lampType = lampType;
	}

	@Column(name = "rated_watt")
	public Double getRatedWatt() {
		return ratedWatt;
	}

	public void setRatedWatt(Double ratedWatt) {
		this.ratedWatt = ratedWatt;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "built_in_light_sensor")
	public boolean isLightSensor() {
		return lightSensor;
	}

	public void setLightSensor(boolean lightSensor) {
		this.lightSensor = lightSensor;
	}

	@Column(name = "built_in_motion_sensor")
	public boolean isMotionSensor() {
		return motionSensor;
	}

	public void setMotionSensor(boolean motionSensor) {
		this.motionSensor = motionSensor;
	}

	@Column(name = "suppor_polling_method")
	public boolean isPollingMethod() {
		return pollingMethod;
	}

	public void setPollingMethod(boolean pollingMethod) {
		this.pollingMethod = pollingMethod;
	}

	@Column(name = "pic_str")
	public String getPicStr() {
		return picStr;
	}

	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}

	// @Lob
	// @Basic(fetch = FetchType.LAZY)
	// public byte[] getPicture() {
	// return picture;
	// }
	//
	// public void setPicture(byte[] picture) {
	// this.picture = picture;
	// }

	@Column(name = "control_protocol")
	public String getControlProtocol() {
		return controlProtocol;
	}

	public void setControlProtocol(String controlProtocol) {
		this.controlProtocol = controlProtocol;
	}

    @Override
    public String toString() {
        return "LuminaireModelConfig{" +
                "id=" + id +
                ", modelId='" + modelId + '\'' +
                ", description='" + description + '\'' +
                ", lampType='" + lampType + '\'' +
                ", ratedWatt=" + ratedWatt +
                ", manufacturer='" + manufacturer + '\'' +
                ", lightSensor=" + lightSensor +
                ", motionSensor=" + motionSensor +
                ", pollingMethod=" + pollingMethod +
                ", picStr='" + picStr + '\'' +
                ", controlProtocol='" + controlProtocol + '\'' +
                ", isLifeTimeExits=" + isLifeTimeExits +
                '}';
    }
}
