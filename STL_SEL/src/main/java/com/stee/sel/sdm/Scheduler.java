package com.stee.sel.sdm;

import java.io.Serializable;
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
 * Project Name : schedulerManagement
 * <p>
 * PackageName :com.stee.sdm.entity 
 * </p>
 * <p>
 * ClassName : Scheduler.java
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年10月9日---上午11:47:23
 * </p>
 *
 * @author chenshaoyin
 * @version 1.0
 *
 */
@Entity
@Table(name="STL_SDM_SCHEDULER")
public class Scheduler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_Scheduler")
	@SequenceGenerator(name = "gen_Scheduler", sequenceName = "SEQ_STL_SDM_SCHEDULER_ID", allocationSize = 1)
	private int id;
	
	@Id
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=Scheduler_command.class,fetch=FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="scheduler_id",nullable=true,updatable=true,insertable=true)
	private Set<Scheduler_command> commands;

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

	public Set<Scheduler_command> getCommands() {
		return commands;
	}

	public void setCommands(Set<Scheduler_command> commands) {
		this.commands = commands;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
