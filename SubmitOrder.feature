
@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommernce page
  

  @tag2
  Scenario Outline: positive test of submittign the order
    Given Logged in user name <name> and password <password>	
    When I add the product name <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed
    Examples: 
      | name  					| Password  |  productName |
      | dirash@leena.ai	| Dirash@10 |  ADIDAS ORIGINAL |