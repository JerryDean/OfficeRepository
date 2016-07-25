package com.stee.cctv.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stee.cctv.dao.EquipmentExtendRepository;
import com.stee.cctv.dao.SnapDeviceRepository;

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
	public void testSnapDevice() {
		SnapDeviceRepository snapDeviceRepository = ctx.getBean(SnapDeviceRepository.class);
		System.out.println(snapDeviceRepository.findAll());
	}

	@Test
	public void testEquipmentExtend() {
		EquipmentExtendRepository repository = ctx.getBean(EquipmentExtendRepository.class);
		System.out.println(repository.findByGuid("1023fe4767cd4381b486a60550d96046"));
	}

}
