package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

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

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInputBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccountInputBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayeeButton;

    @FindBy(id = "alert_content")
    public WebElement alertContent;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

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

    public void verifyMessage(String string) {
        if (string.startsWith("The new payee")) {
            Assert.assertEquals(string, alertContent.getText());
        } else if (string.startsWith("The payment was")) {
            Assert.assertEquals(string, successMessage.getText());
        } else if (string.startsWith("Please fill out")) {
            if (amount.getAttribute("validationMessage").isEmpty()) {
                Assert.assertEquals(string, date.getAttribute("validationMessage"));
            } else if (date.getAttribute("validationMessage").isEmpty()) {
                Assert.assertEquals(string, amount.getAttribute("validationMessage"));
            }
        }
    }

    public void enterPayeeInfo(Map<String, String> map) {
        payeeNameInputBox.sendKeys(map.get("Payee Name"));
        payeeAddressInputBox.sendKeys(map.get("Payee Address"));
        payeeAccountInputBox.sendKeys(map.get("Account"));
        payeeDetailsInputBox.sendKeys(map.get("Payee details"));
        addNewPayeeButton.click();
    }

    public void verifyCurrencyOptions(List<String> list) {
        Select select = new Select(currencyDropdown);
        List<WebElement> options = select.getOptions();
        List<String> actualOptions = BrowserUtils.getElementsText(options);
        List<String> expectedOptions = list;
        Assert.assertTrue(actualOptions.containsAll(expectedOptions));

    }

    public void verifyAlertMessage(String string) {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals(string, alert.getText());
    }


}
