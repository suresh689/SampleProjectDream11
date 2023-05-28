package com.dream11.android.stepDefinition;

import com.dream11.android.PageObjects.Dream11Page;
import com.dream11.android.launcher.TestHarness;
import com.dream11.android.utilities.WebUtils;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.Map;

public class Dream11Stepdefs extends TestHarness {
    Dream11Page dp;

    @When("^User enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userEnterUsernameAndPassword(String email, String password) {
        dp = new Dream11Page(driver);
        dp.signInWithValidCredentials(email, password);
    }

    @And("^clicks on login$")
    public void clicksOnLogin() {
        dp = new Dream11Page(driver);
        dp.login();
    }

    @Then("^User Select a Game As \"([^\"]*)\"$")
    public void userSelectAGameAs(String gameType) {
        dp = new Dream11Page(driver);
        dp.chooseGameType(gameType);
    }

    @And("^User Select a Match as \"([^\"]*)\"$")
    public void userSelectAMatchAs(String selectMatch){
        dp = new Dream11Page(driver);
        dp.chooseGame(selectMatch);
    }

    @Then("^User select a players As$")
    public void userSelectAPlayersAs(DataTable playerName) {
        dp = new Dream11Page(driver);
        for (Map<String, String> data : playerName.asMaps(String.class, String.class)) {
            dp.playerName(data.get("playerName"));
        }
    }

    @Then("^Then User create a Team$")
    public void thenUserCreateATeam() {
        dp = new Dream11Page(driver);
        dp.createTeam();
    }
}
