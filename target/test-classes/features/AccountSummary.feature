@ysnblgn
Feature: Account Summary Page

  Background:
    Given the user logged in

  Scenario: Account Summary title
    Then the user should see the title "Zero - Account Summary"

  Scenario: Account types
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table columns
    Then the user should see the columns under the Credit Account table
      | Account     |
      | Credit Card |
      | Balance     |
