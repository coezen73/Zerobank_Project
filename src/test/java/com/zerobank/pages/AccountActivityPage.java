package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class AccountActivityPage extends BasePage {

    @FindBy(css = "#aa_accountId")
    public WebElement dropDownOption;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> transactionsTableColumns;

    @FindBy(linkText = "Show Transactions")
    public WebElement showTransactions;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;
}
