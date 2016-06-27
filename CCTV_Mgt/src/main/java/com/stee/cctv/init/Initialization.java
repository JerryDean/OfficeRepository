package com.stee.cctv.init;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.stee.cctv.dao.EqtInfoExtendRepository;
import com.stee.cctv.dao.EqtInfoRepository;
import com.stee.cctv.entity.EquipmentInfo;
import com.stee.cctv.entity.EquipmentInfoExtend;
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
	@Autowired
	EqtInfoExtendRepository infoExtend;

	@Autowired
	EqtInfoRepository info;

	ExecutorService executorService = Executors.newCachedThreadPool();

	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

	public static List<EquipmentInfoExtend> extendList = new ArrayList<>();

	public void init() {
		executorService.execute(new Runnable() {
			public void run() {
				try {
					new Server().run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				new Initialization().cacheDeviceInterval();
			}
		}, 0, 5, TimeUnit.MINUTES);
	}

	public void cacheDeviceInterval() {
		List<String> idList = new ArrayList<>();
		List<EquipmentInfo> infoList = info.getEQTInfoByDeviceType(3);
		for (EquipmentInfo info : infoList) {
			idList.add(info.getId());
		}
		Initialization.extendList = infoExtend.getEqtExtendByIdInAndUuidNotNull(idList);
	}
}
