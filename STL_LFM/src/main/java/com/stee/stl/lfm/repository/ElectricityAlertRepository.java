package com.stee.stl.lfm.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.stee.sel.lfm.ElectricAlertInfo;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_LFM
 * File Name    : ElectricityAlertRepository.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午2:31:03
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface ElectricityAlertRepository
		extends JpaSpecificationExecutor<ElectricAlertInfo>, PagingAndSortingRepository<ElectricAlertInfo, Integer> {

}
