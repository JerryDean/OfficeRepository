/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : cpm
 * File Name    : Calendar2Draw
 * Author       : Jerry
 * Created      : 2016/12/12
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
package com.stee.cpm.dto;

import java.util.List;
import java.util.Set;

/**
 * Created by SerryMiano on 2016/12/12.
 */
public class Calendar2Draw2 {
    private String startDate;
    private String endDate;
    private Set<Daily2Draw> d2ds;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Set<Daily2Draw> getD2ds() {
        return d2ds;
    }

    public void setD2ds(Set<Daily2Draw> d2ds) {
        this.d2ds = d2ds;
    }

    @Override
    public String toString() {
        return "Calendar2Draw2{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", d2ds=" + d2ds +
                '}';
    }
}
