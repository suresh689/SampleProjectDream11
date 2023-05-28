package com.dream11.android.config;

public class config {
	private static String automationName;
	private static String platform;

	private static String udid;

	private static String port;

	private static String deviceName;

	private static String device;

	public static String getAppPackage() {
		return appPackage;
	}

	public static void setAppPackage(String appPackage) {
		config.appPackage = appPackage;
	}

	public static String getAppCapacity() {
		return appCapacity;
	}

	public static void setAppCapacity(String appCapacity) {
		config.appCapacity = appCapacity;
	}

	private static String appPackage;

	private static String appCapacity;


	public static String getDeviceName() {
		return deviceName;
	}

	public static void setDeviceName(String deviceName) {
		config.deviceName = deviceName;
	}

	public static String getDevice() {
		return device;
	}

	public static void setDevice(String device) {
		config.device = device;
	}



	public static String getAutomationName() {
		return automationName;
	}

	public static void setAutomationName(String automationName) {
		config.automationName = automationName;
	}


	public static String getPlatform() {
		return platform;
	}

	public static void setPlatform(String platform) {
		config.platform = platform;
	}

	public static String getPort() {
		return port;
	}
	public static void setPort(String Port) {
		config.port = Port;
	}

	public static String getUdid() {
		return udid;
	}


	public static void setudid(String udid) {
		config.udid = udid;
	}

}
