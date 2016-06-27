package com.stee.cctv.netty.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.stee.cctv.dto.DeviceStatusResponse;
import com.stee.cctv.dto.LoginResponse;
import com.stee.cctv.dto.SnapInfo;
import com.stee.cctv.service.IAlarmService;
import com.stee.cctv.service.IEquipmentService;
import com.stee.cctv.utils.NetAddressUtil;
import com.stee.cctv.utils.Util;
import com.stee.cctv.utils.XmlUtil;
import com.stee.cctv.ws.client.Alarm;
import com.stee.cctv.ws.client.AlarmType;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

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
public class ServerHandler extends ChannelHandlerAdapter {

	IAlarmService alarmService;

	IEquipmentService equipmentService;

	public ServerHandler() {
		super();
	}

	public ServerHandler(IAlarmService alarmService, IEquipmentService equipmentService) {
		super();
		this.alarmService = alarmService;
		this.equipmentService = equipmentService;
	}

	ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		// 心跳线程
		// executorService.scheduleAtFixedRate(new Runnable() {
		// public void run() {
		// ctx.writeAndFlush(HeartBeat.getHeartBeatXml());
		// }
		// }, 0, Util.INTERVAL_HEARTBEAT, TimeUnit.SECONDS);

		// 视频截图线程
		executorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				// 截图信息
				ctx.writeAndFlush(SnapInfo.getSnapInfoXml(equipmentService.getSnapInfoList()));
			}
		}, 0, Util.INTERVAL_SNAP, TimeUnit.MINUTES);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String type = XmlUtil.getMessageType(String.valueOf(msg));
		switch (type) {
		case Util.TYPE_LOGIN:
			try {
				handleLogin(ctx, msg);
			} catch (Exception e) {
				Util.setSessionId(NetAddressUtil.getRemoteIpAddress(ctx));
				LoginResponse.sessionId = Util.sessionId;
				LoginResponse.status = Util.BAD_MESSAGE;
				ctx.writeAndFlush(LoginResponse.getLoginRespXml());
			}
			break;
		case Util.TYPE_HEARTBEAT:
			handleHeartBeat(ctx, msg);
			break;
		case Util.TYPE_DEVICE_STATE:
			try {
				handleDeviceStatus(ctx, msg);
			} catch (Exception e) {
				Document doc = DocumentHelper.parseText(String.valueOf(msg));
				Element el = (Element) doc.selectSingleNode("//SeqNum");
				DeviceStatusResponse.seqNum = el.getText();
				DeviceStatusResponse.status = Util.BAD_MESSAGE;
				ctx.writeAndFlush(DeviceStatusResponse.getDeviceStatusRespXml());
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Util.logger.info(cause.getMessage());
		ctx.close();
	}

	/**
	 * 客户端登录
	 * 
	 * @param ctx
	 * @param msg
	 * @author Jerry
	 * @throws DocumentException
	 */
	public void handleLogin(ChannelHandlerContext ctx, Object msg) throws DocumentException {
		Util.logger.info("客户端登录...");
		Document doc = DocumentHelper.parseText(String.valueOf(msg));
		String username = doc.getRootElement().element("MessageBody").element("UserName").getText();
		String password = doc.getRootElement().element("MessageBody").element("Password").getText();
		Util.setSessionId(NetAddressUtil.getRemoteIpAddress(ctx));
		boolean result = validateUser(username, password);
		LoginResponse.sessionId = Util.sessionId;
		if (result) {
			LoginResponse.status = Util.SUCCESS;
		} else {
			LoginResponse.status = Util.FAILED;
		}
		String response = LoginResponse.getLoginRespXml();
		ctx.writeAndFlush(response);
	}

	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @author Jerry
	 */
	public boolean validateUser(String username, String password) {
		boolean flag = false;
		// TODO 简单验证
		if (username.equals(Util.USERNAME) && password.equals(Util.PASSWORD)) {
			flag = true;
			Util.logger.info("登录成功！SessionId:" + Util.sessionId);
		} else {
			flag = false;
			Util.logger.info("登录失败！");
		}
		return flag;
	}

	/**
	 * 心跳
	 * 
	 * @param ctx
	 * @param msg
	 * @author Jerry
	 * @throws DocumentException
	 */
	public void handleHeartBeat(ChannelHandlerContext ctx, Object msg) throws DocumentException {
		Document doc = DocumentHelper.parseText(String.valueOf(msg));
		String sessionId = doc.getRootElement().element("MessageBody").element("SessionId").getText();
		Util.logger.info("心跳数据... SessionId:" + sessionId);
	}

	/**
	 * 设备状态
	 * 
	 * @param ctx
	 * @param msg
	 * @author Jerry
	 * @throws DocumentException
	 */
	public void handleDeviceStatus(ChannelHandlerContext ctx, Object msg) throws DocumentException {
		Document doc = DocumentHelper.parseText(String.valueOf(msg));
		Element element = (Element) doc.selectSingleNode("//SeqNum");
		DeviceStatusResponse.seqNum = element.getText();
		try {
			getDeviceStatus(doc);
			DeviceStatusResponse.status = Util.SUCCESS;
		} catch (Exception e) {
			Util.logger.info(e.getMessage());
			DeviceStatusResponse.status = Util.FAILED;
		}
		ctx.writeAndFlush(DeviceStatusResponse.getDeviceStatusRespXml());
	}

	public void getDeviceStatus(Document doc) {
		List<Alarm> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Element> els = doc.selectNodes("//Device");
		for (Element e : els) {
			Alarm alarm = new Alarm();
			String deviceId = e.element("DeviceId").getText();
			String status = e.element("Status").getText();
			if (status.equals(Util.OK)) {
				alarm.setClearTime(convertToXMLGregorianCalendar(new Date()));
				alarm.setDescription("设备状态正常");
			} else if (status.equals(Util.FAUTY)) {
				alarm.setDescription("设备状态故障");
			}
			alarm.setAlarmCode(Util.ALARMCODE);
			alarm.setAlarmSource("CCTV");
			alarm.setDetectionTime(convertToXMLGregorianCalendar(new Date()));
			alarm.setDeviceID(deviceId);
			alarm.setZoneID(0);
			list.add(alarm);
		}
		alarmService.updateFelsAlarm(AlarmType.NORMAL, list);
	}

	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return gc;
	}

}
