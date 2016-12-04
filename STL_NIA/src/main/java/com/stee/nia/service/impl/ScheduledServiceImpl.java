package com.stee.nia.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.stee.nia.model.scheduled.Calendar;
import com.stee.nia.model.scheduled.Command;
import com.stee.nia.model.scheduled.Configuration;
import com.stee.nia.model.scheduled.ControlProgram;
import com.stee.nia.model.scheduled.Device;
import com.stee.nia.model.scheduled.ParamTypeOne;
import com.stee.nia.model.scheduled.Rule;
import com.stee.nia.model.scheduled.Schedulers;
import com.stee.nia.repository.DailyProfileRepository;
import com.stee.nia.repository.LuminaireRepository;
import com.stee.nia.service.IScheduledService;
import com.stee.sel.asm.LuminaireModelConfig;
import com.stee.sel.cpm.CalendarProfile;
import com.stee.sel.cpm.SchedulingRule;
import com.stee.sel.dpm.DailyProfile;
import com.stee.sel.dpm.Daily_command;
import com.stee.sel.lim.LampInfo;

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
 * File Name    : ScheduledServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年11月24日 下午3:18:01
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class ScheduledServiceImpl implements IScheduledService {

	private Configuration configuration;
	private List<Device> devices;
	private List<Schedulers> schedulers;

	@Autowired
	LuminaireRepository luminaireRepo;

	@Autowired
	DailyProfileRepository dpRepo;

	@Override
	public void commission(CalendarProfile cp) {
		if (null == cp) {
			return;
		}
		String dimmingGroupId = cp.getDimmingGroupId();
		if (null != dimmingGroupId && !dimmingGroupId.equals("")) {
			ResourceBundle bundle = ResourceBundle.getBundle("config");
			String url = bundle.getString("dgm.rest.url");
			String url2 = bundle.getString("lim.rest.get_by_geozoneid");

			RestTemplate restTemplate = new RestTemplate();
			@SuppressWarnings("unchecked")
			List<String> forObject = restTemplate.getForObject(url, List.class);
			// forObject DimmingGroup 的membership.
			if (null != forObject && !forObject.isEmpty()) {
				List<LampInfo> allDevices = new ArrayList<>();
				forObject.forEach(str -> {
					RestTemplate restTemplate2 = new RestTemplate();
					@SuppressWarnings("unchecked")
					List<LampInfo> devices = restTemplate2.getForObject(url2, List.class);
					if (null != devices && !devices.isEmpty()) {
						allDevices.addAll(devices);
					}
				});
				this.adaptDevice(dimmingGroupId, allDevices);
				this.adaptSchedulers(cp);
			}
			if (null != this.schedulers && !this.schedulers.isEmpty() && null != this.devices
					&& !this.devices.isEmpty()) {
				this.configuration = new Configuration();
				this.configuration.setDevices(devices);
				this.configuration.setSchedulers(schedulers);
			}
		}
	}

	/**
	 * Scheduler 数据适配
	 * 
	 * @param cp
	 * @author Jerry
	 */
	private void adaptSchedulers(CalendarProfile cp) {
		schedulers = new ArrayList<>();
		Schedulers schedulers2 = new Schedulers();
		List<ControlProgram> controlProgs = Lists.newArrayList();
		List<Calendar> calendars = Lists.newArrayList();
		// Calendars
		Calendar calendar = new Calendar();
		calendar.setId(String.valueOf(cp.getId()));
		List<Rule> calendarRules = Lists.newArrayList();
		List<SchedulingRule> rules = cp.getRules();
		if (null != rules) {
			rules.forEach(rule -> {
				// ControlProgram
				String schedulerId = rule.getSchedulerId();
				if (null == schedulerId || schedulerId.equals("")) {
					return;
				}
				DailyProfile dp = dpRepo.findOne(schedulerId);
				if (null == dp) {
					return;
				}
				Set<Daily_command> daily_commands = dp.getDaily_commands();
				if (null == daily_commands || daily_commands.isEmpty()) {
					return;
				}
				ControlProgram controlProgram = new ControlProgram();
				controlProgram.setId(schedulerId);
				List<Command> commands = Lists.newArrayList();
				daily_commands.forEach(command -> {
					Command command2 = new Command();
					command2.setTime(command.getStartTime());
					command2.setValue(String.valueOf(command.getCommandValue()));
					commands.add(command2);
				});
				controlProgram.setCommand(commands);
				controlProgs.add(controlProgram);

				Rule rule2 = new Rule();
				rule2.setControlProgram(schedulerId);
				rule2.setPriority(String.valueOf(rule.getPriority()));
				String[] split = rule.getRecurrentPattern().split(":");
				switch (split[0]) {
				case "Day-based":
					rule2.setProfile("daybased");
					rule2.setStart(split[1]);
					rule2.setEnd(split[1]);
					break;
				case "Date-based DD":
					rule2.setProfile("monthlybased");
					rule2.setStart(split[1]);
					rule2.setEnd(split[1]);
					break;
				case "Date-based DD.MM":
					rule2.setProfile("datebased");
					String dateStr = split[1];
					String[] date = dateStr.split("\\.");
					String day = date[0];
					String month = date[1];
					rule2.setStart(day + "-" + month);
					rule2.setEnd(day + "-" + month);
					break;
				case "Date-based DD.MM.YYYY":
					rule2.setProfile("datebased");
					String dateStr1 = split[1];
					String[] date1 = dateStr1.split("\\.");
					String day1 = date1[0];
					String month1 = date1[1];
					String year = date1[2];
					rule2.setStart(year + "-" + month1 + "-" + day1);
					rule2.setStart(year + "-" + month1 + "-" + day1);
					break;
				}
				calendarRules.add(rule2);
			});
			calendar.setRule(calendarRules);
			calendars.add(calendar);
			schedulers2.setCalendars(calendars);
			schedulers2.setControlPrograms(controlProgs);
			this.schedulers.add(schedulers2);
		}
	}

	/**
	 * 设备数据适配
	 * 
	 * @return
	 * @author Jerry
	 */
	private void adaptDevice(String dimmingGroupName, List<LampInfo> allDevices) {
		if (null != allDevices && !allDevices.isEmpty()) {
			devices = new ArrayList<>();
			allDevices.forEach(lampInfo -> {
				Device device = new Device();
				device.setId(lampInfo.getId());
				List<ParamTypeOne> params = Lists.newArrayList();
				// LampType
				ParamTypeOne paramTypeOne = new ParamTypeOne();
				paramTypeOne.setKey("LampType");

				String controlProtocol = "";
				try {
					String moduleId = lampInfo.getModuleId();
					LuminaireModelConfig luminaire = luminaireRepo.findOne(moduleId);
					controlProtocol = luminaire.getControlProtocol();
				} catch (Exception e) {
					e.printStackTrace();
				}
				paramTypeOne.setResourceId(controlProtocol);
				params.add(paramTypeOne);
				// Address
				String address = lampInfo.getAddress();
				ParamTypeOne addr = new ParamTypeOne();
				addr.setKey("address");
				addr.setValue(address);
				params.add(addr);
				// InstallDate
				Date installedDate = lampInfo.getLampStatus().getInstalledDate();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String formatDate = simpleDateFormat.format(installedDate);
				ParamTypeOne insDate = new ParamTypeOne();
				insDate.setKey("install.date");
				insDate.setValue(formatDate);
				params.add(insDate);
				// Latitude
				Double latitude = lampInfo.getLocation().getLatitude();
				ParamTypeOne latitudeParam = new ParamTypeOne();
				latitudeParam.setKey("lat");
				latitudeParam.setValue(String.valueOf(latitude));
				params.add(latitudeParam);
				// Longitude
				Double longitude = lampInfo.getLocation().getLongitude();
				ParamTypeOne longitudeParam = new ParamTypeOne();
				longitudeParam.setKey("lng");
				longitudeParam.setValue(String.valueOf(longitude));
				params.add(longitudeParam);
				// TODO pole type....
				ParamTypeOne poleTypeParam = new ParamTypeOne();
				poleTypeParam.setKey("pole.type");
				poleTypeParam.setValue("");
				params.add(poleTypeParam);
				// DimmingGroupName
				ParamTypeOne dimgNameParam = new ParamTypeOne();
				dimgNameParam.setKey("DimmingGroupName");
				dimgNameParam.setValue(dimmingGroupName);
				device.setParams(params);
				devices.add(device);
			});
		}
	}

}
