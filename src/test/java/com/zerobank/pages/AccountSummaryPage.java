package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//div[@class='offset2 span8']/div[3]//th")
    public List<WebElement> columns;

    public void verifyAccountSummaryPage() {
        String actualURL = Driver.get().getCurrentUrl();
        String expectedURL = "http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertEquals(expectedURL, actualURL);
    }

    public void verifyTitle(String string) {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = string;
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public void verifyAccountTypes(List<String> list) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountTypes);
        List<String> expectedAccountTypes = list;
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }

    public void verifyColumns(List<String> list) {
        List<String> actualColumns = BrowserUtils.getElementsText(columns);
        List<String> expectedColumns = list;
        Assert.assertEquals(expectedColumns, actualColumns);
    }

}
