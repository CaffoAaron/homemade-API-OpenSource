Feature: Coke cans

  Scenario Outline: Counting Coke
    Given I have <start> coke cans
    And I have drunk <drunk> coke cans
    When I go to my fridge
    Then I should have <left> coke cans

    Examples:
      | start | drunk | left |
      | 12    | 5     | 7    |
      | 20    | 5     | 15   |