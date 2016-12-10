package com.stee.sel.gzm;

import java.io.Serializable;

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
 * File Name    : GZoneTree.java
 * Author       : xiongxiaobo
 * Created      : 2016年11月24日 下午3:53:02
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Entity
@Table(name = "stl_gzm_gzonetree")
public class GZoneTree implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;        //唯一的编号
	@Column(name="level")
	private Integer level;     //当前的树 级别，根节点为1 ，根节点的子节点为2，子节点往下加1； 0 为GZone级别
	@Column(name="parentid")
	private Integer parentId;  //父类编号
	@Column(name="orderno")
	private Integer orderNo;   //排列顺序
	@Column(name="name")
	private String name;       //树节点名称
	@Column(name="levelname")
	private String levelName;  //树级别名称
	@Column(name="gzoneid")
	private String gzoneId;    //区域的编号
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public String getGzoneId() {
		return gzoneId;
	}
	public void setGzoneId(String gzoneId) {
		this.gzoneId = gzoneId;
	}
	public GZoneTree(Integer id, Integer level, Integer parentId,
			Integer orderNo, String name, String levelName, String gzoneId) {
		this.id = id;
		this.level = level;
		this.parentId = parentId;
		this.orderNo = orderNo;
		this.name = name;
		this.levelName = levelName;
		this.gzoneId = gzoneId;
	}
	public GZoneTree() {
	}
	@Override
	public String toString() {
		return "GZoneTree [id=" + id + ", level=" + level + ", parentId="
				+ parentId + ", orderNo=" + orderNo + ", name=" + name
				+ ", levelName=" + levelName + ", gzoneId=" + gzoneId + "]";
	}
}
