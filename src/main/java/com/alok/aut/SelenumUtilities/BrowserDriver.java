package com.alok.aut.SelenumUtilities;

import com.alok.aut.project.Util.DateManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class BrowserDriver implements WebDriver {

    String browserName;
    public WebDriver wd;
    public EventFiringWebDriver driver = null;
    public static HashMap<String, WebDriver> driverObject = new HashMap<String, WebDriver>();
    BrowserSetup b;
    int timeout =100;
    public BrowserDriver(String browserName) {
        this.browserName = browserName;
        this.driver = createDriver(browserName);
    }

    private EventFiringWebDriver createDriver(String browserName) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(browserName);

        if (browserName.equalsIgnoreCase("internet explorer")) {
            dc = DesiredCapabilities.internetExplorer();
            b = new BrowserSetup(BrowserSetup.Browser.IEXPLORE);
        }
        if (browserName.equalsIgnoreCase("Firefox")) {
            dc = DesiredCapabilities.firefox();
            b = new BrowserSetup(BrowserSetup.Browser.FIREFOX);
        }
        if (browserName.equalsIgnoreCase("Chrome")) {
            dc = DesiredCapabilities.chrome();
            b = new BrowserSetup(BrowserSetup.Browser.CHROME);

        }
        if (browserName.equalsIgnoreCase("No Browser")) {

            b = new BrowserSetup(BrowserSetup.Browser.NOBROWSER);

        }
        wd = b.invokeBrowser();
        driver = new EventFiringWebDriver(wd);
        DriverListener logListener = new DriverListener(browserName, wd);
        driver.register(logListener);
        driverObject.put("driver",driver);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
    }


    @Override
    public String toString() {
        return this.browserName;
    }

    public WebDriver driver() {
        return this.driver;
    }

    public static  WebDriver getDriver() {

        return driverObject.get("driver");
    }
    @Override
    public void close() {
        driver().close();
    }

    @Override
    public WebElement findElement(By locator) {
        return driver().findElement(locator);
    }

    @Override
    public List findElements(By arg0) {
        return driver().findElements(arg0);
    }

    @Override
    public void get(String arg0) {
        driver().get(arg0);
    }

    @Override
    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    @Override

    public String getPageSource() {
        return driver().getPageSource();
    }

    @Override
    public String getTitle() {
        return driver().getTitle();
    }


    @Override
    public String getWindowHandle() {
        return driver().getWindowHandle();
    }

    @Override
    public Set<String> getWindowHandles() {

        return driver().getWindowHandles();
    }

    @Override
    public Options manage() {
        return driver().manage();
    }

    @Override
    public Navigation navigate() {
        return driver().navigate();
    }

    @Override
    public void quit() {
        driver().quit();
    }

    @Override
    public TargetLocator switchTo() {
        return driver().switchTo();
    }

    public static String TakeSnapshot(WebDriver driver, String DestFilePath) throws IOException {
        String TS= DateManager.getTimeStamp();
        TakesScreenshot tss=(TakesScreenshot) driver;
        File srcfileObj= tss.getScreenshotAs(OutputType.FILE);
        DestFilePath=DestFilePath+TS+".png";
        File DestFileObj=new File(DestFilePath);
        FileUtils.copyFile(srcfileObj, DestFileObj);
        return DestFilePath;
    }
    public static void pageLoadTimeOut(WebDriver driver){

        driver.manage().timeouts().pageLoadTimeout(Constants.implicitWait, TimeUnit.SECONDS);

    }
}