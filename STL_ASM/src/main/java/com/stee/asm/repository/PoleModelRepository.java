package com.stee.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stee.sel.asm.PoleModelConfig;

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
 * File Name    : PoleModelRepository.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午1:49:48
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface PoleModelRepository extends JpaRepository<PoleModelConfig, Integer> {
	List<PoleModelConfig> findByNameLike(String name);
}
