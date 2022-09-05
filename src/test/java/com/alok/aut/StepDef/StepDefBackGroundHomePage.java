package com.alok.aut.StepDef;

import com.alok.aut.SelenumUtilities.*;
import com.alok.aut.pageObjects.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.testng.*;
public class StepDefBackGroundHomePage {
    WebDriver driver = BrowserDriver.getDriver();
    EnterHomePage enterHomePage;

    @Given("User navigate to the Home page")
    public void userNavigateToTheHonePage() {
        enterHomePage= new EnterHomePage(driver);
        enterHomePage.navigateHomePage();

    }

    @Then("He should be able open the correct page")
    public void iShouldBeLoggedIn() {
        Assert.assertTrue(enterHomePage.validateHomePage());
    }


}
