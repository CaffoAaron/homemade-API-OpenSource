Feature: Coke cans

  Scenario: Counting coke cans
    Given I have <opening balance> coke cans
    And I have drunk <processed> coke cans
    When I go to my fridge
    Then I should have <in stock> coke cans