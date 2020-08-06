Feature: MyStorePayment

  Scenario: Payment through pay by check option
    Given user click cart
    And user click on  checkout option
    And user click on proceed to checkout option
    And again user click on proceed to checkout option
    Then user selects PayBY Check option
    And user click on i confirm my order
