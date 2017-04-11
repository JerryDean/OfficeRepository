package com.stee.nia.repository;

import com.stee.sel.cpm.CalendarProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jerry on 2017/2/14.
 */
/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : nia
 * File Name    : CalendarProfileRepository
 * Author       : Jerry
 * Created      : 2017/2/14 17:51
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public interface CalendarProfileRepository extends JpaRepository<CalendarProfile, Integer> {

}
