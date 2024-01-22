package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[.='Account Summary']")
    public WebElement accountSummary;

    @FindBy(xpath = "//a[.='Account Activity']")
    public WebElement accountActivity;

    @FindBy(xpath = "//a[.='Transfer Funds']")
    public WebElement transferFunds;

    @FindBy(xpath = "//a[.='Pay Bills']")
    public WebElement payBills;

    @FindBy(xpath = "//a[.='My Money Map']")
    public WebElement myMoneyMap;

    @FindBy(xpath = "//a[.='Online Statements']")
    public WebElement onlineStatements;

    public void navigateToPage(String tabName) {
        String tabNameXpath = "//a[.='" + tabName + "']";
        WebElement tabElement = Driver.get().findElement(By.xpath(tabNameXpath));
        tabElement.click();
    }

    public String getPageTitle() {
        return Driver.get().getTitle();
    }

    public String getPageHeader() {
        return Driver.get().findElement(By.cssSelector("h2.board-header")).getText();
    }

    public String getAccountName(String accountName) {
        return Driver.get().findElement(By.xpath("//a[.='" + accountName + "']")).getText();
    }

    public String getAccountBalance(String accountName) {
        return Driver.get().findElement(By.xpath("//a[.='" + accountName + "']/../following-sibling::td[1]")).getText();
    }

    public String getAccountCurrency(String accountName) {
        return Driver.get().findElement(By.xpath("//a[.='" + accountName + "']/../following-sibling::td[1]")).getText();
    }


}
