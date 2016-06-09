package com.home.mystorywriterQA;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class Util_BrokenLinks {
WebDriver driver;
 
public static List<WebElement> findAllLinks(WebDriver driver)  {
 	  List<WebElement> elementList = new ArrayList<WebElement>();
 	  List<WebElement> finalList = new ArrayList<WebElement>();
 	  if(driver.findElements(By.tagName("a"))!=null){
 	  elementList.addAll(driver.findElements(By.tagName("a")));
 	  }
 	  if(driver.findElements(By.tagName("img"))!=null){
      elementList.addAll(driver.findElements(By.tagName("img")));
 	  }
      if(elementList.size()!=0){
      for (WebElement element : elementList)
 
	  {
 
		  if(element.getAttribute("href") != null)
 
		  {
 
			  finalList.add(element);
 
		  }		  
 
	  }	
 
	 
 
  }else{
   finalList= null;
   
  }
      return finalList;
} 

 
	public static Integer isLinkBroken(URL url) throws Exception
 
	{
 
		//url = new URL("http://yahoo.com");
 
		Integer response =0;
 
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 
		try
 
		{
 
		    connection.connect();
 
		  //  response = connection.getResponseMessage();	      
		    
		    response = connection.getResponseCode(); 
 
		    connection.disconnect();
 
		    
 
		}
 
		catch(Exception exp)
 
		{
 
			System.out.println(exp.getMessage());
 
		}  		
		
		return response;
 
	}
	
	public static List<String> getBrokenLinkURLs(List<WebElement> alllinks ){
		
		//System.out.println("Total number of elements found " + alllinks.size());
		List<String> brokenlinkurls= new ArrayList <String>();
		 
	    for( WebElement element : alllinks){

	    	try

	    	{
	    		//if(isLinkBroken(new URL(element.getAttribute("href")))== 200){
	    		 
	    		 System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
	    		 brokenlinkurls.add(element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
	    		//}
            
		       // System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));

	    		//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));

	    	}

	    	catch(Exception exp)

	    	{

	    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		

	    	}
	    	
	    	

	    }
		return brokenlinkurls;
		
	}
	
    public static void printbrokenlinks(List<String> brokenlinks){
		   	    
		    if(!brokenlinks.isEmpty()){
		      System.out.println(brokenlinks.size());
		      Iterator<String> iterator = brokenlinks.iterator();
			  while (iterator.hasNext()) {
				System.out.println(iterator.next());
			  }
		    }else{
		      System.out.println("No broken links available on the page");	
		    }

	}
   
		  
 
	/*public static void main(String[] args) throws Exception {
 
		// TODO Auto-generated method stub
 
			FirefoxDriver ff = new FirefoxDriver();
 
			ff.get("http://localhost:8080/mybuddywriter/main.jsp");
 
			List<WebElement> allImages = findAllLinks(ff);    
 
		    System.out.println("Total number of elements found " + allImages.size());
 
		    for( WebElement element : allImages){
 
		    	try
 
		    	{
		    		if(isLinkBroken(new URL(element.getAttribute("href")))== 200){
		    		 
		    		 System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    		 
		    		}
                
			       // System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
 
		    		//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
 
		    	}
 
		    	catch(Exception exp)
 
		    	{
 
		    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		
 
		    	}
 
		    }
 
	    }

 */
	
	}