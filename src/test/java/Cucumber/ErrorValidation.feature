
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 
  @errorvalidations
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommernce page
    When Logged in user name <name> and password <password>	
    Then "Incorrect email or password." is displayed

    Examples: 
      | name  					| Password      |  productName |
      | dirash@leena.ai	| Dirasherer@10 |  ADIDAS ORIGINAL |
