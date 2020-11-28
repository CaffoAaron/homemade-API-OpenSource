Feature: Publications

  Scenario: Publications notification
    Given the user is in the index page
    When the user enters notifications in the notification icon where the number of new publications is 3
    Then the results with publications appear