Feature: Search

  Scenario: Search recipes
    Given the user is on the index page
    When the user enters recipes in the search bar
    And the user clicks the search button
    Then the recipes page appears