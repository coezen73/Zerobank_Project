package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class PayBillsPage extends BasePage {

    @FindBy(linkText = "Pay Saved Payee")
    public WebElement paySavedPayee;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "sp_payee")
    public WebElement payeeDropDown;

    @FindBy(id = "sp_account")
    public WebElement accountDropDown;

    @FindBy(id = "sp_amount")
    public WebElement amountInputBox;

    @FindBy(id = "sp_date")
    public WebElement dateInputBox;

    @FindBy(id = "sp_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath="//div[@id='alert_content']")
    public WebElement successMessage;



}
