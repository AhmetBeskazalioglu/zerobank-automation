package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class AccountActivity_StepDefinitions {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("The user navigates to the {string} page")
    public void the_user_navigates_to_the_page(String string) {
        accountActivityPage.navigateToPage(string);
    }

    @Then("The user verifies that the default option in the Account drop down is {string}")
    public void the_user_verifies_that_the_default_option_in_the_account_drop_down_is(String string) {
        accountActivityPage.verifyDefaultOption(string);
    }

    @Then("The user verifies that the Account drop down has the following options:")
    public void the_user_verifies_that_the_account_drop_down_has_the_following_options(List<String> list) {
        accountActivityPage.verifyOptions(list);
    }
    @Then("The user verifies that the Transactions table has the following column names:")
    public void the_user_verifies_that_the_transactions_table_has_the_following_column_names(List<String> list) {
        accountActivityPage.verifyTransactionTableColumns(list);
    }
}
