package com.stee.sl;
/** Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or licence agreement with ST Electronics Info-comm Systems PTE. LTD.
 *
 * Project Name : dsms_framework_old
 * <p>PackageName : com.stee.dsms.log.common </p>
 * <p>ClassName   : LogLevel.java </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年10月12日T下午2:11:51</p>
 *
 * @author Jacob
 * @version 1.0
 *
 */
public enum LogLevelEnum {

	TRACE(0),DEBUG(1),INFO(2),WARN(3),ERROR(4);
	private int index;

	private LogLevelEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
}
