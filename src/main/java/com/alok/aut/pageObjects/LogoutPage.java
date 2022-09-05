package com.alok.aut.pageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	private WebDriver driver;
	private WebElement userAccount;
	private WebElement logOutButton;
	public  LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void initObj() {
	}
	public void logOut() {
	    driver.findElement(By.id("Attuneheader_lblRoleDes")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Help Video'])[1]/following::i[1]")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();

	}


	
	public boolean logOutPass() {

		boolean returnVal = true;

		/*if (returnVal = IsElementPresentClass.isElemantsPresents(driver, By.id("imgGo")) == true) {
			
			return true;
		} else {
			return false;
		}*/
		return false;

	}

	
}
