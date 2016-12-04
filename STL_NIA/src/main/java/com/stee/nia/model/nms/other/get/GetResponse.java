package com.stee.nia.model.nms.other.get;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

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
 * File Name    : Response.java
 * Author       : Jerry
 * Created      : 2016年10月21日 上午10:58:24
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType(propOrder = { "status", "date", "value", "statusInfo" })
public class GetResponse {
	private String status;

	private Date date;

	private Object value;

	private String statusInfo;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	@Override
	public String toString() {
		return "GetResponse [status=" + status + ", date=" + date + ", value=" + value + ", statusInfo=" + statusInfo
				+ "]";
	}

}
