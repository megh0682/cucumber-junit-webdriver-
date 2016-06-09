#Author: shah.iyer@gmail.com
#Keywords Summary : This is a feature file to verify functional sanity test cases.
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template

Feature: Storywriter sanity test cases
	I want to use this template to verify functional sanity test cases.


Scenario: Validate valid inputs on login page
Given I am on storywriter login page
  And I assert login page title
  And I check for the broken links on the loginpage  
When  I enter valid username and password and click on submit button
Then  I assert homepage title text
	And I check for the broken links on the homepage
	And I logout of the application
	And I assert login page title again
	
