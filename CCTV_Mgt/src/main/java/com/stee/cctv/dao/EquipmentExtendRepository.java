package com.stee.cctv.dao;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import com.stee.cctv.entity.EquipmentInfoExtend;

/**
 * Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD All rights
 * reserved.
 *
 * This software is confidential and proprietary property of ST Electronics
 * Info-comm Systems PTE. LTD. The user shall not disclose the contents of this
 * software and shall only use it in accordance with the terms and conditions
 * stated in the contract or licence agreement with ST Electronics Info-comm
 * Systems PTE. LTD.
 *
 * @author Jerry
 * @version 1.0
 *
 */
@Component("EquipmentExtendRepository")
public interface EquipmentExtendRepository extends Repository<EquipmentInfoExtend, String> {
	EquipmentInfoExtend findByGuid(String guid);
}
