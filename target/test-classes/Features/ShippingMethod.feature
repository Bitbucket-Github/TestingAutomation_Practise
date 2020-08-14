@ShippingMethod
Feature: Feature to test the shipping method functionality

Background:
Given User is on website page
When User enters username, password and click on sign in button
And select the items in the category list
Then Add the items into the cart list


Scenario: Verify and update the shipping method functionality 
Given User already added product into the cart
When User is on delivery address page
Then Accept the shipping mode and click on proceed to checkout button

#Scenario: Verify the user able to pay different payment options
#When User is on payment page 
#Then User click on any one of the payment method and click on confirm order