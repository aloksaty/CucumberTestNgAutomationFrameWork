package com.alok.aut.pageObjects;

import com.alok.aut.SelenumUtilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
public class EnterHomePage {

	WebDriver driver;
	@FindBy(xpath = "//div[@class='title' and text()='Midtrans Pillow']")
	WebElement midTransPillowElement;

	public EnterHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void navigateHomePage() {


		driver.manage().deleteAllCookies();
		driver.get("https://demo.midtrans.com/");

	}

	public Boolean validateHomePage() {

			return SeleniumLib.isElemantsPresents(driver,By.xpath("//div[@class='title' and text()='Midtrans Pillow']"));

	}
}
