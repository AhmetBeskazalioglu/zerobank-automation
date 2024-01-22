package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//thead[1]//th")
    public List<WebElement> transactionTableColumns;


    public void verifyDefaultOption(String string) {
        Select select = new Select(accountDropdown);
        String actualOption = select.getFirstSelectedOption().getText();
        String expectedOption = string;
        Assert.assertEquals(expectedOption, actualOption);
    }

    public void verifyOptions(List<String> list) {
        Select select = new Select(accountDropdown);
        List<WebElement> options = select.getOptions();
        List<String> actualOptions = BrowserUtils.getElementsText(options);
        List<String> expectedOptions = list;
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    public void verifyTransactionTableColumns(List<String> list) {
        List<String> actualColumns = BrowserUtils.getElementsText(transactionTableColumns);
        List<String> expectedColumns = list;
        Assert.assertEquals(expectedColumns, actualColumns);
    }

}
