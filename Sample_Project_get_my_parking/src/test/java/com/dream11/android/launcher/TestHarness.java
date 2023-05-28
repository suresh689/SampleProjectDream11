package com.dream11.android.launcher;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Random;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.dream11.android.config.config;


public class TestHarness {
    static String reportPath;
    public AppDriverInstance webDriverInstance;

    public static AppiumDriver<MobileElement> driver;
    LoadConfigurations load;

    public static Properties configProperties;

    protected static Logger log = LogManager.getLogger(Logger.class.getName());

    String deviceTyep;


    @BeforeSuite
    public void suiteSetUp() throws Exception {
        log.info("load configuration files " + reportPath);
        loadconfigurations("project.properties");
        deleteScreenshots("Screenshots");
        webDriverInstance = new AppDriverInstance();
        driver = webDriverInstance.launchApp();

    }

    @BeforeClass
    public void beforeClass() throws Exception, IOException {
    }


    @BeforeMethod
    public void beforeMethod() {

    }


    @AfterMethod
    public void afterMethod() throws IOException {

    }

    @AfterSuite
    public void stopTest() {
        String reportPath = System.getProperty("user.dir") + "/TestResults/cucumber-reports/" + "TestAutomation.html";
        log.info("Report Path Location:  " + reportPath);
        //EmailReporter.Reportgeneration(reportPath);
        deviceTyep = config.getDevice();
        if (deviceTyep.equalsIgnoreCase("EMULATORANDROID")) {
            webDriverInstance.stopAppiumService();
        } else {
            driver.quit();
        }
    }

    public String loadconfigurations(String configFileName) {

        log.info("Method called for loading config file.");
        load = new LoadConfigurations();
        return load.LoadConfigurationsProperties(configFileName);

    }



    // Clean ScreenShot Directory[Files]
    public void deleteScreenshots(String fileName) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/" + fileName + "/");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }

        }
    }

    public static int getRandomNumber() {

        Random rnd = new Random();
        int id = rnd.nextInt(5000);
        return id;

    }

    /*
     * Get Current Time
     */
    public Timestamp getCurrentTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Current timestamp is: " + timestamp);
        return timestamp;
    }

}