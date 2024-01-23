@regression @login
Feature: Login
    # As a user I want to login to the application, So that I can access my account
  Background:
    Given The user is on the login page

  @login1
  Scenario: Login with valid credentials
    When The user enters valid credentials
    Then The user should be able to see the account summary page

  @login2
  Scenario Outline: Login with invalid credentials
    When The user enters "<username>" and "<password>" as invalid or blank credentials
    Then The user should be able to see the "<error message>"
    Examples:
      | username      | password      | error message                    |
      | wrongUsername | password      | Login and/or password are wrong. |
      | username      | wrongPassword | Login and/or password are wrong. |
      | wrongUsername | wrongPassword | Login and/or password are wrong. |
      | username      |               | Login and/or password are wrong. |
      |               | password      | Login and/or password are wrong. |
      |               |               | Login and/or password are wrong. |






