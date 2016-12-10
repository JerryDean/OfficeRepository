package com.stee.sl;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import com.stee.sl.utils.PropertiesUtils;

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
 * ClassName : UdpLogger.java
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年10月11日T上午9:32:52
 * </p>
 *
 * @author Jacob
 * @version 1.0
 *
 */
public class UdpLogger implements ILogger {
	private static final String SERVER_HOSTNAME = "serverHostName";
	private static final String SERVER_HOSTPORT = "serverHostPort";
	private static final String DEFAULT_RELOAD = "defaultReload";
	private static final String LOG_LEVEL = "logLevel";
	// private static final String LOCAL_SEND_PORT = "localSendPort";

	private static Map<String, String> CONFIGURATION_MAP = new HashMap<String, String>();
	private static final String PROPERTIES_NAME = "LoggerConfig.properties";

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(UdpLogger.class.getName());
	private DatagramSocket client = null;
	private Timer reloadTimer = new Timer(true);
	private String logFolder = "../config/";

	static {
		CONFIGURATION_MAP.put(SERVER_HOSTNAME, "255.255.255.255");
		CONFIGURATION_MAP.put(SERVER_HOSTPORT, "9700");
		CONFIGURATION_MAP.put(DEFAULT_RELOAD, "10000");
		CONFIGURATION_MAP.put(LOG_LEVEL, "2");
		// CONFIGURATION_MAP.put(LOCAL_SEND_PORT, "9966");
	}

	public UdpLogger(String logFolder, String sendPort) throws IOException {
		this.logFolder = logFolder;
		if (null != sendPort && !sendPort.equals("")) {
			try {
				Integer.valueOf(sendPort);
				CONFIGURATION_MAP.put(SERVER_HOSTPORT, sendPort);
			} catch (NumberFormatException e) {

			}
		}
		// Init load defaultLogger.properties
		initDefaultConfig();
		// Init UDP connection
		initDatagramSocket();
		// Init reload timer
		initReloadTimer();
		LOGGER.info("Successfully init UDP configuration.");
	}

	/**
	 * 
	 * UdpLogger#initDatagramSocket
	 * 
	 * @throws NumberFormatException
	 * @throws SocketException
	 */
	private void initDatagramSocket() throws NumberFormatException, SocketException {
		if (this.client != null) {
			this.client.close();
		}
		// this.client = new
		// DatagramSocket(Integer.parseInt(CONFIGURATION_MAP.get(LOCAL_SEND_PORT).toString()));
		this.client = new DatagramSocket();
	}

	/**
	 * Init reload timer UdpLogger#initReloadTimer
	 */
	private void initReloadTimer() {
		// Removes all cancelled tasks from this timer's task queue.
		reloadTimer.purge();
		reloadTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// Reload properties
				try {
					Map<String, String> tempMap = PropertiesUtils.reloadProperties(logFolder + PROPERTIES_NAME);
					if (!tempMap.isEmpty() && !tempMap.equals(CONFIGURATION_MAP)) {
						CONFIGURATION_MAP.putAll(tempMap);
						// reload timer
						this.cancel();
						initReloadTimer();
						initDatagramSocket();
						LOGGER.info("Reload system configuration.{}" + new Date());
					}
				} catch (Exception e) {
					LOGGER.warning("initReloadTimer error:{}" + e);
				}
			}
		}, Long.parseLong(CONFIGURATION_MAP.get(DEFAULT_RELOAD).toString()),
				Long.parseLong(CONFIGURATION_MAP.get(DEFAULT_RELOAD).toString()));
	}

	/**
	 * Init configuration file UdpLogger#initDefaultConfig
	 * 
	 * @throws IOException
	 */
	private void initDefaultConfig() throws IOException {
		String path = logFolder + PROPERTIES_NAME;
		File file = new File(path);
		if (file.exists()) {
			CONFIGURATION_MAP.putAll(PropertiesUtils.readProperties(path));
		} else {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			for (Entry<String, String> entry : CONFIGURATION_MAP.entrySet()) {
				PropertiesUtils.writeProperties(path, entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 
	 * UdpLogger#sendData
	 * 
	 * @param data
	 */
	private void sendData(String data, LogLevelEnum logLevel) {
		try {
			if (Integer.parseInt(CONFIGURATION_MAP.get(LOG_LEVEL)) <= logLevel.getIndex()) {
				byte[] bytes = data.getBytes(Charset.forName("utf-8"));
				client.send(new DatagramPacket(bytes, bytes.length,
						new InetSocketAddress(CONFIGURATION_MAP.get(SERVER_HOSTNAME),
								Integer.parseInt(CONFIGURATION_MAP.get(SERVER_HOSTPORT)))));
			}
		} catch (Exception e) {
			LOGGER.warning("{} Send log message error." + UdpLogger.class.getName());
		}
	}

	@Override
	public void info(String message) {
		if (message == null || message.length() == 0) {
			return;
		}
		sendData(String.format("{data:%s, type:%s}", message, LogLevelEnum.INFO), LogLevelEnum.INFO);
	}

	@Override
	public void debug(String message) {
		if (message == null || message.length() == 0) {
			return;
		}
		sendData(String.format("{data:%s, type:%s}", message, LogLevelEnum.DEBUG), LogLevelEnum.DEBUG);
	}

	@Override
	public void error(String message) {
		if (message == null || message.length() == 0) {
			return;
		}
		sendData(String.format("{data:%s, type:%s}", message, LogLevelEnum.ERROR), LogLevelEnum.ERROR);
	}

	@Override
	public void trace(String message) {
		if (message == null || message.length() == 0) {
			return;
		}
		sendData(String.format("{data:%s, type:%s}", message, LogLevelEnum.TRACE), LogLevelEnum.TRACE);

	}

	@Override
	public void warn(String message) {
		if (message == null || message.length() == 0) {
			return;
		}
		sendData(String.format("{data:%s, type:%s}", message, LogLevelEnum.WARN), LogLevelEnum.WARN);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		ILogger udp = new UdpLogger("c:/zhaojc/", "9700");
		udp.info("Test");
		Thread.sleep(5000000);
	}
	// private UdpLogger(){
	//
	// }
	// private static class UdpLoggerHolder{
	// private static UdpLogger instance = new UdpLogger();
	// }
	// public static UdpLogger getInstance(){
	// return UdpLoggerHolder.instance;
	// }
}
