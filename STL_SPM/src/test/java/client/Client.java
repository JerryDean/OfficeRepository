package client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stee.spm.constant.ResponseCode;
import com.stee.spm.entity.ResultData;
import com.stee.spm.entity.SchedulingPlan;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : Street Lighting
 * File Name    : Client.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午2:49:45
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class Client {
	public static void main(String[] args) {
		System.out.println(ResponseCode.SUCCESS.getCode());
	}

	public static SchedulingPlan save() {
		RestTemplate template = new RestTemplate();
		SchedulingPlan sp = new SchedulingPlan();
		sp.setName("Plan-03");
		sp.setStatus("PLANDED");
		sp.setDimmingGroupId("0003");
		ResponseEntity<SchedulingPlan> response = template.postForEntity("http://localhost:8080/schedulingplan/save",
				sp, SchedulingPlan.class);
		return response.getBody();
	}

	public static SchedulingPlan findById() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<SchedulingPlan> response = template.getForEntity(
				"http://localhost:8080/schedulingplan/find/7cb2107a-69e4-4d0e-ba10-867d89e7897d", SchedulingPlan.class);
		return response.getBody();
	}

	public static SchedulingPlan update() {
		RestTemplate template = new RestTemplate();
		SchedulingPlan sp = new SchedulingPlan();
		sp.setId("7cb2107a-69e4-4d0e-ba10-867d89e7897d");
		sp.setName("Plan-02");
		ResponseEntity<SchedulingPlan> response = template.postForEntity("http://localhost:8080/schedulingplan/update",
				sp, SchedulingPlan.class);
		return response.getBody();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResultData<SchedulingPlan> getAll() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<ResultData> response = template.getForEntity("http://localhost:8080/schedulingplan/getall",
				ResultData.class);
		return response.getBody();
	}

	public static boolean findByName() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Boolean> response = template
				.getForEntity("http://localhost:8080/schedulingplan/searchByName?name=Plan-01", Boolean.class);
		return response.getBody();

	}

	public static void deleteById() {
		RestTemplate template = new RestTemplate();
		template.delete("http://localhost:8080/schedulingplan/delete/" + "5b580383-7366-42b4-be3a-bb67f948bf75");
	}
}
