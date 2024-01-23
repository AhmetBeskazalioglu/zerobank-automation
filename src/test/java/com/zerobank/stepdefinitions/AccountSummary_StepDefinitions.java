package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class AccountSummary_StepDefinitions {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("The user should be able to see the account summary page")
    public void the_user_should_be_able_to_see_the_account_summary_page() {
        accountSummaryPage.verifyAccountSummaryPage();
    }
    @Then("The user verifies that the following title is displayed: {string}")
    public void the_user_verifies_that_the_following_title_is_displayed(String string) {
        accountSummaryPage.verifyTitle(string);
    }
    @Then("The user verifies that the following account types are displayed:")
    public void the_user_verifies_that_the_following_account_types_are_displayed(List<String> list) {
        accountSummaryPage.verifyAccountTypes(list);
    }
    @Then("The user verifies that the following columns are displayed in Credit Accounts table:")
    public void the_user_verifies_that_the_following_columns_are_displayed_in_Credit_Accounts_table(List<String> list) {
       accountSummaryPage.verifyColumns(list);
    }
    @When("The user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_account_summary_page(String string) {
        accountSummaryPage.navigateToPage(string);
    }
    @When("The user navigates to the {string} page")
    public void the_user_navigates_to_the_page(String string) {
        accountSummaryPage.navigateToPage(string);
    }
}
