package com.stee.cctv.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.cctv.dao.EqtInfoExtendRepository;
import com.stee.cctv.dao.EqtInfoRepository;
import com.stee.cctv.dto.SnapInfo;
import com.stee.cctv.entity.EquipmentInfo;
import com.stee.cctv.entity.EquipmentInfoExtend;
import com.stee.cctv.service.IEquipmentService;
import com.stee.cctv.utils.TimeUtil;
import com.stee.cctv.utils.Util;

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
@Service("equipmentService")
public class EquipmentServiceImpl implements IEquipmentService {

	@Autowired
	EqtInfoRepository eqtInfo;

	@Autowired
	EqtInfoExtendRepository eqtExtendInfo;

	@Override
	public Map<String, String> getDeviceInfo() {
		Map<String, String> map = new HashMap<>();
		List<String> idList = new ArrayList<>();
		List<EquipmentInfo> infoList = eqtInfo.getEQTInfoByDeviceType(3);
		for (EquipmentInfo info : infoList) {
			idList.add(info.getId());
		}
		List<EquipmentInfoExtend> extendList = eqtExtendInfo.getEqtExtendByIdInAndUuidNotNull(idList);
		for (EquipmentInfoExtend extend : extendList) {
			map.put(extend.getId(), extend.getUuid());
		}
		return map;
	}

	@Override
	public List<SnapInfo> getSnapInfoList() {
		Map<String, String> map = new HashMap<>();
		List<String> idList = new ArrayList<>();
		List<EquipmentInfo> infoList = eqtInfo.getEQTInfoByDeviceType(3);
		for (EquipmentInfo info : infoList) {
			idList.add(info.getId());
		}
		List<EquipmentInfoExtend> extendList = eqtExtendInfo.getEqtExtendByIdInAndUuidNotNull(idList);
		for (EquipmentInfoExtend extend : extendList) {
			map.put(extend.getId(), extend.getUuid());
		}

		List<SnapInfo> list = new ArrayList<>();
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		String timeStr = TimeUtil.getCurrentTimeStr();
		String dateStr = TimeUtil.getTimeByYMD();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			SnapInfo snapInfo = new SnapInfo();
			snapInfo.setDeviceId(entry.getValue());
			snapInfo.setPicName(entry.getKey() + "_" + timeStr + ".jpg");
			snapInfo.setSavePicPath(Util.FTP_ADDRESS + "/CCTV/" + dateStr + "/" + entry.getKey() + "/");
			list.add(snapInfo);
		}
		return list;
	}

}
