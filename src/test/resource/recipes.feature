Feature: Recipes

  Scenario: Counting recipes
    Given I'm on index page
    When I write <Text> to search
    When I click search
    Then I should have <Amount of results> recipes