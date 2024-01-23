

---

# ZeroBankAutomation

This project is an automated testing framework for the Zero online banking application, using Cucumber BDD and Selenium. The framework is designed to test various functionalities of the Zero online banking application.

## Project Setup

### Maven Project

Create a Maven project with the following details:

- Group ID: com.zerobank
- Artifact ID: zerobankautomation

Add the necessary dependencies for Cucumber and Selenium to the `pom.xml` file, and include plugins for HTML reporting with Cucumber.

### Project Structure

The project structure includes the following packages under `src/test/java`:

- `com.zerobank.pages`
- `com.zerobank.runners`
- `com.zerobank.stepdefinitions`
- `com.zerobank.utilities`

In addition, create a `resources` directory under `src/test` and mark it as a test resource folder. Inside `src/test/resources`, create a folder named `features`.

Create a `configuration.properties` file under the project folder. The project also includes utility classes:
- `ConfigurationReader`: Reads from the properties file.
- `Driver`: Creates a new WebDriver object based on values from `configuration.properties`.
- `BrowserUtils`: Includes various utility methods.

Create a `CukesRunner` class under the `runners` package, using any necessary Cucumber options.

## Feature Files

Write feature files based on the following requirements. Each feature file corresponds to a specific requirement and may contain multiple scenarios.

### Login

- Only authorized users should be able to log in to the application.
- When a user logs in with valid credentials, the Account Summary page should be displayed.
- Users with incorrect usernames or passwords should not be able to log in.
- Users with blank usernames or passwords should not be able to log in.
- When a user tries to log in with invalid information, an error message should be displayed.

### Account Summary

- The Account Summary page should have the title "Zero – Account Summary."
- Account Summary should display Cash Accounts, Investment Accounts, Credit Accounts, and Loan Accounts.
- The Credit Accounts table must have columns for Account, Credit Card, and Balance.

### Account Activity

- The Account Activity page should have the title "Zero – Account Activity."
- The Account dropdown's default option should be Savings.
- Account dropdown should have options: Savings, Checking, Loan, Credit Card, Brokerage.
- The Transactions table should have columns for Date, Description, Deposit, and Withdrawal.

### Pay Bills

- The Pay Bills page should have the title "Zero – Pay Bills."
- After a successful Pay operation, a success message should be displayed.
- When a user tries to make a payment without entering the amount or date, an error message should be displayed.
- The Amount field should not accept alphabetical or special characters.
- The Date field should not accept alphabetical characters.

## Test Data

The test data includes the following properties in the `configuration.properties` file:

- browser=chrome
- url=http://zero.webappsecurity.com/
- userName=username
- passWord=password

**Note**: After entering the URL, user credentials, and clicking the Sign-in button, navigate to http://zero.webappsecurity.com/bank/accountsummary.html.

---

