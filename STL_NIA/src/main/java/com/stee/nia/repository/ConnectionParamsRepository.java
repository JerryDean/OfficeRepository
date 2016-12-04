package com.stee.nia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.stee.sel.nia.ConnectionParams;

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
 * File Name    : ConnectionParamsRepository.java
 * Author       : Jerry
 * Created      : 2016年11月17日 下午9:02:36
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface ConnectionParamsRepository extends JpaRepository<ConnectionParams, Integer> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update ConnectionParams c set c.value = ?2 where c.key = ?1")
	int update(String key, String value);
}
