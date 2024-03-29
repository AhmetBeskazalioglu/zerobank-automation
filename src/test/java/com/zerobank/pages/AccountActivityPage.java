package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(css = ".board-header")
    public WebElement accountActivityPageHeader;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//thead[1]//th")
    public List<WebElement> transactionTableColumns;

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

    public void verifyTransactionTableColumns(List<String> list) {
        List<String> actualColumns = BrowserUtils.getElementsText(transactionTableColumns);
        List<String> expectedColumns = list;
        Assert.assertEquals(expectedColumns, actualColumns);
    }

    public void enterDateRange(String string, String string2) {
        fromDateInputBox.sendKeys(string);
        toDateInputBox.sendKeys(string2);
    }


    public void verifyDateRange(String fromDate, String toDate) {
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[1]"));
        for (WebElement date : dates) {
            String actualDate = date.getAttribute("innerText");
            boolean isBetween = (actualDate.compareTo(fromDate) >= 0) && (actualDate.compareTo(toDate) <= 0);
            Assert.assertTrue(isBetween);
        }

    }

    public void verifySortedByDate() {
        // The results should be sorted by most recent date
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']//td[1]"));
        for (int i = 0; i < dates.size() - 1; i++) {
            String date1 = dates.get(i).getAttribute("innerText");
            String date2 = dates.get(i + 1).getAttribute("innerText");
            boolean isSorted = date1.compareTo(date2) >= 0;
            Assert.assertTrue(isSorted);
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

    public void verifyAccountActivityPage(){
        String expectedHeader = "Show Transactions";
        String actualHeader = accountActivityPageHeader.getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }
}
