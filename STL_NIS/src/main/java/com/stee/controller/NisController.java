package com.stee.controller;

import com.stee.asm.configuration.LampBurningHour;
import com.stee.asm.configuration.Status;
import com.stee.dto.Commands;
import com.stee.dto.Get;
import com.stee.dto.Set;
import com.stee.dto.realtime.RealtimeResult;
import com.stee.dto.realtime.Response;
import com.stee.dto.realtime.ResultObject;
import com.stee.dto.schedule.Configuration;
import com.stee.dto.scheduleResult.ScheduledResult;
import com.stee.gui.Gui;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : nis
 * File Name    : NisController.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午3:55:01
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/rest/secure/nms/provisioningapi")
public class NisController {
	public static Integer a;
	public static Integer b;
	public static Integer c;
	Map<String, Long> map = new HashMap<String, Long>();

	@RequestMapping(value = "/schedule", method = RequestMethod.POST)
	public ScheduledResult Time(@RequestBody Configuration config) {
		Gui.addText(config.toString());
		Runnable r;
		if (b == 400) {
			r = new Runnable() {
				public void run() {
					try {
						Thread.sleep(70000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			r.run();
		}
		if (b == 200) {
			ScheduledResult scheduledResult = new ScheduledResult();
			scheduledResult.setStatus("OK");
			return scheduledResult;
		}
		if (b == 500) {
			ScheduledResult scheduledResult = new ScheduledResult();
			scheduledResult.setStatus("ERROE");
			return scheduledResult;
		}
		ScheduledResult scheduledResult = new ScheduledResult();
		scheduledResult.setStatus("");
		return scheduledResult;
	}

	@RequestMapping(value = "/realtime", method = RequestMethod.POST)
	public RealtimeResult Burning(@RequestBody Commands commands) {
		if (a == 200) {
			Gui.addText(commands.toString());
			if (null != commands) {
				List<Set> set = commands.getSet();
				if (null != set && !set.isEmpty()) {

					RealtimeResult result = new RealtimeResult();
					ResultObject object = new ResultObject();
					List<Response> list = new ArrayList<Response>();

					set.forEach(command -> {

						String id = command.getId();

						String meaning = command.getMeaning();

						String value = command.getValue();// 获取传值中的value

						Status status = Gui.get(id);// gui中获取燃烧时间
						int hour = status.getBurningHour();
						boolean bo = false;

						Response res = new Response();

						if (command.getValue().equals("0")) {
							bo = false;
						} else {
							bo = true;
						}
						if (status.isLampOn() == false) {
							if (bo = true) {
								long now = System.currentTimeMillis();
								map.put(id, now);
								String string = "OK";
								res.setStatus(string);
								Date date = new Date();
								res.setDate(date);
								res.setValue(hour);
								SimpleDateFormat format = new SimpleDateFormat(
										"HH:mm");

								LampBurningHour lHour = new LampBurningHour();
								lHour.setId(id);
								lHour.setLampOn(bo);
								lHour.setBurningHour(hour);
								Gui.change(lHour, format.format(date), hour);
							}
							if (bo = false) {
								String string = "OK";
								res.setStatus(string);
								Date date = new Date();
								res.setDate(date);
								res.setValue(hour);
							}
						}

						if (status.isLampOn() == true) {
							if (bo == false) {
								long now = System.currentTimeMillis();
								long before = now;
								try {
									before = map.get(id);
								} catch (Exception e) {
									e.printStackTrace();
								}

								int val = (int) (Math
										.round((now - before) / 3600000.0));
								int sum = val + hour;
								map.remove(id);
								Date date = new Date();
								res.setDate(date);
								res.setValue(sum);
								SimpleDateFormat format = new SimpleDateFormat(
										"  HH:mm");
								LampBurningHour lamp = new LampBurningHour();
								lamp.setId(id);
								lamp.setBurningHour(sum);
								lamp.setLampOn(bo);

								Gui.change(lamp, format.format(date), sum);
							}

							if (bo = true) {
								String string = "OK";
								res.setDate(new Date());
								res.setValue(hour);
								res.setStatus(string);
							}
						}
						if (meaning.equals("LampLevelCommand")
								|| meaning.equals("LampCommandSwitch")
								|| meaning.equals("LampCommandMode")) {
							res.setValue(value);
						}
						list.add(res);
					});

					object.setClazz("com.stee.dto");
					object.setResponses(list);

					result.setResultObject(object);
					result.setStatus("SUCCESS");
					return result;
				}

				List<Get> get = commands.getGet();
				if (null != get && !get.isEmpty()) {

					RealtimeResult result = new RealtimeResult();
					ResultObject object = new ResultObject();
					List<Response> list = new ArrayList<Response>();

					get.forEach(command -> {
						String id = command.getId();

						String meaning = command.getMeaning();
						// 获取开关状态
						Status status = Gui.get(id);
						boolean bo = status.isLampOn();

						Response res = new Response();
						if (bo == false) {
							String string = "OK";
							res.setStatus(string);
							res.setDate(new Date());
							res.setValue(status.getBurningHour());
						}
						if (bo == true) {
							long now = System.currentTimeMillis();
							long before = map.get(id);

							int val = (int) (Math
									.round((now - before) / 3600000.0));
							int sum = val + status.getBurningHour();
							String string = "OK";
							res.setStatus(string);
							Date date = new Date();
							res.setDate(date);
							res.setValue(sum);
						}

						if (meaning.equals("LampCommandSwitch")
								|| meaning.equals("LampFailure")
								|| meaning.equals("LampSwitch")
								|| meaning.equals("LostCommunication")
								|| meaning.equals("MotionControl")
								|| meaning.equals("NodeFailure")
								|| meaning.equals("SetStateTimeoutConrol")
								|| meaning.equals("UnknowIdentifier")) {
							int a = (int) (Math.random() * 2);
							if (a == 1) {
								res.setValue(true);
							} else {
								res.setValue(false);
							}
						}

						if (meaning.equals("Current")
								|| meaning.equals("LampEnergy")
								|| meaning.equals("LampPower")
								|| meaning.equals("LampVoltage")
								|| meaning.equals("MainVoltage")
								|| meaning.equals("PowerFactor")
								|| meaning.equals("Temperature")) {
							float a = (float) (Math.random() * 30 + 1);
							res.setValue(a);
						}

						if (meaning.equals("LampCommandMode")) {
							int a = (int) (Math.random() * 2 + 1);
							if (a == 1) {
								res.setValue("AUTOMATIC");
							} else {
								res.setValue("MANUAL");
							}
						}

						if (meaning.equals("LampLevel")
								|| meaning.equals("LampLevelCommand")) {
							Integer a = (int) (Math.random() * 100);
							res.setValue(a);
						}

						if (meaning.equals("NodeFailureMessage")) {
							res.setValue("");
						}
						list.add(res);
					});

					object.setClazz("com.stee.dto");
					object.setResponses(list);

					result.setResultObject(object);
					result.setStatus("SUCCESS");
					return result;
				}
			}
		}
		if (a == 500) {

			RealtimeResult result = new RealtimeResult();
			result.setStatus("ERROR");

			return result;
		}
		if (a == 400) {
			Runnable r = new Runnable() {
				public void run() {
					try {
						Thread.sleep(70000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			r.run();
		}
		return null;
	}
}
