package com.home.mystorywriterQA;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class PageHome extends PageAbstract{

		 
    @FindBy(xpath="//body/div/div/div/h1")
 
      WebElement homePageTitle;
 
	@FindBy(linkText="Log Out")
	 
	  WebElement logoutlnk;
	
	@FindBy(xpath="//body/header/img")
	 
	  WebElement headerImg;
	
	@FindBy(xpath="//img[contains(@src,'/images/*.png')]")
	 
	  WebElement bodyImg;
	 
	@FindBy(xpath="//input[@id='firstname']") 
	
      WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastname']") 
	
    WebElement lastname;
	
	@FindBy(xpath="//input[@id='email']") 
	
    WebElement email;
	
	@FindBy(xpath="//header/h1")
	
	WebElement headertext;
	
    @FindBy(xpath="//footer")
	
	WebElement footertext;
	
    @FindBy(xpath="//a[@id='hpcreateStory']/h1")
	
	WebElement createStorylnk;
	
    
	public PageHome(WebDriver driver){
		super(driver);
         
        //This initElements method will create all WebElements
 
        PageFactory.initElements(driver, this);
 
    }
 
     
 
    //Get the title of Home Page
 
        public String getHomePageTitleText(){
        	String txt;
        if(isElementExisting(homePageTitle)){
        	txt =homePageTitle.getText();
         }else{
        	System.out.println("Webelement"+homePageTitle+" not found");
        	txt="Null";
         }
         
         return txt;
 
        }
        
    //verify the profile image in the header.
        
       public boolean headerImageVerify(){
        boolean flag=false;
        if(isElementExisting(headerImg)){
        	flag =true;
         }else{
        	System.out.println("Webelement"+ headerImg +"not found");
        	flag=false;
         }
         
         return flag;
 
        }
       
     //verify the profile image in the body.
       
      public boolean bodyImageVerify(){
       boolean flag=false;
       if(isElementExisting(bodyImg)){
       	flag =true;
        }else{
       	System.out.println("Webelement"+ bodyImg +"not found");
       	flag=false;
        }
        
        return flag;

       }
      
      //verify the firstname text is present and disabled.
      
      public boolean firstnamePresentAndDisabled(){
       boolean flag=false;
       if(isElementExisting(firstname)){
    	   if(!firstname.isEnabled()){
    		  flag =true;
    	   }else{
    		  flag=false;
    		  System.out.println("Webelement"+firstname+" not disabled."); 
    	   }
        }else{
       	System.out.println("Webelement"+firstname+" not found");
       	flag=false;
        }
        
        return flag;

       }
      
 //verify the lastname text is present and disabled.
      
      public boolean lastnamePresentAndDisabled(){
       boolean flag=false;
       if(isElementExisting(lastname)){
    	   if(!lastname.isEnabled()){
    		  flag =true;
    	   }else{
    		  flag=false;
    		  System.out.println("Webelement"+lastname+" not disabled."); 
    	   }
        }else{
       	System.out.println("Webelement"+lastname+" not found");
       	flag=false;
        }
        
        return flag;

       }
      
 //verify the email field is present and disabled.
      
      public boolean emailPresentAndDisabled(){
       boolean flag=false;
       if(isElementExisting(email)){
    	   if(!email.isEnabled()){
    		  flag =true;
    	   }else{
    		  flag=false;
    		  System.out.println("Webelement"+email+" not disabled."); 
    	   }
        }else{
       	System.out.println("Webelement"+email+" not found");
       	flag=false;
        }
        
        return flag;

       }
      
    // My Stories h1 tag text is present
      
    public boolean ish1tagTextPresent(String text){
    	  String txt = text.toLowerCase();
    	  boolean flag=false;
    	  List <WebElement> h1tags = driver.findElements(By.xpath("//h1"));
    	  for(WebElement h1tag : h1tags){
    		if(h1tag.getText().toLowerCase() == txt){
    			flag=true;
    		}
    		   		  
    	  }
		return flag;
      }
      
    
    //Click on logout link
     
        public PageLogin clicklogout(){
        
        if(isElementExisting(logoutlnk)){
        	logoutlnk.click();
        }else{
            System.out.println("Webelement"+ logoutlnk+" not found");
        }
         return new PageLogin(driver);
        }
        
    // web element existence validity
        
        public boolean isElementExisting(WebElement we) {
            try {
                we.isDisplayed();
                return true;
            } catch(NoSuchElementException e) {
            	System.out.println("Element does not exist.");
                return false;
            }
        }
        
    //broken links verification
        
        public  List<String> testbrokenlinks(){
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

	
}