package com.stee.cctv.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stee.cctv.dao.EqtInfoExtendRepository;
import com.stee.cctv.dao.EqtInfoRepository;
import com.stee.cctv.entity.EquipmentInfo;
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
public class SpringDataTest {

	private ApplicationContext ctx = null;

	{
		ctx = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void testJPA() {

	}

	@Test
	public void testEqtInfoExtend() {
		EqtInfoExtendRepository extendRepo = ctx.getBean(EqtInfoExtendRepository.class);
		List<EquipmentInfoExtend> extendList = extendRepo
				.getEqtExtendByIdInAndUuidNotNull(Arrays.asList("G5601011030314", "G561101011030092"));
		System.out.println(extendList);
	}

	@Test
	public void testEqtInfo() {
		EqtInfoRepository eqtInfoRepository = ctx.getBean(EqtInfoRepository.class);
		List<EquipmentInfo> list = eqtInfoRepository.getEQTInfoByDeviceType(3);
		System.out.println("库存CCTV设备数量:" + list.size());
	}

	@Test
	public void testAll() {
		EqtInfoRepository eqtInfoRepository = ctx.getBean(EqtInfoRepository.class);
		List<EquipmentInfo> list = eqtInfoRepository.getEQTInfoByDeviceType(3);
		List<String> idList = new ArrayList<>();
		for (EquipmentInfo info : list) {
			idList.add(info.getId());
		}
		EqtInfoExtendRepository extendRepo = ctx.getBean(EqtInfoExtendRepository.class);
		List<EquipmentInfoExtend> extendList = extendRepo.getEqtExtendByIdInAndUuidNotNull(idList);
		System.out.println(extendList);
	}

}
