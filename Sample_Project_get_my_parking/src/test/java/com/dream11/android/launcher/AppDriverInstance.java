package com.dream11.android.launcher;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import com.dream11.android.config.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static org.junit.Assume.assumeThat;

public class AppDriverInstance {
	public AppiumDriver<MobileElement> driver;
	DesiredCapabilities capabilities;
	private AppiumDriverLocalService service;
	private static Logger log = LogManager.getLogger(Logger.class.getName());
	Map<String,String> deviceEmulation = new HashMap<String, String>();



	public AppiumDriver<MobileElement> launchApp() throws InterruptedException, IOException {
		DesiredCapabilities ds= new DesiredCapabilities();
		String deviceTyep = config.getDevice();
		switch (deviceTyep.toUpperCase()) {
			case "EMULATORANDROID":
				log.info("Launching mobile device - test execution");
				System.out.println("Start appium service");
//				this.startAppiumServiceForMobileChrome();
				ds.setJavascriptEnabled(true);
				ds.acceptInsecureCerts();
				ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
				ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
				ds.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
				ds.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY,true);
				ds.setCapability("platformName", "Android");
				ds.setCapability("deviceName", "Android");
				ds.setCapability("automationName", "UiAutomator2");
				ds.setCapability("platformVersion","10");
//				ds.setCapability("appPackage", "com.android.vending");
//				ds.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
				ds.setCapability("appPackage", "com.dream11.fantasy.cricket.football.kabaddi");
				ds.setCapability("appActivity", "com.app.dream11.login.LoginSelectionActivity");
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
						ds);
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				break;

			default:
				log.info("Invalid input");
				driver.quit();
		}
		log.info("");
		return driver;

	}

	public void startAppiumServiceForMobileChrome() throws IOException, InterruptedException {
		Integer port1=Integer.parseInt(config.getPort());
		service = AppiumDriverLocalService

				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withIPAddress("127.0.0.1").usingPort(port1).withLogFile(new File("/tmp/AppiumLogs.txt")).withArgument(() -> "--allow-insecure","chromedriver_autodownload"));
		service.start();
		Thread.sleep(1000);
	}

	public void stopAppiumService() {
		service.stop();
	}
}
