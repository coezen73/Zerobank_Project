package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class PurchaseForeignCurrencyPage extends BasePage{

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropDown;

    @FindBy(css = "#pc_amount")
    public WebElement amountInputBox;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calculateCostsButton;


}
