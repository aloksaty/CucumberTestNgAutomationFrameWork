package com.alok.aut.SelenumUtilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumLib {



	public static boolean  isElemantsPresents(WebDriver driver, By by) {

		boolean isElementsPresents = true;

		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {

			isElementsPresents = false;
			e.getMessage();
			return false;
		} finally {

			//(10, TimeUnit.SECONDS);

		}


	}

	public static boolean  isElemantsClickable(WebDriver driver,WebElement element) {

		boolean isElemantsClickable = true;
		long starttime = System.currentTimeMillis();
		long timeTOload =System.currentTimeMillis();
		long timeOut = Constants.implicitWait*1000;
		while(starttime - timeTOload<=timeOut){
			try{
				(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
				Thread.sleep(500);
				return  true;
		}catch (Exception e){

				System.out.println("Searching..");
			}
		}
		return false;
	}

	public static WebElement findById(WebDriver driver,String element){

			return driver.findElement(By.id(element));
	}
	public static WebElement findByXpath(WebDriver driver,String element){

		return driver.findElement(By.xpath(element));
	}
	public static WebElement findByName(WebDriver driver,String element){

		return driver.findElement(By.name(element));
	}
	public static WebElement findByClassName(WebDriver driver,String element){

		return driver.findElement(By.className(element));
	}
	public static void click(WebDriver driver,WebElement element) {
		try {
				(new WebDriverWait(driver, Constants.timeout)).until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			}catch(	StaleElementReferenceException sere) {
				// simply retry finding the element in the refreshed DOM
				sere.printStackTrace();
			}
		}

	public static void EnterText(WebElement Element,String value)
	{
			Element.clear();
			Element.sendKeys(value);

	}
	public static void Click(WebDriver driver, String element,String elementtype)
	{
		if (elementtype.equalsIgnoreCase("Id"))
			driver.findElement(By.id(element)).click();
		if (elementtype.equalsIgnoreCase("name"))
			driver.findElement(By.name(element)).click();
		if (elementtype.equalsIgnoreCase("xpath"))
			driver.findElement(By.xpath(element)).click();
	}
	public static void MouseOver(WebDriver driver, String element,String elementtype){
		if (elementtype.equalsIgnoreCase("Id")) {
			Actions actObj = new Actions(driver);
			actObj.moveToElement(driver.findElement(By.id(element))).build().perform();
		}
		if (elementtype.equalsIgnoreCase("xpath")) {
			Actions actObj = new Actions(driver);
			actObj.moveToElement(driver.findElement(By.name(element))).build().perform();
		}
	}
	public static void MouseOverAndClick(WebDriver driver, String element,String elementtype){
		if (elementtype.equalsIgnoreCase("Id")) {
			Actions actObj = new Actions(driver);
			actObj.moveToElement(driver.findElement(By.id(element))).click().build().perform();
		}
		if (elementtype.equalsIgnoreCase("xpath")) {
			Actions actObj = new Actions(driver);
			actObj.moveToElement(driver.findElement(By.xpath(element))).click().build().perform();
		}
		if (elementtype.equalsIgnoreCase("name")) {
			Actions actObj = new Actions(driver);
			actObj.moveToElement(driver.findElement(By.name(element))).click().build().perform();
		}
	}

	public static void SelectByVisibleText(WebElement WE, String VisibleText){
		Select selObj=new Select(WE);
		selObj.selectByVisibleText(VisibleText);
	}

	//select the dropdown using "select by index", so pass IndexValue as '2'
	public static void SelectByIndexValue(WebElement WE, int IndexValue){
		Select selObj=new Select(WE);
		selObj.selectByIndex(IndexValue);
	}

	//select the dropdown using "select by value", so pass Value as 'thirdcolor'
	public static void SelectByValue(WebElement WE, String Value){
		Select selObj=new Select(WE);
		selObj.selectByValue(Value);
	}

	public WebElement findVisibleElement(WebDriver driver,By locator) {

		WebElement element = new WebDriverWait(driver, Constants.timeout)
				.until( ExpectedConditions.visibilityOfElementLocated (locator));
		return element;
	}

	public WebElement findClickableElement(WebDriver driver,By locator) {
		WebElement element = new WebDriverWait(driver, Constants.timeout)
				.until( ExpectedConditions.elementToBeClickable (locator));
		return element;
	}

	public WebElement findHiddenElement(WebDriver driver,By locator) {
		WebElement element = new WebDriverWait(driver,Constants.timeout)
				.until(ExpectedConditions.presenceOfElementLocated (locator));
		return element;
	}
	public static void implicitWaitTimeOut(WebDriver driver){

		driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);

	}
	public static String getText(WebElement element){
		return element.getText();

	}

	public static void scrollUpJavaScript(WebDriver driver){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}
	public static void scrollDownJavaScript(WebDriver driver){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	public static void scrollXYCoordinatesJavaScript(WebDriver driver,int x, int y){

		JavascriptExecutor javScriptExecutor = (JavascriptExecutor) driver;
		javScriptExecutor.executeScript("window.scrollBy(" + x + ", " + y + ");");
	}
	public static void scrollOnElements(WebDriver driver,WebElement element){

		JavascriptExecutor javScriptExecutor = (JavascriptExecutor) driver;
		javScriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	public static void ScrollHorizontally(WebDriver driver,WebElement element)

	{

		JavascriptExecutor javScriptExecutor = (JavascriptExecutor) driver;
		javScriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);

	}
	public static void SwithToFrame(WebDriver driver, String frameName)

	{

			driver.switchTo().frame(frameName);

	}
	public static void SwithToFrame(WebDriver driver, int number)

	{

		driver.switchTo().frame(number);

	}
	public static void SwithToFrame(WebDriver driver, WebElement element)

	{

		driver.switchTo().frame(element);

	}
	public static void SwithToDefaultFrame(WebDriver driver, WebElement element)

	{

		driver.switchTo().defaultContent();


	}
	public static void SwithToParentFrame(WebDriver driver, WebElement element)

	{

		driver.switchTo().parentFrame();


	}
	public static void waitForElementpresents(WebDriver driver,By locator){

		WebDriverWait wait = new WebDriverWait(driver,Constants.timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public static void waitForElementIsVisible(WebDriver driver,By locator){

		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void waitStatic()  {

		try {
			Thread.sleep(13000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
