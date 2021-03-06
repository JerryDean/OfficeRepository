package com.stee.cpm.controller;

import com.google.common.collect.Maps;
import com.stee.cpm.dto.CalendarToDraw;
import com.stee.cpm.service.ICalendarProfileService;
import com.stee.sel.common.ResultData;
import com.stee.sel.cpm.CalendarProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
    public Map<String, String> deleteById(@PathVariable("id") Integer id) {
        Map<String, String> map = Maps.newHashMap();
        map.put("status", service.deleteById(id));
        return map;
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

    @RequestMapping(value = "/name/like", method = RequestMethod.GET)
    ResultData<CalendarProfile> findByNameLike(@RequestParam(name = "name", required = false) String name) {
        return service.findByNameLike(name);
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.GET)
    public boolean searchByName(@RequestParam(value = "name", required = true) String name) {
        if (null != name && !name.equals("")) {
            return service.searchByName(name);
        }
        return false;
    }

//    @RequestMapping(value = "/get/calendar2draw", method = RequestMethod.POST)
//    public Calendar2Draw getCalendar2Draw(@RequestBody Config config) {
//        return service.getCalendar2Draw(config);
//    }

    @RequestMapping(value = "/get/calendar2draw", method = RequestMethod.GET)
    CalendarToDraw getCalendar2Draw (@RequestParam("calendarId") Integer calendarId) {
        return service.getCalendar2Draw(calendarId);
    }


}
