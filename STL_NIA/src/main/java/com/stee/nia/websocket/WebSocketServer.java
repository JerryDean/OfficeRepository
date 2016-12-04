package com.stee.nia.websocket;

import java.util.ResourceBundle;

import org.eclipse.jetty.server.Server;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_NIA
 * File Name    : Test.java
 * Author       : Jerry
 * Created      : 2016年11月23日 下午3:24:07
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class WebSocketServer {
	private static Integer port;

	{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		try {
			port = Integer.valueOf(rb.getString("socket.port"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void run() {
		Server server = new Server(port);
		server.setHandler(new MySocketHandler());
		server.setStopTimeout(0);
		try {
			server.start();
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
