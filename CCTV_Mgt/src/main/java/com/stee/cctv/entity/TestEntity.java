package com.stee.cctv.entity;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.stee.cctv.utils.ByteUtil;

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
public class TestEntity {

	public static byte[] array() {
		byte[] startByte = new byte[] { 0x01 };
		String message = message();
		byte[] contentByte = message.getBytes();
		byte[] lengthByte = new byte[4];
		lengthByte = ByteUtil.intToBytes(contentByte.length);
		lengthByte = ByteUtil.littleEndian(lengthByte);
		byte[] endByte = new byte[] { 0x00 };
		byte[] temp = new byte[] {};
		temp = ByteUtil.byteMerger(temp, startByte);
		temp = ByteUtil.byteMerger(temp, lengthByte);
		temp = ByteUtil.byteMerger(temp, contentByte);
		temp = ByteUtil.byteMerger(temp, endByte);
		return temp;
	}

	public static String message() {
		Element root = DocumentHelper.createElement("Message");
		Document document = DocumentHelper.createDocument(root);
		Element header = root.addElement("MessageHeader");
		header.addElement("Version").setText("2.0");
		header.addElement("From").setText("厂商");
		header.addElement("System").setText("CCTV");
		Element body = root.addElement("MessageBody").addAttribute("Type", "1003");
		body.addElement("SessionId").setText("127001");
		body.addElement("SeqNum").setText("10011002");
		Element state = body.addElement("AllStatus");
		for (int i = 0; i < 10; i++) {
			Element device = state.addElement("Device");
			device.addElement("DeviceId").setText("1031015" + i);
			device.addElement("Status").setText("OK");
		}
		return document.asXML();
	}

	public static String loginInfo() {
		Element root = DocumentHelper.createElement("Message");
		Document document = DocumentHelper.createDocument(root);
		Element header = root.addElement("MessageHeader");
		header.addElement("Version").setText("2.0");
		header.addElement("From").setText("厂商");
		header.addElement("System").setText("CCTV");
		Element body = root.addElement("MessageBody").addAttribute("Type", "1001");
		body.addElement("UserName").setText("cctv");
		body.addElement("Password").setText("123");
		return document.asXML();
	}

}
