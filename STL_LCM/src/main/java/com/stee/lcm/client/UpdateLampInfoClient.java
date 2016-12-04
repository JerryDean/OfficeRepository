package com.stee.lcm.client;

import java.util.ResourceBundle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stee.sel.lcm.ConfigCommand;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_LCM
 * File Name    : UpdateLampInfoClient.java
 * Author       : Jerry
 * Created      : 2016年10月17日 上午10:30:53
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class UpdateLampInfoClient {
	private static String serverUri;

	{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		serverUri = rb.getString("nia_rest_url");
	}

	private static RestTemplate template = new RestTemplate();

	public String sendCommand(ConfigCommand cc) {
		ResponseEntity<String> postForEntity = template.postForEntity(serverUri, cc, String.class);
		return postForEntity.getBody();
	}

}
