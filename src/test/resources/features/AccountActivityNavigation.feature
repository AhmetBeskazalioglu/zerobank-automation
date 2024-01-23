@regression @account_activity
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given The user is on the login page

  Scenario Outline: Account types redirect
    When The user enters valid credentials
    And The user clicks on "<account>" link on the Account Summary page
    Then The Account Activity page should be displayed
    And Account drop down should have "<account>" selected

    Examples:
      | account     |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |