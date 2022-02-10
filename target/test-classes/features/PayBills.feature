@ysnblgn
Feature: Pay Bills Page

  Background:
    Given the user logged in
    When the user navigates to "Pay Bills" Page


  Scenario: Pay Bills title
    Then the user should see the title "Zero - Pay Bills"

  Scenario: Successful Pay operation
    And the user enters following information
      | Payee       | Apple      |
      | Account     | Savings    |
      | Amount      | 100        |
      | Date        | 2022-02-09 |
      | Description | long-term  |
    And the user clicks Pay button
    Then the user should see the message as "The payment was successfully submitted."

  Scenario: Unsuccessful Pay operation without amount
    And the user enters following information
      | Payee       | Apple      |
      | Account     | Savings    |
      | Amount      |            |
      | Date        | 2022-02-09 |
      | Description | long-term  |
    And the user clicks Pay button
    Then the user should see the message as "Please fill out this field."

  Scenario: Unsuccessful Pay operation without date
    And the user enters following information
      | Payee       | Apple     |
      | Account     | Savings   |
      | Amount      | 100       |
      | Date        |           |
      | Description | long-term |
    And the user clicks Pay button
    Then the user should see the message as "Please fill out this field."

  Scenario: Unsuccessful Pay operation invalid amount
    And the user enters following information
      | Payee       | Apple          |
      | Account     | Savings        |
      | Amount      | %invalidAmount |
      | Date        | 2022-02-09     |
      | Description | long-term      |
    And the user clicks Pay button
    Then the user should not see the message "The payment was successfully submitted."

  Scenario: Unsuccessful Pay operation invalid date
    And the user enters following information
      | Payee       | Apple       |
      | Account     | Savings     |
      | Amount      | 100         |
      | Date        | invalidDate |
      | Description | long-term   |
    And the user clicks Pay button
    Then the user should not see the message "The payment was successfully submitted."
