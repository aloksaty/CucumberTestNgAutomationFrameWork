package com.alok.aut.SelenumUtilities;
import com.alok.aut.project.Util.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;

public class BrowserSetup {

	static Logger log = Logger.getLogger("NoteXchange");

	public enum Browser{NOBROWSER ,FIREFOX,CHROME,OPARA,IEXPLORE,SAFARI }

	Browser browser;
	WebDriver wd;
	String chromePath;
	String IEPAth;
	String fireFoxPath;
	String exportFile;
	public BrowserSetup (Browser browser){

		this.browser=browser;


	}

	public String getBrowser(){

		return browser.name();
	}	
	
	public WebDriver invokeBrowser() {			
		try{

			switch(browser){
			
			case NOBROWSER:
				//WebDriverManager.phantomjs().setup();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver ().setup ();

				FirefoxOptions optionsFF = new FirefoxOptions();
				//WebDriverManager.firefoxdriver().version("0.27.0").setup();
				wd =new FirefoxDriver();
				break;

			case CHROME:
				WebDriverManager.chromedriver ().setup ();
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				String downloadDir=System.getProperty("user.dir") +"\\download";
				chromePrefs.put("download.default_directory",downloadDir );
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("start-maximized");
				wd= new ChromeDriver(options);
				break;
			case IEXPLORE :
				WebDriverManager.iedriver().setup();
				wd= new InternetExplorerDriver();
				break;
			default :
				throw new RuntimeException("Invalid Browser");
			}
		}catch(Exception e){
			Log.error("This is script error"+e.getMessage());
			 e.printStackTrace();
		}
		return wd;
	}
	

}

