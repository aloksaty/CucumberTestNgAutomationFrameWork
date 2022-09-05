package com.alok.aut.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoard {

	private WebDriver driver;
	private WebElement HomeButton;
	public DashBoard(WebDriver driver) {
		
		this.driver = driver;
		
		
		
	}

	public void validatethehomeButton() {
		

		//Assert.assertTrue(SeleniumLib.isElemantsPresents(driver, By.xpath("//i[@ng-reflect-ng-class='vicon-home']")));
		 
	}
	
	public void VendorsByGeography(){
		
		//Assert.assertTrue(IsElementPresentClass.isElemantsPresents(driver, By.xpath("//h3[text()='Vendors By Geography']")));

	}

	public void VendorsByRisk(){
		
		//Assert.assertTrue(IsElementPresentClass.isElemantsPresents(driver, By.xpath("//h3[text()='Vendors By Risk']")));

	}

	public void TasksByDaysInQueue(){
		
		//Assert.assertTrue(IsElementPresentClass.isElemantsPresents(driver, By.xpath("//h3[text()='Tasks By Days In Queue']")));

	}
	

}
