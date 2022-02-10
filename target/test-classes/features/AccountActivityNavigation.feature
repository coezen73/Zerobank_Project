@ysnblgn
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user logged in

  Scenario: Savings account redirect
    When the user clicks on "Savings" link on the Account Summary page
    Then the user should see the title "Zero - Account Activity"
    And Account drop down default option should be "Savings"

  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the user should see the title "Zero - Account Activity"
    And Account drop down default option should be "Brokerage"

  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the user should see the title "Zero - Account Activity"
    And Account drop down default option should be "Checking"

  Scenario: Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the user should see the title "Zero - Account Activity"
    And Account drop down default option should be "Credit Card"

  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the user should see the title "Zero - Account Activity"
    And Account drop down default option should be "Loan"