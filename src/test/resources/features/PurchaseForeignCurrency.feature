@regression @purchase
Feature: Purchase Foreign Currency

  Background:
    Given The user is on the login page

  @purchase1
  Scenario: Available currencies
    When The user enters valid credentials
    And The user navigates to the "Pay Bills" page
    And The user navigates to the "Purchase Foreign Currency" tab
    Then Following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  @purchase2
  Scenario Outline: Error message for not selecting currency
    When The user enters valid credentials
    And The user navigates to the "Pay Bills" page
    And The user navigates to the "Purchase Foreign Currency" tab
    And The user tries to calculate cost without selecting a currency
    Then The user verifies that the following alert message is displayed: "<message>"
    Examples:
      | message                                                                        |
      | Please, ensure that you have filled all the required fields with valid values. |
