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
 * <p>PackageName : com.stee.dsms.log </p>
 * <p>ClassName   : Logger.java </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年10月11日T上午9:33:34</p>
 *
 * @author Jacob
 * @version 1.0
 *
 */
public interface ILogger {
	/**
	 * Record info message
	 * Logger#info
	 * @param message
	 */
	public void info(String message);
	/**
	 * Record debug message
	 * Logger#debug
	 * @param message
	 */
	public void debug(String message);
	/**
	 * Record error message
	 * Logger#error
	 * @param message
	 */
	public void error(String message);
	/**
	 * Record trace message
	 * Logger#trace
	 * @param message
	 */
	public void trace(String message);
	/**
	 * Record warn message
	 * Logger#warn
	 * @param message
	 */
	public void warn(String message);
}
