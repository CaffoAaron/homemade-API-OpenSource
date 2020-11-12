Feature: Comments

  Scenario: Counting payments
    Given I have <comments count> comments
    And I have checked <read comments> comments
    When I go to my comments section
    Then I should have <unread comments> new comments