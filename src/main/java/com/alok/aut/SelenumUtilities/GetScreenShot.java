package com.alok.aut.SelenumUtilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GetScreenShot {
	WebDriver driver;
	String name;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	public GetScreenShot(String Test) {
		name = Test.toLowerCase();
		this.driver=BrowserDriver.getDriver();
	}
	public void capture(String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\report\\" + screenShotName + sdf.format(new Timestamp(System.currentTimeMillis())) + ".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}