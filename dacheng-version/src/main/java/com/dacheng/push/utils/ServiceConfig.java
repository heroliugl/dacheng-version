package com.dacheng.push.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * service.properties
 * 
 * @author 陈照华
 * @date 2012-9-22
 * @description
 */

public class ServiceConfig {

	/** 配置类实例 */
	private static ServiceConfig config = null;

	private Properties props = new Properties();

	/**
	 * 获取配置类的一个实例
	 * 
	 * @return Config
	 */
	public synchronized static ServiceConfig getInstance() {
		if (ServiceConfig.config == null) {
			ServiceConfig.config = new ServiceConfig();
			ServiceConfig.config.init();
		}
		return ServiceConfig.config;
	}

	private void init() {
		try {
			props.load(this.getClass().getClassLoader()
					.getResourceAsStream("service.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 根据键获取值
	 * 
	 * @param key
	 *            String
	 * @return String
	 */
	public String getValue(String key) {
		return props.getProperty(key);
	}

	/**
	 * 设置键-值
	 * 
	 * @param key
	 *            String
	 * @param value
	 *            String
	 */
	public void setValue(String key, String value) {
		props.setProperty(key, value);
	}
	
}
