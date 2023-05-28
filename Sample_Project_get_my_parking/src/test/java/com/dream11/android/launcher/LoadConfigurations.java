package com.dream11.android.launcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.dream11.android.config.config;

public class LoadConfigurations {

	Properties configproperties;

	private static Logger log = Logger.getLogger(Logger.class.getName());

	private Properties loadConfigProperties(String configFileName) {

		return configproperties = loadProperties(System.getProperty("user.dir") + "/Resources/" + configFileName);

	}
	private Properties loadProperties(String propertyFileName) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			log.info("Reading of config file started");
			input = new FileInputStream(propertyFileName);
			prop.load(new InputStreamReader(input, "UTF-8"));

		} catch (IOException e) {
			log.error("Reading the config file failed because of IOException." + propertyFileName);
		}

		return prop;

	}

	public String LoadConfigurationsProperties(String configFileName) {

		loadConfigProperties(configFileName);

		config.setPlatform(configproperties.getProperty("platform"));
		config.setAutomationName(configproperties.getProperty("automationname"));
		config.setudid(configproperties.getProperty("udid"));
		config.setPort(configproperties.getProperty("port"));
		config.setDeviceName(configproperties.getProperty("DeviceName"));
		config.setDevice(configproperties.getProperty("Device"));
		config.setAppPackage(configproperties.getProperty("appPackage"));
		config.setAppCapacity(configproperties.getProperty("appCapacity"));

		return configproperties.getProperty("Device");
	}

}
