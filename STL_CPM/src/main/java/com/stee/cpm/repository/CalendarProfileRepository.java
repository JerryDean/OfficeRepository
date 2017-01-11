package com.stee.cpm.repository;

import com.stee.sel.cpm.CalendarProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
 * File Name    : SchedulingPlanRepository.java
 * Author       : Jerry
 * Created      : 2016年10月11日 下午4:10:51
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface CalendarProfileRepository extends JpaRepository<CalendarProfile, Integer> {

	CalendarProfile findById(Integer id);

	CalendarProfile findByName(String name);

	List<CalendarProfile> findByNameLike(String name);

}
