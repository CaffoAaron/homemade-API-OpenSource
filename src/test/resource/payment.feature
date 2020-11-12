Feature: Payment

  Scenario: Checking payments
    Given I have <invoice>
    And I verify whether is paid or unpaid
    When I check the invoice status
    Then It says it is <invoice status>