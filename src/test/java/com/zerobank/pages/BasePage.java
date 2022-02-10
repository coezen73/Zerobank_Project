package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

//    @FindBy(linkText = "Account Summary")
//    public WebElement accountSummary;
//
//    @FindBy(linkText = "Account Activity")
//    public WebElement accountActivity;

    @FindBy(xpath = "//i[@class='icon-user']/..")
    public WebElement userName;

    @FindBy(id = "logout_link")
    public WebElement logoutLink;

    public String getUserName() {
        return userName.getText();
    }

    public void logout() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logoutLink);
    }

    public void navigateTo(String tab) {

        String tabLocator = "//a[.='" + tab + "']";
        BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
        Driver.get().findElement(By.xpath(tabLocator)).click();

    }
}
