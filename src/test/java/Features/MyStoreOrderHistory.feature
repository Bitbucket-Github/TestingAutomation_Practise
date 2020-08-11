Feature: MyOrderHistory

  @OrderHistory
  Scenario: 
    Given User opens browser
    And user navigate to yourlogo
    When user click on signin option
    And user enters valid credentials
    Then click on sign in button
    Given user click cart
    And user click on  checkout option
    And user click on proceed to checkout option
    And again user click on proceed to checkout option
    Then user selects PayBY Check option
    And user click on i confirm my order
    #Scenario: 
   # And user click on order history and details