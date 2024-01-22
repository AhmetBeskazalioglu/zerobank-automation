package com.zerobank.pages;


import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement emailInputBox;

    @FindBy(id = "user_password")
    public WebElement passwordInputBox;

    @FindBy(name = "submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    public void login(){
        signInButton.click();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        emailInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
        BrowserUtils.waitForPageToLoad(10);
        Driver.get().get(" http://zero.webappsecurity.com/bank/account-summary.html");
    }

    public void login(String username, String password){
        signInButton.click();
        emailInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
        BrowserUtils.waitForPageToLoad(10);
        Driver.get().get(" http://zero.webappsecurity.com/bank/account-summary.html");
    }

    public void negativeLogin(String username, String password){
        signInButton.click();
        emailInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
    public void verifyErrorMessage(String string){
        String actualMessage = errorMessage.getText();
        String expectedMessage = string;
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
