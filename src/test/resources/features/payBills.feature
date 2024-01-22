@regression
Feature: Pay Bills
    # As a user I want to pay bills, So that I can pay my bills online

  Background:
    Given The user is on the login page

  @pay_bills1
  Scenario: Account Activity page should have the title Zero – Account activity
    When The user enters valid credentials
    And The user navigates to the "Pay Bills" page
    Then The user verifies that the following title is displayed: "Zero - Pay Bills"

  @pay_bills2
  Scenario Outline: The payment was successfully submitted.
    When The user enters valid credentials
    And The user navigates to the "Pay Bills" page
    And The user enters "Amount" in the "<Amount>"
    And The user enters "Date" in the "<Date>"
    And The user enters "Description" in the "<Description>"
    And The user clicks on the pay button
    Then The user verifies that the following message is displayed: "<Message>"
    Examples:
      | Amount | Date       | Description     | Message                                 |
      | 1000   | 2020-01-01 | Paying my bills | The payment was successfully submitted. |
      |        | 2020-01-01 | Paying my bills | Please fill out this field.             |
      | 1000   |            | Paying my bills | Please fill out this field.             |
      | abc    | 2020-01-01 | Paying my bills | Please fill out this field.             |
      | +-     | 2020-01-01 | Paying my bills | Please fill out this field.             |
      | 1000   | abc        | Paying my bills | Please fill out this field.             |