#Background:
#Given User is on website page
#When User enters username, password and click on sign in button
#And select the items in the category list
#Then Add the items into the cart list

@compare
Feature: feature to test compare functionality

  Scenario Outline: Check compare functionality in cart
    Given user checks quantity total and shippind charge
    When user calculates total
    And validates total and total+tax
    Then result should be equal
