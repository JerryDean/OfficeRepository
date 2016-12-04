package com.stee.nia.adaptor;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
 * File Name    : Adaptor.java
 * Author       : Jerry
 * Created      : 2016年10月18日 上午11:21:58
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class Adaptor {
	public static String beanToXml(Object obj) {
		StringWriter xml = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");

			marshaller.marshal(obj, xml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xml.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml, Class<T> clazz) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller createUnmarshaller = context.createUnmarshaller();
			t = (T) createUnmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}
