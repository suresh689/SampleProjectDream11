package com.dream11.android.PageObjects;

import com.dream11.android.utilities.BaseDeviceElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Dream11Page extends BaseDeviceElement {

    AppiumDriver<MobileElement> driver;

    public Dream11Page(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(id = "com.dream11.fantasy.cricket.football.kabaddi:id/2131363961")
    private MobileElement login;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(id = "//android.view.ViewGroup[@content-desc'Match_Card_']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
    private MobileElement selectMatchEle;





    public void signInWithValidCredentials(String email, String password) {

    }

    public void login() {
        login.click();
    }

    public void chooseGameType(String gameType) {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,"+gameType+")]")).click();
    }

    public void chooseGame(String selectMatch) {
        selectMatchEle.click();

    }

    public void playerName(String playerName) {
    }

    public void createTeam() {
    }
}
