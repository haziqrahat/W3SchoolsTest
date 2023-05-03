Feature: W3 login
  Scenario: Successful login using correct credentials
    When the login page is displayed
    And the user enters the valid credentials
    Then the user is logged in and the learning page is displayed

  Scenario: Unsuccessful login using wrong email
    When the login page is displayed
    And the user enters the wrong email but correct password
    Then the user is not logged in and an error message is displayed

  Scenario: Unsuccessful login using wrong password
    When the login page is displayed
    And the user enters the wrong email but correct password
    Then the user is not logged in and an error message is displayed



