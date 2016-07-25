package com.stee.cctv.dto;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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
public class SnapInfo {
	private String deviceId;

	private String picName;

	private String savePicPath;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getSavePicPath() {
		return savePicPath;
	}

	public void setSavePicPath(String savePicPath) {
		this.savePicPath = savePicPath;
	}

	@Override
	public String toString() {
		return "SnapInfo [deviceId=" + deviceId + ", picName=" + picName + ", savePicPath=" + savePicPath + "]";
	}

	public static String getSnapInfoXml(List<SnapInfo> list) {
		Element root = DocumentHelper.createElement("Message");
		Document document = DocumentHelper.createDocument(root);
		Element header = root.addElement("MessageHeader");
		header.addElement("Version").setText(Util.version);
		header.addElement("From").setText(Util.from);
		header.addElement("System").setText(Util.system);
		Element body = root.addElement("MessageBody").addAttribute("Type", "1004");
		body.addElement("SessionId").setText(Util.sessionId);
		body.addElement("SeqNum").setText(TimeUtil.getCurrentTimeStr());
		Element all = body.addElement("AllDevices");
		for (SnapInfo info : list) {
			Element device = all.addElement("Device");
			device.addElement("DeviceId").setText(info.deviceId);
			device.addElement("PicName").setText(info.picName);
			device.addElement("SavePicPath").setText(info.savePicPath);
		}
		return document.asXML();
	}

}
