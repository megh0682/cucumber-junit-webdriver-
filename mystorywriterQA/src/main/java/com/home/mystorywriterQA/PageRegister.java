package com.home.mystorywriterQA;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRegister extends PageAbstract{

 
    @FindBy(xpath="//div[@class='page-header']/h1/b")
 
    WebElement regPageHeader;
 
	@FindBy(id="fnlabel")
	 
	WebElement firstname;
	
	@FindBy(id="lnlabel")
	 
	WebElement lastname;
	
	@FindBy(id="unlabel")
	 
	WebElement username;
	
	@FindBy(id="pwdlabel")
	 
	WebElement password;
	
	@FindBy(id="emaillabel")
	 
	WebElement email;
	 
	@FindBy(id="submitregister")
	 
	WebElement registerbtn;
	
	@FindBy(id="//button[@value='Cancel']")
	 
	WebElement cancelbtn;
	
    public PageRegister(WebDriver driver){
 
        super(driver);
 
        //This initElements method will create all WebElements
 
        PageFactory.initElements(driver, this);
 
    }

    //Set user name in textbox
    
    public void setUserName(String strusername){
 	   if(isElementExisting(username)){
        username.sendKeys(strusername);
 	   }else{
 		System.out.println("Webelement" +username+" not found");
 	   }
     }
     
    //Set password in textbox
     
    public void setPassword(String strpassword){
     	if(isElementExisting(password)){
     		password.sendKeys(strpassword);
     	}else{
     		System.out.println("Webelement"+password+" not found");
  	   }
         
     }
    
    //Set firstname in textbox
    
    public void setFirstname(String strfirstname){
     	if(isElementExisting(firstname)){
     		firstname.sendKeys(strfirstname);
     	}else{
     		System.out.println("Webelement"+firstname+" not found");
  	   }
         
     }
    
   //Set lastname in textbox
    
    public void setLastname(String strlastname){
     	if(isElementExisting(lastname)){
     		lastname.sendKeys(strlastname);
     	}else{
     		System.out.println("Webelement"+lastname+" not found");
  	   }
         
     }
    
   //Set email in textbox
    
    public void setEmail(String stremail){
     	if(isElementExisting(email)){
     		email.sendKeys(stremail);
     	}else{
     		System.out.println("Webelement"+email+" not found");
  	   }
         
     }
     
    //Get the title of Register Page
 
    public String getRegisterPageTitleText(){
        String txt;
        txt= driver.getTitle();
        return txt;
        }
        
     //click on Register button
        
     public void clickRegister(){
        	if(isElementExisting(registerbtn)){
        		registerbtn.click();
        	}else{
        		System.out.println("Webelement"+registerbtn+ " not found");
     	   }
        	
        }
        
      //click on cancel button
        
        public void clickCancel(){
        	if(isElementExisting(cancelbtn)){
        		cancelbtn.click();
        	}else{
        		System.out.println("Webelement"+ cancelbtn+" not found");
     	   }
        	
        }
        
      //verify the fields after clicking cancel button
        
        public boolean isCancelfunction(){
        	boolean flag= false;
        	if(firstname.getText()=="" && lastname.getText()=="" && username.getText()=="" && password.getText()=="" && email.getText()==""){
        	flag= true;	
        	}else{
        	flag = false;
            }
        	return flag;        	
        }
  
        /**
        
         * This POM methods will be exposed in test case to register to the application
     
         * @param firstname
     
         * @param lastname
         
         * @param username
          
         * @param password
         
         * @param email
     
         * @return
     
         */
     
        public void registerTomybuddywriter(String firstname,String lastname,String username, String password, String email){
     
            //Fill registration fields
        	
        	this.setFirstname(firstname);
        	this.setLastname(lastname);
        	this.setUserName(username);
        	this.setPassword(password);
        	this.setEmail(email);
     
            //wait for 10 sec
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
            //Click Reister button
     
            this.clickRegister();
     
        }
        
        
     //Handle alert
        public void handlealertforinvalidregister (){
        	
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	Alert alert=driver.switchTo().alert();
            if(alert.getText().toLowerCase().contains("cannot be blank or invalid") ){
               System.out.println(alert.getText());
               alert.accept();
             }else{
               System.out.println("No alert");
               fail("alert expected!");
             }
       	}
      
    //web element existence validity
        
        public boolean isElementExisting(WebElement we) {
            try {
                we.isDisplayed();
                return true;
            } catch(NoSuchElementException e) {
            	System.out.println("Element does not exist.");
                return false;
            }
        }
	
}
