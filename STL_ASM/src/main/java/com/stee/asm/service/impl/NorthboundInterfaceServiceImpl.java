package com.stee.asm.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.stee.asm.service.INorthboundInterfaceConfigService;
import com.stee.asm.utils.ResourceFetchingUtils;
import com.stee.sel.constant.ResponseCode;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_ASM
 * File Name    : NorthboundInterfaceServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年11月16日 下午9:42:09
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class NorthboundInterfaceServiceImpl implements INorthboundInterfaceConfigService {

	@Override
	public String doConfig(String json) {
		Map<String, String> map;
		try {
			Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
			map = gson.fromJson(json, new TypeToken<Map<String, String>>() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			}.getType());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return ResponseCode.ERROR_PARAM.getCode();
		}
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = ResourceFetchingUtils.getValue("nia.rest.url.set");
			String postForObject = restTemplate.postForObject(url, map, String.class);
			if (postForObject.equals(ResponseCode.SUCCESS.getCode())) {
				return ResponseCode.SUCCESS.getCode();
			} else {
				return ResponseCode.FAILED.getCode();
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return ResponseCode.FAILED.getCode();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> fetchConfig() {
		Map<String, String> map = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			map = restTemplate.getForObject(ResourceFetchingUtils.getValue("nia.rest.url.fetch"), Map.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return map;
	}

}
