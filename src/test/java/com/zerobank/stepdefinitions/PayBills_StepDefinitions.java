package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class PayBills_StepDefinitions {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("The user enters {string} in the {string}")
    public void the_user_enters_in_the(String step, String field) {
        payBillsPage.enterPayStep(step, field);
    }

    @When("The user clicks on the pay button")
    public void the_user_clicks_on_the_pay_button() {
        payBillsPage.payButton.click();
    }

    @Then("The user verifies that the following message is displayed: {string}")
    public void the_user_verifies_that_the_following_message_is_displayed(String string) {
        payBillsPage.verifyMessage(string);
    }
    @When("The user navigates to the {string} tab")
    public void the_user_navigates_to_the_tab(String string) {
        payBillsPage.navigateToPage(string);
    }
    @When("Creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> map) {
        payBillsPage.enterPayeeInfo(map);
    }

    @Then("Following currencies should be available")
    public void following_currencies_should_be_available(List<String> list) {
        payBillsPage.verifyCurrencyOptions(list);

    }

    @When("The user tries to calculate cost without selecting a currency")
    public void the_user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.calculateCostsButton.click();
    }
    @Then("The user verifies that the following alert message is displayed: {string}")
    public void the_user_verifies_that_the_following_alert_message_is_displayed(String string) {
        payBillsPage.verifyAlertMessage(string);
    }
}
