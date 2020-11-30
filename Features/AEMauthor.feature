#Author: jaivyas@98gmail.com
#Keywords Summary : Selenium_BDD_framework
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

Feature: To Automate AEM

  I want to use this template for my feature file

@restapitesting
Scenario: To understand the Api Automation
Then 	invokebrowser
And   intialize aem author instance in "Test" Environment
Then 	Test the Number Of Circuits in "2017"
#Then CRUD operartions in RestAssured  
  

  @applitoolsIntegration
  Scenario: To check applitools integrations
  Then invokebrowser
  Then Check Applitools integration "Product Summary Container"
  			

  
