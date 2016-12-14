package com.stee.nia.init;

import com.stee.nia.client.RealtimeConfigClient;
import com.stee.nia.jms.NotifyBroker;
import com.stee.nia.repository.ConnectionParamsRepository;
import com.stee.sel.nia.ConnectionParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
 * File Name    : InitialConfiguration.java
 * Author       : Jerry
 * Created      : 2016年11月17日 下午8:58:37
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Component
public class InitialConfiguration implements CommandLineRunner {
	@Autowired
	ConnectionParamsRepository repository;

	@Autowired
	NotifyBroker notifyBroker;

	private static RealtimeConfigClient client = new RealtimeConfigClient();

	ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

	ResourceBundle rb = ResourceBundle.getBundle("config");

	@Override
	public void run(String... arg0) throws Exception {
	    notifyBroker.sendMessage();
		List<ConnectionParams> findAll = repository.findAll();
		findAll.forEach(t -> {
			RealtimeConfigClient.map.put(t.getKey(), t.getValue());
		});
		long interval = 5;
		Integer obj = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			obj = restTemplate.getForObject(rb.getString("scm.rest.get.value") + "Polling_Interval", Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != obj) {
			try {
				interval = obj;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		executorService.scheduleAtFixedRate(() -> {
			client.getPollingStatus();
		}, interval, interval, TimeUnit.MINUTES);
	}

}
