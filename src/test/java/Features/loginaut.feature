#for comments
#@loginscenerio

@openbrowser
Feature: feature to test login functionality

  Scenario: Finding ecommerce site
    Given I am on the Google search page
    When I search for website
    And hits enter
    Then the page title should start with "logo"
    
    
@Register
  Scenario Outline: Check login functionality with invalid credentials
    Given user navigate on sign in
    And user do the authentication process
    When user the enters <Emailnew> and <passwordnew>
    And clicks on the signin button
    Then error msg is displayed and user creates acoounr

    Examples: 
      | Emailnew        | passwordnew | status |
      | bit76@gmail.com | Giub123     | fail   |
      
      
@login
  Scenario Outline: Check login functionality with valid credentials
    Given user clicks on sign in
    And user do the authentication
    When user enters <Email> and <password>
    And clicks on signin buttonp
    Then check user is navigated to home page

    Examples: 
      | Email                 | password  | status  |
      | bitbucket76@gmail.com | Github123 | success |
