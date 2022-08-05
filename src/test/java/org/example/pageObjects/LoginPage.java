package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver webDriver;
    public LoginPage(WebDriver drive)
    {
        webDriver = drive;
        PageFactory.initElements(drive, this);
    }
    @FindBy(name = "uid")
    @CacheLookup
    WebElement enterUserName;
    @FindBy(name = "password")
    @CacheLookup
    WebElement enterPassword;
    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement clickEnterButton;
    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement clickLogoutButton;

    public void setEnterUserName(String uname) {
        enterUserName.sendKeys(uname);
    }

    public void setEnterPassword(String pwd) {
        enterPassword.sendKeys(pwd);
    }

    public void clickSubmit() { clickEnterButton.click(); }

    public void clickLogout() { clickLogoutButton.click(); }



}
