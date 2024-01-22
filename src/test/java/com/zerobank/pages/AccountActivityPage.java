package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//thead[1]//th")
    public List<WebElement> transactionTableColumns;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInputBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInputBox;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmountInputBox;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmountInputBox;

    @FindBy(id = "aa_type")
    public WebElement typeDropdown;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findButton;


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

    public void navigateToTransactionsTab() {
        findTransactionsTab.click();
        BrowserUtils.waitFor(1);
    }

    public void verifyTransactionTableColumns(List<String> list) {
        List<String> actualColumns = BrowserUtils.getElementsText(transactionTableColumns);
        List<String> expectedColumns = list;
        Assert.assertEquals(expectedColumns, actualColumns);
    }

    public void enterDateRange(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        String fromDate = int1 + "-" + int2 + "-" + int3;
        String toDate = int4 + "-" + int5 + "-" + int6;
        fromDateInputBox.sendKeys(fromDate);
        toDateInputBox.sendKeys(toDate);
        findButton.click();

    }

    public void verifyDateRange(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        String fromDate = int1 + "-" + int2 + "-" + int3;
        String toDate = int4 + "-" + int5 + "-" + int6;
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[1]"));
        for (WebElement date : dates) {
            String actualDate = date.getText();
            if (actualDate.compareTo(fromDate) >= 0 && actualDate.compareTo(toDate) <= 0) {
                Assert.assertTrue(actualDate.compareTo(fromDate) >= 0 && actualDate.compareTo(toDate) <= 0);
            } else {
                Assert.assertFalse(actualDate.compareTo(fromDate) >= 0 && actualDate.compareTo(toDate) <= 0);
            }
        }
    }

    public void verifySortedByDate() {
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[1]"));
        for (int i = 0; i < dates.size() - 1; i++) {
            String date1 = dates.get(i).getText();
            String date2 = dates.get(i + 1).getText();
            Assert.assertTrue(date1.compareTo(date2) >= 0);
        }
    }

    public void enterDescription(String string) {
        descriptionInputBox.sendKeys(string);
        findButton.click();
    }

    public void verifyDescription(String string) {
        List<WebElement> descriptions = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[2]"));
        for (WebElement description : descriptions) {
            String actualDescription = description.getText();
            if (actualDescription.contains(string)) {
                Assert.assertTrue(actualDescription.contains(string));
            } else {
                Assert.assertFalse(actualDescription.contains(string));
            }
        }
    }

    public void verifyDeposit() {
        List<WebElement> deposits = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[3]"));
        for (WebElement deposit : deposits) {
            String actualDeposit = deposit.getText();
            if (!actualDeposit.isEmpty()) {
                Assert.assertFalse(actualDeposit.isEmpty());
            }

        }
    }

    public void verifyWithdrawal() {
        List<WebElement> withdrawals = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[4]"));
        for (WebElement withdrawal : withdrawals) {
            String actualWithdrawal = withdrawal.getText();
            if (!actualWithdrawal.isEmpty()) {
                Assert.assertFalse(actualWithdrawal.isEmpty());
            }
        }
    }

    public void selectDeposit() {
        Select select = new Select(typeDropdown);
        select.selectByVisibleText("Deposit");
        findButton.click();
    }

    public void verifyNoWithdrawal() {
        List<WebElement> withdrawals = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[4]"));
        for (WebElement withdrawal : withdrawals) {
            String actualWithdrawal = withdrawal.getText();
            Assert.assertTrue(actualWithdrawal.isEmpty());
        }
    }

    public void selectWithdrawal() {
        Select select = new Select(typeDropdown);
        select.selectByVisibleText("Withdrawal");
        findButton.click();
    }

    public void verifyNoDeposit() {
        List<WebElement> deposits = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[3]"));
        for (WebElement deposit : deposits) {
            String actualDeposit = deposit.getText();
            Assert.assertTrue(actualDeposit.isEmpty());
        }
    }

}
