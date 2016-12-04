package com.stee.nia.model.nms.auth;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 * File Name    : AuthResult.java
 * Author       : Jerry
 * Created      : 2016年10月21日 下午2:25:38
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@XmlType(name = "resultObject", propOrder = { "tokenType", "token", "refresh", "expire" })
public class AuthResult {
	private String clazz;

	private String tokenType;

	private String token;

	private String refresh;

	private String expire;

	@XmlAttribute(name = "class")
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	@XmlElement(name = "oauth_token_type")
	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@XmlElement(name = "oauth_access_token")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@XmlElement(name = "oauth_refresh_token")
	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}

	@XmlElement(name = "oauth_expires_in")
	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "AuthResult [clazz=" + clazz + ", tokenType=" + tokenType + ", token=" + token + ", refresh=" + refresh
				+ ", expire=" + expire + "]";
	}

}
