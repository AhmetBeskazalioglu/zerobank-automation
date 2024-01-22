package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();
    }

    @When("The user enters {string} and {string} as invalid or blank credentials")
    public void the_user_enters_and_as_invalid_or_blank_credentials(String string, String string2) {
        loginPage.negativeLogin(string, string2);
    }

    @Then("The user should be able to see the {string}")
    public void the_user_should_be_able_to_see_the(String string) {
        loginPage.verifyErrorMessage(string);
    }
}
