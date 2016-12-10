package com.stee.sl.factory;

import java.io.IOException;

import com.stee.sl.ILogger;
import com.stee.sl.UdpLogger;
import com.stee.sl.exception.NullParametersException;

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
 * Project Name : dsms_framework_old
 * <p>
 * PackageName : com.stee.dsms.log
 * </p>
 * <p>
 * ClassName : DefaultLogFactory.java
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年10月11日T上午9:31:57
 * </p>
 *
 * @author Jacob
 * @version 1.0
 *
 */
public class DefaultLoggerFactory {

	public DefaultLoggerFactory() {
	}

	/**
	 * logFolder format:
	 * 
	 * @windows c:/config/
	 * @linux /usr/ DefaultLoggerFactory#buildUdpLogger
	 * @param logFolder
	 * @return
	 * @throws NullParametersException
	 * @throws IOException
	 */
	public static ILogger buildUdpLogger(String logFolder, String sendPort)
			throws NullParametersException, IOException, NumberFormatException {
		if (logFolder == null || logFolder.length() == 0) {
			throw new NullParametersException("Parameter logFolder is necessary, but it is empty.");
		} else if (null == sendPort) {
			throw new NullParametersException("Parameter sendPort is necessary, but it is empty.");
		}
		Integer.valueOf(sendPort);
		return new UdpLogger(logFolder, sendPort);
	}
}
