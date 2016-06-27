package com.home.mystorywriterQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * Abstract Page to initialize the Webdriver. All the subclasses of this class will have an access to the instance of the Webdriver.
 *
 */
public class PageAbstract 
{
	protected WebDriver driver;
	public PageAbstract(WebDriver driver){
		this.driver = driver;		
	}
	
	public void navigateToWebApp(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("http://mystorywriter.us-west-2.elasticbeanstalk.com/");	
	}
	

	
	public void closetheBrowser(){
		driver.close();
	}
  
}
