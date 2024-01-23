@regression @add_payee
Feature: Add new payee under pay bills

  Background:
    Given The user is on the login page

  Scenario Outline: Add a new payee
    When The user enters valid credentials
    And The user navigates to the "Pay Bills" page
    And The user navigates to the "Add New Payee" tab
    And Creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then The user verifies that the following message is displayed: "<message>"
    Examples:
      | message                                                                          |
      | The new payee The Law Offices of Hyde, Price & Scharks was successfully created. |
