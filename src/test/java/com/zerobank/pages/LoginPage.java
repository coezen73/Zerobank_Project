package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "signin_button") //button[id='signin_button']
    public WebElement signInButton;

    @FindBy(css = "input[id='user_login']")
    public WebElement loginInputBox;

    @FindBy(css = "input[id='user_password']")
    public WebElement passwordInputBox;

    @FindBy(css = "input[type='submit']")
    public WebElement submitButton;

    @FindBy(css = "button[id='details-button']")
    public WebElement advancedButton;

    @FindBy(css = "a[id='proceed-link']")
    public WebElement proceedLink;

    @FindBy(css = "div.alert.alert-error")
    public WebElement errorMessage;

    public void login(){
        signInButton.click();
        loginInputBox.sendKeys(ConfigurationReader.get("username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
        advancedButton.click();
        proceedLink.click();
        BrowserUtils.waitFor(2);
    }

    public void login(String username,String password){
        signInButton.click();
        loginInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        submitButton.click();
        if(username.equals(ConfigurationReader.get("username")) && password.equals(ConfigurationReader.get("password"))){
            advancedButton.click();
            proceedLink.click();
        }
    }
}
