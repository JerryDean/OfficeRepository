package com.stee.sel.dgm;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.stee.sel.gzm.GZone;



/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : DimmingGroupManagement
 * File Name    : DimmingGroup.java
 * Package Name : com.stee.dgm.entity
 * Author       : chensahoyin
 * Created      : 2016年10月13日 ---- 上午10:02:47
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name="STL_DGM_GROUP")
public class DimmingGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_Group")
	@SequenceGenerator(name = "gen_Group", sequenceName = "SEQ_STL_DGM_GROUP_ID", allocationSize = 1)
	private int id;
	
	@Id
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=GZone.class,fetch=FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="dimmingGroupId",nullable=true,updatable=true,insertable=true)
	private Set<GZone> gzones;
	
	@Column(name="CREATETIME")
	private Date createTime;
	
	@Column(name="RESERVE1")
	private String reserveChar1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<GZone> getGzones() {
		return gzones;
	}

	public void setGzones(Set<GZone> gzones) {
		this.gzones = gzones;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

	public String getReserveChar1() {
		return reserveChar1;
	}

	public void setReserveChar1(String reserveChar1) {
		this.reserveChar1 = reserveChar1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
