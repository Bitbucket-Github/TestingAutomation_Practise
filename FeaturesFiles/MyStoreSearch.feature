Feature: MyStoreSearch

  Background: 
    Given User opens the chromebrowser
    And user navigate to the application
	@Searchbar
  Scenario: SearchItemThroughSearchbar
    When user searches for the product
    Then the search result page is displayed
	@Navigation
  Scenario: SearchItemThroughNavigation
    When user points on anyone category
    And user select the subcategory
