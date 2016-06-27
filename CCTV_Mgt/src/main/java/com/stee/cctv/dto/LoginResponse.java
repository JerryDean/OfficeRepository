package com.stee.cctv.dto;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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
public class LoginResponse {

	/**
	 * 返回状态信息
	 */
	public static String status;

	/**
	 * 登录sessionId
	 */
	public static String sessionId;

	public static String getLoginRespXml() {
		Element root = DocumentHelper.createElement("Message");
		Document document = DocumentHelper.createDocument(root);
		Element header = root.addElement("MessageHeader");
		header.addElement("Version").setText(Util.version);
		header.addElement("From").setText(Util.from);
		header.addElement("System").setText(Util.system);
		Element body = root.addElement("MessageBody").addAttribute("Type", "1001");
		body.addElement("Status").setText(status);
		body.addElement("SessionId").setText(sessionId);
		return document.asXML();
	}

}
