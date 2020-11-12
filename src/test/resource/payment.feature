Feature: Payment

  Scenario: Checking payments
    Given I have <invoice>
    And I have checked <read comments> comments
    When I go to my comments section
    Then I should have <unread comments> new comments