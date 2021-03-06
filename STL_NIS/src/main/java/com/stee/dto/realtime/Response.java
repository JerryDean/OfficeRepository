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
 * File Name    : Response
 * Author       : Jerry
 * Created      : 2016/12/16
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
package com.stee.dto.realtime;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by SerryMiano on 2016/12/16.
 */
@XmlType(propOrder = {"status", "date", "value", "statusInfo"})
public class Response {
    private String status;
    private Date date;
    private Object value;
    private String statusInfo;

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", value='" + value + '\'' +
                ", statusInfo='" + statusInfo + '\'' +
                '}';
    }

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

	public void setValue(String value) {
        this.value = value;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
}
