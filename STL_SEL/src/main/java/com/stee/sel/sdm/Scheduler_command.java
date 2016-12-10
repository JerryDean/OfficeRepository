package com.stee.sel.sdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
 * Project Name : schedulerManagement
 * <p>
 * PackageName :com.stee.sdm.entity
 * </p>
 * <p>
 * ClassName : Scheduler_command.java
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年10月9日---下午1:56:45
 * </p>
 *
 * @author chenshaoyin
 * @version 1.0
 *
 */
@Entity
@Table(name = "STL_SDM_COMMAND")
public class Scheduler_command implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_Command")
	@SequenceGenerator(name = "gen_Command", sequenceName = "SEQ_STL_SDM_COMMAND_ID", allocationSize = 1)
	private int id;

	// @Column(name="SCHEDULER_ID")
	// private String scheduler_id;

	@Column(name = "COMMANDTYPE")
	private int commandType;

	@Column(name = "TIMMINGTYPE")
	private int timingType;

	@Column(name = "RELATIVETIMINGTYPE")
	private int relativeTimingType;

	@Column(name = "COMMANDTIMING")
	private String commandTiming;

	@Column(name = "COMMANDVALUE")
	private int commandValue;

	// @XmlTransient
	// public Scheduler getScheduler() {
	// return scheduler;
	// }
	//
	// public void setScheduler(Scheduler scheduler) {
	// this.scheduler = scheduler;
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public String getScheduler_id() {
	// return scheduler_id;
	// }
	//
	// public void setScheduler_id(String scheduler_id) {
	// this.scheduler_id = scheduler_id;
	// }

	public int getCommandType() {
		return commandType;
	}

	public void setCommandType(int commandType) {
		this.commandType = commandType;
	}

	public int getTimingType() {
		return timingType;
	}

	public void setTimingType(int timingType) {
		this.timingType = timingType;
	}

	public int getRelativeTimingType() {
		return relativeTimingType;
	}

	public void setRelativeTimingType(int relativeTimingType) {
		this.relativeTimingType = relativeTimingType;
	}

	public String getCommandTiming() {
		return commandTiming;
	}

	public void setCommandTiming(String commandTiming) {
		this.commandTiming = commandTiming;
	}

	public int getCommandValue() {
		return commandValue;
	}

	public void setCommandValue(int commandValue) {
		this.commandValue = commandValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
