package com.home.mystorywriterQA;

import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends PageAbstract {
	
	/**
	 
     * All WebElements are identified by @FindBy annotation
 
     */
		
 
    @FindBy(name="username")
    WebElement uname;
    
    @FindBy(name="userpwd")
    WebElement pwd;
  
    @FindBy(id="savename")
    WebElement loginbtn;
  
    @FindBy(id="gotoregister")
    WebElement registerbtn;
    
   // @FindBy(id="pagetitle")
  //WebElement logintitle;
    
    //constructor for PageLogin class
    
   public PageLogin(WebDriver driver){
    	 
	   super(driver);
 
        //This initElements method will create all WebElements
 
        PageFactory.initElements(driver, this);
 
    }
    
  //Set user name in textbox
    
   public void setUserName(String strusername){
	   if(isElementExisting(uname)){
        uname.sendKeys(strusername);
	   }else{
		System.out.println("Webelement uname not found");
	   }
	}
    
  //Set password in textbox
    
    public void setPassword(String strpassword){
    	if(isElementExisting(pwd)){
    		pwd.sendKeys(strpassword);
    	}else{
    		System.out.println("Webelement pwd not found");
 	   }
     }
    
  //click on login button
    
    public void clickLogin(){
    	if(isElementExisting(loginbtn)){
    		loginbtn.click();
    	}else{
    		System.out.println("Webelement loginbtn not found");
 	   }
    }
    
  //click on register button
    
    public void clickRegister(){
    	if(isElementExisting(registerbtn)){
    		registerbtn.click();
    	}else{
    		System.out.println("Webelement registerbtn not found");
 	   }
    	
    }
    
  //Get the title of Login Page
    
    public String getLoginTitle(){
    	String txt;
    	txt= driver.getTitle();
        return   txt;
 
    }
    
    /*
     * Validating the existence of the web elements on the page.
     */
    
    public boolean isElementExisting(WebElement we) {
        try {
            we.isDisplayed();
            return true;
        } catch(NoSuchElementException e) {
        	System.out.println("Element does not exist.");
            return false;
        }
    }
    
    /**
    
     * This POM methods will be exposed in test case to login in the application
 
     * @param strusername
 
     * @param strpassword
 
     * @return
 
     */
    
    public List<String> testbrokenlinks(){
    	List<WebElement> alllinks = new ArrayList<WebElement>();
    	List<String> brokenlinks= new ArrayList<String>();
    	//Util_BrokenLinks Util_BrokenLinksObj = new Util_BrokenLinks(driver);
    	alllinks = Util_BrokenLinks.findAllLinks(driver);
    	if(alllinks!=null){
 	    brokenlinks= Util_BrokenLinks.getBrokenLinkURLs(alllinks);
 	    Util_BrokenLinks.printbrokenlinks(brokenlinks);
    	}else{
    	brokenlinks = null;
    	}
 	    return brokenlinks;
    }
 
    public void loginTomybuddywriter(String strusername,String strpassword){
 
        //Fill user name
 
        this.setUserName(strusername);
 
        //Fill password
 
        this.setPassword(strpassword);
        
        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Click Login button
 
        this.clickLogin();
        
       // return  this.navigateToHomePage();
        
   }
    
	
    public void handlealertforinvalidlogin(){
    	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	Alert alert=driver.switchTo().alert();
        if(alert.getText().toLowerCase().contains("user does not exist") ||alert.getText().toLowerCase().contains("username should be") ){
           System.out.println(alert.getText());
           alert.accept();
         }else{
           System.out.println("No alert");
           fail("alert expected!");
         }
    }
    
    
    public PageRegister gotoregisterpage(){
    	 
       //Click Login button
 
        this.clickRegister();
        return new PageRegister(driver);
 
    }
    
      
   

}