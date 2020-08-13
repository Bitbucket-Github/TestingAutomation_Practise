Feature: MyStoreSearch

  Background: 
    Given User opens the chromebrowser
    And user navigate to the application

  @Searchbar @AddToWishList 
  Scenario: SearchItemThroughSearchbar
    When user searches for the product
    Then the search result page is displayed

  @Navigation
  Scenario: SearchItemThroughNavigation
    When user points on anyone category
    And user select the subcategory

  @AddToWishList
  Scenario: Add to wishList 
    Given user clicks on more option
    Then user selects add to wishlist

  @MyStorePayment
  Scenario: Payment through pay by check option
    Given user click cart
    And user click on  checkout option
    And user click on proceed to checkout option
    And again user click on proceed to checkout option
    Then user selects PayBY Check option
    And user click on i confirm my order

  @OrderHistory
  Scenario: Product Order History Details
    When user click on signin option
    And user enters valid credentials
    Then click on sign in button
    And user click on order history and details
