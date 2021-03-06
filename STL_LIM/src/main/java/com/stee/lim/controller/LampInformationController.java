package com.stee.lim.controller;

import com.stee.lim.dto.DownloadFile;
import com.stee.lim.dto.GeoZoneLampInfo;
import com.stee.lim.dto.LampInfoDetail;
import com.stee.lim.service.ICalendarProfileService;
import com.stee.lim.service.IDimmingGroupService;
import com.stee.lim.service.IGeoZoneService;
import com.stee.lim.service.ILampInfoService;
import com.stee.sel.common.ResultData;
import com.stee.sel.gzm.GZone;
import com.stee.sel.lim.LampInfo;
import com.stee.sel.lim.configruation.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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
 * Project Name : STL_LIM
 * File Name    : LampInformationController.java
 * Author       : Jerry
 * Created      : 2016年10月13日 上午11:41:59
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/lampinfo")
public class LampInformationController {
	@Resource(name = "lampInfoServiceImpl")
	ILampInfoService service;

	@Autowired
    ICalendarProfileService cps;

	@Autowired
    IDimmingGroupService dgs;

	@Autowired
    IGeoZoneService gzs;

	private static boolean flag = false;

	@RequestMapping(value = "/asset/import", method = RequestMethod.POST)
	void getAssetFileList(List<String> locations) {

	}

    /**
     * 获取所有数据。
     *
     * @return
     */
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResultData<LampInfo> getAll () {
	    return service.getAll();
    }

	/**
	 * 获取过滤后的分页数据。
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/get/all/byfilter", method = RequestMethod.GET)
	public Page<LampInfo> getAllByFilter(@RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "addr",required = false) String addr,
                                 @RequestParam(name = "gzId",required = false) String gzId,
                                 @RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		return service.getAllByFilter(pageNo, pageSize, name, addr, gzId);
	}

	@RequestMapping(value = "/query/filters", method = RequestMethod.POST)
	public ResultData<LampInfo> queryByFilter() {
	    return null;
    }

	/**
	 * 更新Lamp信息。
	 * 
	 * @param info
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public LampInfo update(@RequestBody LampInfo info) {
        LampInfo lampInfo = service.update(info);
        System.out.println(lampInfo);
        return lampInfo;
	}

	/**
	 * 删除Lamp.
	 * 
	 * @param id
	 * @author Jerry
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

	/**
	 * 更新Lamp 经纬度。
	 * 
	 * @param map
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/geozone/devices", method = RequestMethod.POST)
	public String receiveDevices(@RequestBody Map<String, String> map) {
		// Key: DeviceId Value:GeozoneId
		System.out.println(map);
		return service.updateGz(map);
	}

	/**
	 * 获取所有Lamp经纬度。 *大数据量，考虑性能问题。
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/geozone/get/all", method = RequestMethod.GET)
	public ResultData<GeoZoneLampInfo> getAllForGz() {
		ResultData<LampInfo> all = service.getAll();
		List<GeoZoneLampInfo> list = new ArrayList<>();
		try {
				all.getData().forEach(t -> {
					String id = t.getId();
					Location location = t.getLocation();
					list.add(new GeoZoneLampInfo(id, location));
				});
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultData<GeoZoneLampInfo> resultData = new ResultData<>();
		resultData.setData(list);
		return resultData;
	}

	/**
	 * 删除指定GeoZone中的设备（仅将LampInfo 对应字段置空）
	 * 
	 * @param geoZoneId
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/geozone/delete/{id}", method = RequestMethod.DELETE)
	public String deleteByGz(@PathVariable("id") String geoZoneId) {
		return service.deleteByGgz(geoZoneId);
	}

	/**
	 * 获取设备状态是否发生改变。(暂) -- 后改WebSocket 全双工。
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/statusof/update", method = RequestMethod.GET)
	public boolean fetchStatus() {
		return flag;
	}

	/**
	 * 更新轮询后的实时设备状态。
	 * 
	 * @param list
	 * @author Jerry
	 */
	@RequestMapping(value = "/polling/update", method = RequestMethod.POST)
	public void updatePolling(@RequestBody List<LampInfo> list) {
		service.updatePolling(list);
		flag = !flag;
	}

	/**
	 * 获取某GeoZone 里面的所有LampInfo
	 * 
	 * @param geoZoneId
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/get/lamps/byGeoZoneId/{id}", method = RequestMethod.GET)
	public List<LampInfo> getByGeoZoneId(@PathVariable("id") String geoZoneId) {
		return service.getByGeoZoneId(geoZoneId);
	}

	/**
	 * 资产导入
	 * 
	 * @param file
	 * @author Jerry
	 */
	@RequestMapping(value = "/upload/asset", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, method = RequestMethod.POST)
	void uploadAsset(@RequestParam("fileUpload") CommonsMultipartFile file) {
		// TODO Implement indeed.
	}

	/**
	 * 资产导出
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/download/assets", method = RequestMethod.GET)
	List<DownloadFile> downloadAssets() {
		// TODO Implement indeed.
		return null;
	}

    /**
     * 判断id是否已经存在
     *
     * @param id
     * @return
     */
	@RequestMapping(value = "/isIdExits", method = RequestMethod.GET)
	boolean isIdExits(@RequestParam(value = "id") String id){
	    return service.isIdExits(id);
    }

    /**
     * 获取Calendar Profile 的Name的集合
     *
     * @return
     */
    @RequestMapping(value = "/calendar/profiles/name/list", method = RequestMethod.GET)
    List<String> getCalendarProfileIds () {
	    return cps.getCalendarProfileIds();
    }

    /**
     * 获取DimmingGroup 的Name的集合
     *
     * @return
     */
    @RequestMapping(value = "/dimming/groups/name/list", method = RequestMethod.GET)
    List<String> getDimmingGroupIds() {
        return dgs.getDimmingGroupIds();
    }

    /**
     * 获取GeoZone 的Name的集合
     *
     * @return
     */
    @RequestMapping(value = "/geozones/name/list", method = RequestMethod.GET)
    List<String> getGeoZoneIds() {
        return gzs.getGeoZoneIds();
    }

    /**
     * 通过名字获取GZone
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/geozone/findByName", method = RequestMethod.POST)
    GZone findGZoneByName(@RequestBody String name) {
        return gzs.findGZoneByName(name);
    }

    /**
     * 通过ID获取灯的详细信息
     *
     * @param id
     * @return
     */
	@RequestMapping(value = "/find/byid/detail", method = RequestMethod.GET)
    LampInfoDetail findLampDetailInfo(@RequestParam(name = "id") String id) {
        return service.findLampDetailInfo(id);
    }

}
