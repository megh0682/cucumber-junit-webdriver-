package com.home.mystorywriterQA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities extends PageAbstract{

	public Utilities(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static void waitforseconds(Integer sec){
		try {
		    Thread.sleep(1000*sec);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
    }
	
	 
}
