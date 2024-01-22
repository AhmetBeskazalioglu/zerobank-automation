package com.zerobank.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage {

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//span[.='The payment was successfully submitted.']")
    public WebElement successMessage;

    public void enterPayStep(String step, String field) {
        switch (step) {
            //Amount field should not accept alphabetical or special characters.
            case "Amount":
                if (field.matches("[0-9]+")) {
                    amount.sendKeys(field);
                } else
                    Assert.assertFalse("Amount field should not accept alphabetical or special characters.", false);
                break;
            //Date field should not accept alphabetical characters.
            case "Date":
                if (!field.matches("[a-zA-Z]+")) {
                    date.sendKeys(field);
                } else
                    Assert.assertFalse("Date field should not accept alphabetical characters.", false);
                break;
            case "Description":
                description.sendKeys(field);
                break;
        }
    }

    public void verifyErrorMessage(String string) {
        if (amount.getAttribute("validationMessage").isEmpty()) {
            Assert.assertEquals(string, date.getAttribute("validationMessage"));
        } else if (date.getAttribute("validationMessage").isEmpty()) {
            Assert.assertEquals(string, amount.getAttribute("validationMessage"));
        } else
            Assert.assertEquals(string, successMessage.getText());
    }


}
