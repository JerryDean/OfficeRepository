package com.stee.cpm.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import com.stee.sel.constant.LoggerLevel;
import com.stee.sl.ILogger;
import com.stee.sl.exception.NullParametersException;
import com.stee.sl.factory.DefaultLoggerFactory;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_CPM
 * File Name    : LoggerUtils.java
 * Author       : Jerry
 * Created      : 2016年10月31日 下午5:57:27
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class LoggerUtils {

	static ILogger logger;
	private String loggerPath;
	private String port;

	{
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		loggerPath = bundle.getString("logger.config.path");
		port = bundle.getString("logger.config.port");
	}

	public LoggerUtils() {
		super();
	}

	private void initLogger() {
		try {
			logger = DefaultLoggerFactory.buildUdpLogger(loggerPath, port);
		} catch (NullParametersException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doLog(LoggerLevel level, String log) {
		if (null == logger) {
			initLogger();
		}
		switch (level) {
		case INFO:
			logger.info(log);
			break;
		case DEBUG:
			logger.debug(log);
			break;
		case ERROR:
			logger.error(log);
			break;
		case TRACE:
			logger.trace(log);
			break;
		case WARN:
			logger.warn(log);
			break;
		}
	}

}
