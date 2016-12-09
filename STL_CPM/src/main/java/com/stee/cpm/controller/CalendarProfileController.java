package com.stee.cpm.controller;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Sets;
import com.stee.cpm.dto.Daily2Draw;
import com.stee.cpm.entity.Calendar2Draw;
import com.stee.cpm.entity.Config;
import com.stee.cpm.service.ICalendarProfileService;
import com.stee.sel.common.ResultData;
import com.stee.sel.cpm.CalendarProfile;

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
 * File Name    : SchedulingPlanController.java
 * Author       : Jerry
 * Created      : 2016年10月11日 上午11:55:34
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/calendarprofile")
public class CalendarProfileController {
	@Resource(name = "calendarProfileServiceImpl")
	ICalendarProfileService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public CalendarProfile save(@RequestBody CalendarProfile cp) {
		return service.save(cp);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable("id") Integer id) {
		return service.deleteById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CalendarProfile update(@RequestBody CalendarProfile cp) {
		return service.update(cp);
	}

	@RequestMapping(value = "/commission", method = RequestMethod.POST)
	public void commission(@RequestBody CalendarProfile cp) {
		// TODO Commission to NIA,before that get the scheduler first.
		service.commission(cp);
	}

	@RequestMapping(value = "/searchById", method = RequestMethod.GET)
	public CalendarProfile findById(@RequestParam(value = "id", required = true) Integer id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResultData<CalendarProfile> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/searchByName", method = RequestMethod.GET)
	public boolean searchByName(@RequestParam(value = "name", required = true) String name) {
		if (null != name && !name.equals("")) {
			return service.searchByName(name);
		}
		return false;
	}

	@RequestMapping(value = "/get/calendar2draw", method = RequestMethod.POST)
	public Calendar2Draw getCalendar2Draw(@RequestBody Config config) {
		return service.getCalendar2Draw(config);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	Set<Daily2Draw> demoCalendar() {
		Set<Daily2Draw> set = Sets.newHashSet();
		for (int i = 0; i < 5; i++) {
			Daily2Draw daily2Draw = new Daily2Draw();
			switch (i) {
			case 0:
				daily2Draw.setTitle("DP 00" + (i + 1));
				daily2Draw.setStart("2016-12-09");
				daily2Draw.setColor("#f8cb00");
				break;
			case 1:
				daily2Draw.setTitle("DP 00" + (i + 1));
				daily2Draw.setStart("2016-12-13");
				daily2Draw.setColor("#9b59b6");
				break;
			case 2:
				daily2Draw.setTitle("DP 00" + (i + 1));
				daily2Draw.setStart("2016-12-17");
				daily2Draw.setColor("#f3565d");
				break;
			case 3:
				daily2Draw.setTitle("DP 00" + (i + 1));
				daily2Draw.setStart("2016-12-24");
				daily2Draw.setColor("#1bbc9b");
				break;
			case 4:
				daily2Draw.setTitle("DP 00" + (i + 1));
				daily2Draw.setStart("2016-12-25");
				daily2Draw.setColor("#1bbc9b");
				break;
			}
			set.add(daily2Draw);
		}
		return set;
	}

}
