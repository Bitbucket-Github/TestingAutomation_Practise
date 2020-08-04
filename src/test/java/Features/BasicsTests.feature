@EndToEnd
Feature: Feature to test the basic functionality 

Background:
Given User is on YourLogo page

@AddToCart
Scenario: User should select the product and place into the cart 
When User enters valid username and password 
And Click on sign in button
Then User navigate to home page
When User select the product in the category list
Then Add the product into the cart list

@SendToFriend
Scenario: Verify that user can send mail to a friend through send to a friend option in the product page
When User select the product in the category options
And Click on the send to a friend option
Then user enters name, email address of friend and click on the send button
 
@NewsLetter
Scenario: Verify that user can receive news letter subscription/notification to he given email id
When User enter email id for subscription
Then Click on the send forward button for notification 
 
@SocialMedia
Scenario: Verify the activation of social media 
Then Click on the social media icon then user should be navigate to that page

@ContactUs
Scenario: Verify that user send his quaries through contact us option
When User click on contact us button
And user enters valid credentials for message send
Then Click on the send button
