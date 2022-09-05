package com.alok.aut.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebElement userName;
	private WebElement Password;
	private WebElement submit;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void initObj() {
		submit = driver.findElement(By.id("kt_login_signin_submit"));
	}

	public void login() {
		submit.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
	}
	
	public boolean loginPass() {
		boolean returnValLoginPass = true;

/*		if (returnValLoginPass = .isElemantsPresents(driver, By.id("imgGo")) == true) {

			returnValLoginPass = true;
		} else {
			System.out.println(returnValLoginPass);
			returnValLoginPass = false;


		}*/

		return returnValLoginPass;
	}

	
}
