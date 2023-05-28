package com.dream11.android.stepDefinition;

import com.dream11.android.helper.LoggerHelper;
import com.dream11.android.launcher.TestHarness;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestHarness {
    Logger log = LoggerHelper.getLogger(Hooks.class);




/*@AfterStep
public void step(Scenario scenario) {


        Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));



}*/

    @After
    public void failedTest(Scenario  scenario) {


        if (scenario.isFailed()) {

            try {
                log.info(scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png"); // ... and embed it in
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                log.info(scenario.getName() + " is pass");
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}





