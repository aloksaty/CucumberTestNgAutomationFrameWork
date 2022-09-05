package com.alok.aut.StepDef;

import com.alok.aut.IpageObjects.*;
import com.alok.aut.SelenumUtilities.*;
import com.alok.aut.pageObjects.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.testng.*;
public class StepDefPerchese {
    WebDriver driver = BrowserDriver.getDriver();
    IPurchase purchase;
    @Given("Product link page with Buy now options")
    public void productLinkPageWithBuyNowOptions() {
        purchase= new PuchasePillow(driver);
        Assert.assertTrue(purchase.isBuyNowPresent());

    }
    @When("User click on Buy Now ,He should to be prompted to checkout")
    public void userClickOnBuyNowHeShouldToBePromptedToCheckout() {

              Assert.assertTrue(purchase.clickOnBuy());

    }
    @And("When user click on checkout button order summary frame should be displayed with correct price \"(.+)\"$")
    public void whenUserClickOnCheckoutButtonOrderSummaryFrameShouldBeDisplayedWithCorrectPriceValue(String value) {

        purchase.checkOut();
        Assert.assertTrue(purchase.validateOrderSummery(value));

    }


    @And("User click on ContinueButton for Payment")
    public void userClickOnContinueButtonForPayment() {
          purchase.clickOnContinue();
    }


    @And("User Select credit card as the payments method")
    public void userSelectCreditCardAsThePaymentsMethod() {
        purchase.selectpaymentmethod();
    }

  /*  @Then("User should prompt to fill the card details As \"(.+)\"$ \"(.+)\"$ \"(.+)\"$")
    public void userShouldPromptToFillTheCardDetailsAsCardNumberExpireDateAndCVV(String cardNumber,String expDate,String cvv) {


    }*/
    @Then("User should prompt to fill the card details As (.*?),(.*?) and (.*?)$")
    public void userShouldPromptToFillTheCardDetailsAsCardNumberExpireDateCVV(String cardNumber,String expDate,String cvv) {

            purchase.fillCreditCardInfo(cardNumber,expDate,cvv);
    }

    @And("User Clicks on PayNow Button to continue")
    public void userClicksOnPayNowButtonToContinue() {

       purchase.isPaymentDone();
    }

    @Then("User should prompt to fill the password or OTP and click on pay now button")
    public void userShouldPromptToFillThePasswordOrOTP() {
        purchase.confirmPassword();

    }
    @And("Order should be placed with done message")
    public void orderShouldBePlacedWithDoneMessage() {
        Assert.assertTrue(purchase.isOredrCreated());
    }



}
