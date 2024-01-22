package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        payBillsPage.verifyErrorMessage(string);
    }
}
