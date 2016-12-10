package com.stee.sel.atm;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * File Name    : LogInfo.java
 * Author       : xiongxiaobo
 * Created      : 2016年11月24日 下午3:49:29
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "stl_atm_loginfo")
public class LogInfo implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "methodname")
	private String methodname;
	@Column(name = "describeinfo")
	private String describeinfo;
	@Column(name = "param")
	private String param;
	@Column(name = "username")
	private String username;
	@Column(name = "objectid")
	private String objectid;
	@Column(name = "content")
	private String content;
	@Column(name = "time")
	private Timestamp time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	
	public String getDescribeinfo() {
		return describeinfo;
	}
	public void setDescribeinfo(String describeinfo) {
		this.describeinfo = describeinfo;
	}
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public LogInfo(int id, String methodname, String describeinfo,
			String param, String username, String objectid, String content,
			Timestamp time) {
		this.id = id;
		this.methodname = methodname;
		this.describeinfo = describeinfo;
		this.param = param;
		this.username = username;
		this.objectid = objectid;
		this.content = content;
		this.time = time;
	}
	public LogInfo() {
	}
	@Override
	public String toString() {
		return "LogInfo [id=" + id + ", methodname=" + methodname
				+ ", describeinfo=" + describeinfo + ", param=" + param
				+ ", username=" + username + ", objectid=" + objectid
				+ ", content=" + content + ", time=" + time + "]";
	}
}
