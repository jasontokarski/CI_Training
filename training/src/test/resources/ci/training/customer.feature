#Author: your.email@your.domain.com
#Keywords Summary :
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
Feature: Wallet Application

	Scenario: Creating a new customer account
		Given I want to create a new account
		When I enter name "Jason", phone number "8883024438", balance "50.00"
		Then A new customer account with name "Jason", phone number "8883024438", balance "50.00" should be created
		
	Scenario: Creating a new customer account
