$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/home/mystorywriterQA/mystorywriter.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: shah.iyer@gmail.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : This is a feature file to verify functional sanity test cases."
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 19,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 21,
  "name": "Storywriter sanity test cases",
  "description": "I want to use this template to verify functional sanity test cases.",
  "id": "storywriter-sanity-test-cases",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10118192651,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Validate valid inputs on login page",
  "description": "",
  "id": "storywriter-sanity-test-cases;validate-valid-inputs-on-login-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "I am on storywriter login page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I assert login page title",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I check for the broken links on the loginpage",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I enter valid username and password and click on submit button",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I assert homepage title text",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "I check for the broken links on the homepage",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I logout of the application",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I assert login page title again",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_am_on_storywriter_login_page()"
});
formatter.result({
  "duration": 23768416438,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_assert_login_page_title()"
});
formatter.result({
  "duration": 75652426,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_check_for_the_broken_links_on_the_loginpage()"
});
formatter.result({
  "duration": 40169533863,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_enter_valid_username_and_password_and_click_on_submit_button()"
});
formatter.result({
  "duration": 21458597531,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_assert_homepage_title_text()"
});
formatter.result({
  "duration": 164280541,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_check_for_the_broken_links_on_the_homepage()"
});
formatter.result({
  "duration": 5127721351,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_logout_of_the_application()"
});
formatter.result({
  "duration": 10347308143,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_assert_login_page_title_again()"
});
formatter.result({
  "duration": 35260642,
  "status": "passed"
});
formatter.after({
  "duration": 27965422,
  "status": "passed"
});
});