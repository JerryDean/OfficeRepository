package com.stee.lim.controller;

import com.stee.lim.dto.DownloadFile;
import com.stee.lim.dto.GeoZoneLampInfo;
import com.stee.lim.service.ILampInfoService;
import com.stee.sel.common.ResultData;
import com.stee.sel.lim.LampInfo;
import com.stee.sel.lim.configruation.Location;
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

	private static boolean flag = false;

	@RequestMapping(value = "/asset/import", method = RequestMethod.POST)
	void getAssetFileList(List<String> locations) {

	}

	/**
	 * 获取所有LampInfo信息，列表展示 *待分页
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResultData<LampInfo> getAll() {
		return service.getAll();
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
	public String update(@RequestBody LampInfo info) {
		return service.update(info);
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
}
