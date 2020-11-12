Feature: Messages

  Scenario: Counting messages
    Given I have <inbox count> messages
    And I have checked <read> messages
    When I go to my inbox
    Then I should have <unread> new messages