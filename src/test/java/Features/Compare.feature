
@compare
Feature: feature to test compare functionality

  Scenario Outline: Check compare functionality in cart
    Given user checks quantity total and shippind charge
    When user calculates total
    And validates total and total+tax
    Then result should be equal
