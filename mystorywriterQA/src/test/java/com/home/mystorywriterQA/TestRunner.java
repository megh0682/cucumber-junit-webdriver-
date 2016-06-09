package com.home.mystorywriterQA;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java"
		,glue = {"com.home.mystorywriterQA"}
		,monochrome = true
		,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json","pretty" }
		
		)
 
public class TestRunner {
 
}