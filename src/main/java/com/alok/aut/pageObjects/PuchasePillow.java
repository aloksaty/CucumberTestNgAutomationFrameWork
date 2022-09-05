package com.alok.aut.pageObjects;

import com.alok.aut.IpageObjects.*;
import com.alok.aut.SelenumUtilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PuchasePillow implements IPurchase {
    WebDriver driver;
    @FindBy(xpath = "//a[@class='btn buy' and text()='BUY NOW']")
    WebElement buyButton;
    @FindBy(xpath = "//div[@class='cart-checkout' and text()='CHECKOUT']")
    WebElement checkOut;
    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    WebElement orderSummry;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@id='payment-list']//div[@class='list-title text-actionable-bold' and text()='Credit/Debit Card']")
    WebElement payments;
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement amount;
    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement cardnumber;
    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement expDate;
    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement CVV;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement payNow;
    @FindBy(xpath = "//form[@id='acsForm']//input[@id='PaRes']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit' and text()='OK']")
    WebElement submitPassword;
    @FindBy(xpath = "//div[@class='text-button-main']")
    WebElement Done;
    By buyButtonXpath = By.xpath("//a[@class='btn buy' and text()='BUY NOW']");
    By orderSummryXpath = By.id("snap-midtrans");
    By paymentsXapth=By.xpath("//div[@id='payment-list']//div[@class='list-title text-actionable-bold' and text()='Credit/Debit Card']");
    By paymentAmount= By.xpath("//span[@class='text-amount-amount']");
    By passwordXpath= By.xpath("//input[@id='PaRes']");
    By payNowXpath=By.xpath("//a[@class='button-main-content']");
    By done = By.id("//div[@class='text-button-main']");

    public PuchasePillow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public Boolean isBuyNowPresent(){
        return  SeleniumLib.isElemantsPresents(driver,buyButtonXpath);
    }
    @Override
    public Boolean clickOnBuy() {
        SeleniumLib.click(driver,buyButton);
        return SeleniumLib.isElemantsClickable(driver,checkOut);
    }

    @Override
    public Boolean checkOut() {
        SeleniumLib.click(driver,checkOut);
        return SeleniumLib.isElemantsPresents(driver,orderSummryXpath);
    }

    @Override
    public Boolean validateOrderSummery(String value) {
        SeleniumLib.SwithToFrame(driver,orderSummry);
        SeleniumLib.waitForElementpresents(driver,paymentAmount);
        return value.equalsIgnoreCase(amount.getText());

    }
    @Override
    public Boolean clickOnContinue() {
        SeleniumLib.click(driver,continueButton);
        return SeleniumLib.isElemantsPresents(driver,paymentsXapth);
    }

    @Override
    public void selectpaymentmethod() {
        SeleniumLib.click(driver,payments);
   }

    @Override
    public void fillCreditCardInfo(String cardNumber ,String expairyDate,String cvv) {
            SeleniumLib.waitForElementpresents(driver,paymentAmount);
            SeleniumLib.EnterText(cardnumber,cardNumber);
            SeleniumLib.EnterText(expDate,expairyDate);
            SeleniumLib.EnterText(CVV,cvv);
    }
    @Override
    public Boolean isPaymentDone() {
        SeleniumLib.waitForElementpresents(driver,payNowXpath);
        SeleniumLib.click(driver,payNow);
        SeleniumLib.SwithToFrame(driver,0);
        SeleniumLib.waitStatic();
        return SeleniumLib.isElemantsPresents(driver,passwordXpath);
    }

    @Override
    public void  confirmPassword() {
        SeleniumLib.EnterText(password,"112233");
        SeleniumLib.click(driver,submitPassword);
    }
    public Boolean isOredrCreated(){
        SeleniumLib.waitStatic();
        return SeleniumLib.isElemantsPresents(driver,buyButtonXpath);
    }

}
