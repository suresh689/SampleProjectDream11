package com.dream11.android.runner;
import com.dream11.android.launcher.TestHarness;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
        glue = { "com.dream11.android.stepDefinition"},
        plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber.json"
        },
        monochrome = true,
        dryRun = false,
        tags = { "@Dream11"}
 )



public class CucumberJunitRunner extends  TestHarness{

    public static TestHarness th;


       @BeforeClass
        public static void before() throws Exception {
          th=new TestHarness();
           th.suiteSetUp();
       }

       @AfterClass
    public static void after(){
           th.stopTest();

       }

}