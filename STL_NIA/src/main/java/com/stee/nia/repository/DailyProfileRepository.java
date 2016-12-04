package com.stee.nia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stee.sel.dpm.DailyProfile;

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
 * File Name    : DailyProfileRepository.java
 * Author       : Jerry
 * Created      : 2016年11月30日 上午10:34:59
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface DailyProfileRepository extends JpaRepository<DailyProfile, String> {

}
