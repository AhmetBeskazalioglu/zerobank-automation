package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToPage(String tabName) {
        String tabNameXpath = "//a[.='" + tabName + "']";
        WebElement tabElement = Driver.get().findElement(By.xpath(tabNameXpath));
        tabElement.click();
    }
}
