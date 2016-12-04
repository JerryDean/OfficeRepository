package com.stee.nia.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
 * File Name    : PropertiesUtils.java
 * Author       : Jerry
 * Created      : 2016年11月16日 下午10:29:18
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class PropertiesUtils {
	/**
	 * 根据KEY，读取文件对应的值
	 * 
	 * @param filePath
	 *            文件路径，即文件所在包的路径，例如：java/util/config.properties
	 * @param key
	 *            键
	 * @return key对应的值
	 */
	public static String readData(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
			props.load(in);
			in.close();
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取指定Properties文件,所有键值对
	 * 
	 * @param filePath
	 * @return
	 * @author Jerry
	 */
	public static Map<String, String> readWhole(String filePath) {
		Map<String, String> map = new HashMap<>();
		Properties props = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
			props.load(in);
			in.close();
			props.forEach((k, v) -> {
				map.put(String.valueOf(k), String.valueOf(v));
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	/**
	 * 修改或添加键值对 如果key存在，修改, 反之，添加。
	 * 
	 * @param filePath
	 *            文件路径，即文件所在包的路径，例如：java/util/config.properties
	 * @param key
	 *            键
	 * @param value
	 *            键对应的值
	 */
	public static void writeData(String filePath, String key, String value) {
		Properties prop = new Properties();
		try {
			InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
			prop.load(fis);
			// 一定要在修改值之前关闭fis
			fis.close();
			OutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/" + filePath);
			prop.setProperty(key, value);
			// 保存，并加入注释
			prop.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating " + value + " value error");
		}
	}

}
