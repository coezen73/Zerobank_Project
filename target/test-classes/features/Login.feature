@ysnblgn
Feature: Login with different scenarios

  @Positive
  Scenario: Login with valid credentials
    Given the user logged in "username" and "password"
    Then the user should see the title "Zero - Account Summary"

  @Negative
  Scenario Outline: Login with invalid credentials
    Given the user logged in "<username>" and "<password>"
    Then the user should see the message "Login and/or password are wrong."
    And the user should see the title "Zero - Log in"

    Examples:
      | username      | password      |
      | wrongusername | wrongpassword |
      | wrongusername | password      |
      | username      | wrongpassword |
      | username      |               |
      |               | password      |
      |               |               |


