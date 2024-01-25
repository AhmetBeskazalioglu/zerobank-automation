package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class AccountActivity_StepDefinitions {
AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("The Account Activity page should be displayed")
    public void the_account_activity_page_should_be_displayed() {
        accountActivityPage.verifyAccountActivityPage();
    }
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        accountActivityPage.verifyDefaultOption(string);
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

    @When("The user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        accountActivityPage.enterDateRange(string, string2);
    }

    @When("The user clicks search")
    public void clicks_search() {
        accountActivityPage.findButton.click();
    }

    @Then("Results table should only show transactions dates between {string} and {string}")
    public void results_table_should_only_show_transactions_dates_between_and(String fromDate, String toDate) {
        accountActivityPage.verifyDateRange(fromDate, toDate);
    }

    @Then("The results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        accountActivityPage.verifySortedByDate();
    }

    @When("The user enters description “ONLINE”")
    public void the_user_enters_description_online() {
        accountActivityPage.enterDescription("ONLINE");
    }
    @Then("Results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_online() {
        accountActivityPage.verifyDescription("ONLINE");
    }

    @Then("Results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_deposit() {
        accountActivityPage.verifyDeposit();
    }
    @Then("Results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_withdrawal() {
        accountActivityPage.verifyWithdrawal();
    }

    @When("The user selects type “Deposit” and clicks on Find")
    public void the_user_selects_type_deposit_and_clicks_on_find() {
        accountActivityPage.selectDeposit();
    }
    @Then("Results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_withdrawal() {
        accountActivityPage.verifyNoWithdrawal();
    }

    @When("The user selects type “Withdrawal” and clicks on Find")
    public void the_user_selects_type_withdrawal_and_clicks_on_find() {
        accountActivityPage.selectWithdrawal();
    }
    @Then("Results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_deposit() {
        accountActivityPage.verifyNoDeposit();
    }

}
