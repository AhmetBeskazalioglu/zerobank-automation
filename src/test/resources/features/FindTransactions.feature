@regression @find_transactions
Feature: Find Transactions in Account Activity

  Background:
    Given The user is on the login page

  @find_transactions1
  Scenario Outline: Account Activity page should have the title Zero – Account activity
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    And The user navigates to the "Find Transactions" tab
    And The user enters date range from "<fromDate>" to "<toDate>"
    And The user clicks search
    Then Results table should only show transactions dates between "<fromDate>" and "<toDate>"
    And The results should be sorted by most recent date
    Examples:
      | fromDate   | toDate     |
      | 2012-09-01 | 2012-09-06 |


  @find_transactions2
  Scenario: Search description
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    And The user navigates to the "Find Transactions" tab
    And The user enters description “ONLINE”
    And The user clicks search
    Then Results table should only show descriptions containing “ONLINE”

  @find_transactions3
  Scenario: Type-1
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    And The user navigates to the "Find Transactions" tab
    And The user clicks search
    Then Results table should show at least one result under Deposit
    Then Results table should show at least one result under Withdrawal

  @find_transactions4
  Scenario: Type-2
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    And The user navigates to the "Find Transactions" tab
    And The user selects type “Deposit” and clicks on Find
    Then Results table should show at least one result under Deposit
    But Results table should show no result under Withdrawal

  @find_transactions5
  Scenario: Type-3
    When The user enters valid credentials
    And The user navigates to the "Account Activity" page
    And The user navigates to the "Find Transactions" tab
    When The user selects type “Withdrawal” and clicks on Find
    Then Results table should show at least one result under Withdrawal
    But Results table should show no result under Deposit