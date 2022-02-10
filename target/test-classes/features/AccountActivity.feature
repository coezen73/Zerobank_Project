@ysnblgn
Feature: Account Activity Page

  Background:
    Given the user logged in
    When the user navigates to "Account Activity" Page

  Scenario: Account Activity title
    Then the user should see the title "Zero - Account Activity"

  Scenario: Account dropdown option default value
    Then Account drop down default option should be "Savings"

  Scenario: Account drop down options
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions table columns
    Then the user should see the columns under the Transactions table
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |