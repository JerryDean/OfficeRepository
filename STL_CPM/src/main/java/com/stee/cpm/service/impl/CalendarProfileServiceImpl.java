package com.stee.cpm.service.impl;

import com.google.common.collect.Sets;
import com.stee.cpm.dto.Daily2Draw;
import com.stee.cpm.entity.*;
import com.stee.cpm.repository.CalendarProfileRepository;
import com.stee.cpm.service.ICalendarProfileService;
import com.stee.sel.common.ResultData;
import com.stee.sel.constant.ResponseCode;
import com.stee.sel.cpm.CalendarProfile;
import com.stee.sel.cpm.SchedulingRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
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
 * Project Name : STL_CPM
 * File Name    : SchedulingPlanServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午3:38:03
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service("calendarProfileServiceImpl")
public class CalendarProfileServiceImpl implements ICalendarProfileService {
	@Autowired
	CalendarProfileRepository repository;

	@Override
	public CalendarProfile save(CalendarProfile cp) {
		cp.setCreateDate(new Date());
		cp.setStatus("PLANNED");
		return repository.save(cp);
	}

	@Override
	public String deleteById(Integer id) {
		repository.delete(id);
		return ResponseCode.SUCCESS.getCode();
	}

	@Override
	public CalendarProfile update(CalendarProfile cp) {
		cp.setUpdateTime(new Date());
		return repository.saveAndFlush(cp);
	}

	@Override
	public CalendarProfile findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public ResultData<CalendarProfile> getAll() {
		ResultData<CalendarProfile> resultData = new ResultData<>();
		List<CalendarProfile> list = repository.findAll();
		resultData.setData(list);
		return resultData;
	}

	@Override
	public boolean searchByName(String name) {
		return repository.findByName(name) == null ? false : true;
	}

	@Override
	public Calendar2Draw getCalendar2Draw(Config config) {
		if (null == config) {
			return null;
		}
		if (null == config.getCalendarId() || null == config.getStartTime() || null == config.getEndTime()) {
			return null;
		}
		CalendarProfile cp = repository.findById(config.getCalendarId());
		List<SchedulingRule> rules = cp.getRules();
		if (null == rules || rules.isEmpty()) {
			return null;
		}

		Calendar2Draw calendar2Draw = new Calendar2Draw();

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		Date endDate = null;
		Date startDate = null;
		try {
			startDate = sf.parse(config.getStartTime());
			endDate = sf.parse(config.getEndTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar startC = Calendar.getInstance();
		startC.setTime(startDate);
		startC.set(Calendar.DAY_OF_MONTH, startC.getActualMinimum(Calendar.DATE));
		Calendar endC = Calendar.getInstance();
		endC.setTime(endDate);
		endC.set(Calendar.DAY_OF_MONTH, endC.getActualMaximum(Calendar.DATE));

		List<CalendarProfile2Draw> cpList = new ArrayList<>();

		List<DailyProfiles2Draw> dpsList = new ArrayList<>();

		DailyProfiles2Draw dailyProfiles2Draw = null;
		for (; startC.compareTo(endC) <= 0;) {
			int week = startC.get(Calendar.DAY_OF_WEEK);
			int dayOfMonth = startC.get(Calendar.DAY_OF_MONTH);
			int monthOfYear = startC.get(Calendar.MONTH);
			int year = startC.get(Calendar.YEAR);

			dailyProfiles2Draw = new DailyProfiles2Draw();

			List<DailyProfile2Draw> list = new ArrayList<>();

			if (startC.getTime().before(startDate) || startC.getTime().after(endDate)) {
				dailyProfiles2Draw.setDailyProfile(list);
				dpsList.add(dailyProfiles2Draw);
				if (dayOfMonth == startC.getActualMaximum(Calendar.DATE)) {
					CalendarProfile2Draw calendarProfile2Draw = new CalendarProfile2Draw();
					calendarProfile2Draw.setMonthProfile(dpsList);
					cpList.add(calendarProfile2Draw);
					dpsList = new ArrayList<>();
				}
				startC.add(Calendar.DATE, 1);
				continue;
			}

			for (SchedulingRule rule : rules) {
				String schedulerName = rule.getSchedulerId();
				String color = "";
				Integer priority = rule.getPriority();
				switch (priority) {
				case 1:
					color = PriorityColor.P1.getLevel();
					break;
				case 2:
					color = PriorityColor.P2.getLevel();
					break;
				case 3:
					color = PriorityColor.P3.getLevel();
					break;
				case 4:
					color = PriorityColor.P4.getLevel();
					break;
				case 5:
					color = PriorityColor.P5.getLevel();
					break;
				case 6:
					color = PriorityColor.P6.getLevel();
					break;
				case 7:
					color = PriorityColor.P7.getLevel();
					break;
				}

				String recurrentPattern = rule.getRecurrentPattern();
				String[] split = recurrentPattern.split(":");
				if (split[0].equals(RecurrentPattern.DayBased.getPattern())) {
					switch (split[1]) {
					case "Mon":
						if (week == 2) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					case "Tue":
						if (week == 3) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					case "Wed":
						if (week == 4) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					case "Thur":
						if (week == 5) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					case "Fri":
						if (week == 6) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					case "Sat":
						if (week == 7) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					case "Sun":
						if (week == 1) {
							DailyProfile2Draw dp2d = new DailyProfile2Draw();
							dp2d.setName(schedulerName);
							dp2d.setColor(color);
							dp2d.setPriority(priority);
							list.add(dp2d);
						}
						break;
					}
				}
				if (split[0].equals(RecurrentPattern.DateBasedDD.getPattern())) {
					int day = Integer.parseInt(split[1]);
					if (dayOfMonth == day) {
						DailyProfile2Draw dailyProfile2Draw = new DailyProfile2Draw();
						dailyProfile2Draw.setName(schedulerName);
						dailyProfile2Draw.setColor(color);
						dailyProfile2Draw.setPriority(priority);
						list.add(dailyProfile2Draw);
					}
				}
				if (split[0].equals(RecurrentPattern.DateBasedDDMM.getPattern())) {
					String[] split2 = split[1].split("\\.");
					int day = Integer.parseInt(split2[0]);
					int month = Integer.parseInt(split2[1]);
					if (day == dayOfMonth && month == (monthOfYear + 1)) {
						DailyProfile2Draw dailyProfile2Draw = new DailyProfile2Draw();
						dailyProfile2Draw.setName(schedulerName);
						dailyProfile2Draw.setColor(color);
						dailyProfile2Draw.setPriority(priority);
						list.add(dailyProfile2Draw);
					}
				}
				if (split[0].equals(RecurrentPattern.DateBasedDDMMYYYY.getPattern())) {
					String[] split2 = split[1].split("\\.");
					int day = Integer.parseInt(split2[0]);
					int month = Integer.parseInt(split2[1]);
					int year1 = Integer.parseInt(split2[2]);
					if (day == dayOfMonth && month == (monthOfYear + 1) && year == year1) {
						DailyProfile2Draw dailyProfile2Draw = new DailyProfile2Draw();
						dailyProfile2Draw.setName(schedulerName);
						dailyProfile2Draw.setColor(color);
						dailyProfile2Draw.setPriority(priority);
						list.add(dailyProfile2Draw);
					}
				}
			}
			Collections.sort(list, new Comparator<DailyProfile2Draw>() {

				@Override
				public int compare(DailyProfile2Draw o1, DailyProfile2Draw o2) {
					return o2.getPriority() - o1.getPriority();
				}

			});
			dailyProfiles2Draw.setDailyProfile(list);
			dpsList.add(dailyProfiles2Draw);
			if (dayOfMonth == startC.getActualMaximum(Calendar.DATE)) {
				CalendarProfile2Draw calendarProfile2Draw = new CalendarProfile2Draw();
				calendarProfile2Draw.setMonthProfile(dpsList);
				cpList.add(calendarProfile2Draw);
				dpsList = new ArrayList<>();
			}
			startC.add(Calendar.DATE, 1);
		}

		calendar2Draw.setCalendarProfiles(cpList);
		return calendar2Draw;
	}

	@Override
	public void commission(CalendarProfile cp) {
		if (null == cp) {
			return;
		}
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		String url = bundle.getString("nia.rest.url");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation(url, cp);
	}

	@Override
	public Set<Daily2Draw> getCalendar2Draw(Integer calendarId) {
        Set<Daily2Draw> c2d =  Sets.newHashSet();
        if (null != calendarId && !calendarId.equals("")) {
            CalendarProfile cp = repository.findOne(calendarId);
            List<SchedulingRule> rules = cp.getRules();
            if (null != rules && !rules.isEmpty()) {
                rules.forEach(rule -> {
                    Daily2Draw daily2Draw = new Daily2Draw();

                });
            }
        }
        return null;
	}

}
