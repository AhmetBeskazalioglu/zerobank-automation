@regression @account_summary
Feature: Account Summary
        #As a user, I should be able to see account summary page after login to the application
  Background:
    Given The user is on the login page

  @account_summary1
  Scenario: Account Summary page should have the title Zero - Account Summary
    When The user enters valid credentials
    Then The user verifies that the following title is displayed: "Zero - Account Summary"

  @account_summary2
  Scenario: Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts
    When The user enters valid credentials
    Then The user verifies that the following account types are displayed:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @account_summary3
  Scenario: Credit Accounts table must have columns Account, Credit Card and Balance
    When The user enters valid credentials
    Then The user verifies that the following columns are displayed in Credit Accounts table:
      | Account     |
      | Credit Card |
      | Balance     |
