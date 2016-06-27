package com.stee.cctv.dto;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.stee.cctv.utils.NetAddressUtil;
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
public class HeartBeat {

	public static String getHeartBeatXml() {
		Element root = DocumentHelper.createElement("Message");
		Document document = DocumentHelper.createDocument(root);
		Element header = root.addElement("MessageHeader");
		header.addElement("Version").setText(Util.version);
		header.addElement("From").setText(Util.from);
		header.addElement("System").setText(Util.system);
		Element body = root.addElement("MessageBody").addAttribute("Type", "1002");
		body.addElement("SessionId").setText(NetAddressUtil.getLocalIpAddress());
		return document.asXML();
	}

}
