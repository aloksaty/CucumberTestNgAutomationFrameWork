package com.alok.aut.SelenumUtilities;
import com.alok.aut.project.Util.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class DriverListener implements WebDriverEventListener {


	public DriverListener(BrowserDriver b, WebDriver driver) {
		Log.info("[Action]" + "Browser invoke:" + b.toString());

	}

	public DriverListener(String browserName, WebDriver driver) {

		Log.info("[Action]" + "Browser invoke:" + browserName);
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {

		Log.info("[Action]" + "data value point to " + element.getAttribute("name") + ", value"
				+ element.getAttribute("value") + element.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', '');", element);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: 1.8px solid red;');", element);
		js.executeScript("arguments[0].setAttribute('style', '');", element);
		if (element.getAttribute("type") == "button" || element.getAttribute("type") == "submit") {

			Log.info("[Action]" + "element clicked ,button:" + element.getAttribute("value") + element.getText());
		} else {

			Log.info("[Action]" + "element clicked : " + element.getAttribute("name") + " value:"
					+ element.getAttribute("value") + element.getText());

		}
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		

		if (element.getAttribute("type") == "button" || element.getAttribute("type") == "submit") {

			Log.info("[Action]"+"element clicked ,button:" + element.getAttribute("value" ) + element.getText());
		} else {

			Log.info("[Action]"+"element clicked : " + element.getAttribute("name") + " value:" + element.getAttribute
			("value") + element.getText());

		}
	}

	public void onException(Throwable throwable, WebDriver driver) {

		Log.error(throwable.getClass() + driver.toString());
	}

	public void beforeAlertAccept(WebDriver driver) {
		// Do nothing.
	}

	public void afterAlertAccept(WebDriver driver) {
		// Do nothing.
	}

	public void afterAlertDismiss(WebDriver driver) {
		// Do nothing.
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// Do nothing.
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// Log.error(driver.getClass());
		// Do nothing.
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// Do nothing.
		// Log.error(driver.getClass());
	}

	public void beforeNavigateBack(WebDriver driver) {
		// Do nothing.
	}

	public void afterNavigateBack(WebDriver driver) {
		// Do nothing.
	}

	public void beforeNavigateForward(WebDriver driver) {
		// Do nothing.
	}

	public void afterNavigateForward(WebDriver driver) {
		// Do nothing.
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// Do nothing.
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// Do nothing.
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// Do nothing.
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// Do nothing.
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
	}

	public void beforeScript(String script, WebDriver driver) {

		Log.info("[Action]" + "element clicked : " + script + ("name") + " value:" + script + driver.toString());

		// Do nothing
	}

	public void afterScript(String script, WebDriver driver) {
		// Do nothing
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 1.4px solid red;');",
				element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}


	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {

	}

}
