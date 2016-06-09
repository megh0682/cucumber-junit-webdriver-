package com.home.mystorywriterQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Bootstrap {
	
	private static final String CHROME_DRIVER_EXE = System.getProperty("user.dir")+ "//Drivers/"+"chromedriver.exe";
	private static final String IE_DRIVER_EXE = System.getProperty("user.dir")+ "/Drivers/"+"IEDriverServer.exe";
	
	public Bootstrap(){
		
	}
	
	public static WebDriver getDriverForBrowser(String browser){
    WebDriver driver;	
	switch (browser) {
    case "chrome" : 
   	 System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_EXE);
	 driver = new ChromeDriver();
	    break;
    case "ie" : 
   	 System.setProperty("webdriver.ie.driver", IE_DRIVER_EXE);
     driver = new InternetExplorerDriver();
        break;
    case "ff" :  
   	 driver = new FirefoxDriver();
        break;
    default:
   	 driver = new FirefoxDriver();
        break;
    }
	return driver;
	}
}