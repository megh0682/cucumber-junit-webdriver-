package com.home.mystorywriterQA;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.home.mystorywriterQA.Bootstrap;

import org.hamcrest.CoreMatchers;

public class StepDefinition {
	
	WebDriver driver;
	PageAbstract pageAbstractObj;
	PageLogin PageLoginObj;
	PageHome pageHomeObj;
	Utilities utilitiesObj;
	String username ="ved";
    String password ="123456";
    String fn ="VED";
	@Rule 
	    public TestRule watcher = new TestWatcher() {
	    	   protected void starting(Description description) {
	    		  System.out.println(description.getMethodName()+"being run...");
	    	   }
	    	   @Override
	    	      protected void succeeded(Description description) {
	    		   System.out.println(description + " " + "success!\n");
	    	         }
	    	   @Override
	    	      protected void failed(Throwable e, Description description) {
	    		   System.out.println(description + "failed!\n");
	    	      }
	    	};
	@Rule
	    public ErrorCollector collector = new ErrorCollector();
	 
	@Before
	public void setup() throws Throwable {
		String browser = "ff";
		driver = Bootstrap.getDriverForBrowser(browser);
		
	}

	@After
	public void teardown() throws Throwable {
		pageAbstractObj.closetheBrowser();
		
	}
	@Given("^I am on storywriter login page$")
	public void i_am_on_storywriter_login_page() throws Throwable {
		pageAbstractObj = new PageAbstract(driver);
		pageAbstractObj.navigateToWebApp();
		Utilities.waitforseconds(20);
	   
	}

	@Given("^I assert login page title$")
	public void i_assert_login_page_title() throws Throwable {
		PageLoginObj = new PageLogin(driver);
		try{
	    	collector.checkThat(PageLoginObj.getLoginTitle().toLowerCase(), CoreMatchers.containsString("login page"));
	  	    } catch (Throwable t){
	    	collector.addError(t);
	    }  
	}

	@Given("^I check for the broken links on the loginpage$")
	public void i_check_for_the_broken_links_on_the_loginpage() throws Throwable {
		 //get broken links from login page
	   List<String> brokenlinks = new ArrayList<String>() ;
	   brokenlinks = PageLoginObj.testbrokenlinks();
	   collector.checkThat(brokenlinks, CoreMatchers.equalTo(null));
	}

	@When("^I enter valid username and password and click on submit button$")
	public void i_enter_valid_username_and_password_and_click_on_submit_button() throws Throwable {
	    PageLoginObj.loginTomybuddywriter(username, password);
        Utilities.waitforseconds(20);
	   
	}

	@Then("^I assert homepage title text$")
	public void i_assert_homepage_title_text() throws Throwable {
		pageHomeObj = new PageHome(driver);
		System.out.println(driver.getTitle());
		String actText =  pageHomeObj.getHomePageTitleText();
	    String exptext = "hello" + " " + fn.toLowerCase();
        //System.out.println(actText);
	    //System.out.println(exptext);
        try{
        	collector.checkThat(actText.toLowerCase(), CoreMatchers.containsString(exptext));
	    } catch (Throwable t){
	    	collector.addError(t);
	    }   
	    
	    
	}

	@Then("^I check for the broken links on the homepage$")
	public void i_check_for_the_broken_links_on_the_homepage() throws Throwable {
		List<String> brokenlinks = new ArrayList<String>() ;
		   brokenlinks = pageHomeObj.testbrokenlinks();
		   collector.checkThat(brokenlinks, CoreMatchers.equalTo(null));
	}

	@Then("^I logout of the application$")
	public void i_logout_of_the_application() throws Throwable {
		pageHomeObj.clicklogout();
		Utilities.waitforseconds(10);
	   
	}
	
	@Then("^I assert login page title again$")
	public void i_assert_login_page_title_again() throws Throwable {
	    String loginPageTitle = PageLoginObj.getLoginTitle();
	    //System.out.println(loginPageTitle);
	    try{
	    	collector.checkThat(loginPageTitle.toLowerCase(), CoreMatchers.containsString("login page"));
	    } catch (Throwable t){
	    	collector.addError(t);
	    }  
	}

}
