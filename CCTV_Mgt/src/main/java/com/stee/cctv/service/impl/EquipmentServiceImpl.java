package com.stee.cctv.service.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.cctv.dao.SnapDeviceRepository;
import com.stee.cctv.dto.PTISJsonTemplate;
import com.stee.cctv.dto.SnapInfo;
import com.stee.cctv.entity.ImageInfo;
import com.stee.cctv.entity.SnapDeviceInfo;
import com.stee.cctv.jms.TopicSender;
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
	SnapDeviceRepository repository;

	TopicSender sender = new TopicSender();

	@Override
	public List<SnapInfo> getSnapInfoList() {

		List<SnapInfo> list = new ArrayList<>();

		List<SnapDeviceInfo> deviceList = repository.findAll();

		String timeStr = TimeUtil.getCurrentTimeStr();
		String dateStr = TimeUtil.getTimeByYMD();

		List<ImageInfo> imageList = new ArrayList<>();

		for (SnapDeviceInfo info : deviceList) {
			SnapInfo snapInfo = new SnapInfo();
			snapInfo.setDeviceId(info.getId());
			snapInfo.setPicName(info.getDeviceId() + "_" + timeStr + ".jpg");
			snapInfo.setSavePicPath(Util.FTP_ADDRESS + "/CCTV/" + dateStr + "/" + info.getDeviceId() + "/");
			list.add(snapInfo);
			ImageInfo imageInfo = new ImageInfo();
			imageInfo.setDeviceId(info.getDeviceId());
			imageInfo.setDirection(info.getRoadDirection());
			imageInfo.setImageName(snapInfo.getPicName());
			imageInfo.setImageURL(snapInfo.getSavePicPath());
			imageInfo.setRoadId(info.getRoadId());
			imageInfo.setStakeNo(info.getRoadStake());
			imageInfo.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			imageList.add(imageInfo);
		}

		PTISJsonTemplate<ImageInfo> template = new PTISJsonTemplate<>();
		template.setStatus("ok");
		template.setData(imageList);
		template.setError("");

		StringWriter sw = new StringWriter();
		ObjectMapper om = new ObjectMapper();

		try {
			om.writeValue(sw, template);
		} catch (Exception e) {
			Util.logger.error(e.getMessage());
		}

		String result = sender.sendJMSMessage(sw.toString(), "TRAFFIC_IMAGE");
		Util.logger.info(result);

		return list;
	}

}
