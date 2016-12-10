package com.stee.sl.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PropertiesUtils {
	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PropertiesUtils.class.getName());
	private static ConcurrentHashMap<String, Properties> pptContainer = new ConcurrentHashMap<String, Properties>();

	public static void writeProperties(String filePath, String parameterName,
			String parameterValue) {
		Properties prop = new Properties();
		OutputStream fos = null;
		try {
			InputStream fis = new FileInputStream(filePath);

			prop.load(fis);
			fis.close();
			fos = new FileOutputStream(filePath);
			prop.setProperty(parameterName, parameterValue);

			prop.store(fos,"System created. Date:" + new Date().toString());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			logger.warning("Write properties error:" + e.getMessage());
		}
	}

	public static Map<String, String> readProperties(String fileName) {
		Map<String, String> proMap = new HashMap<String, String>();
		Properties props = getPprVue(fileName);
		try {
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				proMap.put(key, props.getProperty(key));
			}
		} catch (Exception e) {
			//throw new RuntimeException(String.format("Read propertires [%s] error.", fileName,e.getMessage()));
			logger.warning("Read properties error. Please check this file. {}" + fileName);
		}
		return proMap;
	}

	public static Map<String, String[]> readVideoProperties(String fileName) {
		Map<String, String[]> proMap = new HashMap<String, String[]>();
		Properties props = getPprVue(fileName);
		try {
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				proMap.put(key, props.getProperty(key).split(","));
			}
		} catch (Exception e) {
			logger.warning("Read video propertires error:"
					+ e.getMessage());
		}
		return proMap;
	}

	private static Properties loadPropertyFileByFileSystem(
			String propertyFilePath) {
		try {
			Properties ppts = new Properties();
			FileInputStream is = new FileInputStream(propertyFilePath);
			ppts.load(is);
			is.close();
			return ppts;
		} catch (FileNotFoundException e) {
			logger.warning("FileInputStream(\"" + propertyFilePath
					+ "\")! FileNotFoundException: " + e);
			return null;
		} catch (IOException e) {
			logger.warning("Properties.load(InputStream)! IOException: " + e);
		}
		return null;
	}

	public static Properties getPprVue(String properName) {
		if (properName == null) {
			logger.info("Properties' name is null!");
			return null;
		}
		Properties ppts = pptContainer.get(properName);
		if (ppts == null) {
			ppts = getProperties(properName);
			if (ppts != null) {
				pptContainer.put(properName, ppts);
			}
		}
		return ppts;
	}

	public static Properties getProperties(String properName) {
		InputStream inputStream = PropertiesUtils.class.getClassLoader()
				.getResourceAsStream(properName);
		if (inputStream == null) {
			return loadPropertyFileByFileSystem(properName);
		}
		Properties prop = new Properties();
		try {
			prop.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			logger.warning(e.getMessage());
		}
		return prop;
	}
	public static Map<String,String> reloadProperties(String fileName){
		pptContainer.remove(fileName);
		return readProperties(fileName);
	}
	
	public static Map<String, String[]> reloadPropertiesToArray(String fileName){
		Map<String, String[]> proMap = new HashMap<String, String[]>();
		pptContainer.remove(fileName);
		Properties props = getPprVue(fileName);
		try {
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				proMap.put(key, props.getProperty(key).split(","));
			}
		} catch (Exception e) {
			logger.warning("Read video propertires error:" + e.getMessage());
		}
		return proMap;
	}
}