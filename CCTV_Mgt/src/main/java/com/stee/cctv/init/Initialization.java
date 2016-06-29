package com.stee.cctv.init;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import com.stee.cctv.netty.handler.ServerHandler;
import com.stee.cctv.netty.server.Server;

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
 * @author Jerry
 * @version 1.0
 *
 */
public class Initialization {
	@Resource
	ServerHandler serverHandler;

	ExecutorService executorService = Executors.newCachedThreadPool();

	public void init() {
		executorService.execute(new Runnable() {
			public void run() {
				try {
					new Server(serverHandler).run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
