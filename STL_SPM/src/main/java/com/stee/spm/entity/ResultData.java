package com.stee.spm.entity;

import java.io.Serializable;
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
 * Project Name : Street Lighting
 * File Name    : ResultData.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午2:05:19
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class ResultData<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 单资源时，该资源的唯一编码
	 */
	private String id;

	/**
	 * Response code： -- Success: 000000 -- Failed: 999999 -- Parameter error:
	 * 900101 -- Object isn't exits: 900102 -- Server error: 900008
	 */
	private String status;

	/**
	 * 复数资源 集合。
	 */
	private List<E> data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public E getUniqueData() {
		return this.data != null && this.data.size() > 0 ? this.data.get(0) : null;
	}

	public void setUniqueData(E e) {
		this.data.add(e);
	}

	@Override
	public String toString() {
		return "ResultData [id=" + id + ", status=" + status + ", data=" + data + "]";
	}

}
