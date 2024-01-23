@regression @account_activity
Feature: Account Activity
    #As a user I want to be able to view my account activity, So that I can keep track of my money

  Background:
    Given The user is on the login page

  @account_activity1
  Scenario: Account Activity page should have the title Zero – Account activity
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    Then The user verifies that the following title is displayed: "Zero - Account Activity"

  @account_activity2
  Scenario: Account drop down default option should be Savings
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    Then The user verifies that the default option in the Account drop down is "Savings"

  @account_activity3
  Scenario: Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    Then The user verifies that the Account drop down has the following options:
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  @account_activity4
  Scenario: Transactions table should have column names Date, Description, Deposit, Withdrawal.
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    Then The user verifies that the Transactions table has the following column names:
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
