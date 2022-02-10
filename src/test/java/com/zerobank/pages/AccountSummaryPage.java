package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class AccountSummaryPage extends BasePage {


    @FindBy(xpath = "//h2")//--> h2.board-header
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//thead)[3]//th")//--> //h2[.='Credit Accounts']/../div[3]//th
    public List<WebElement> creditAccountColumns;

    @FindBy(xpath = "(//a[.='Savings'])[1]")
    public WebElement savings;

    @FindBy(xpath = "(//a[.='Brokerage'])[1]")
    public WebElement brokerage;

    @FindBy(xpath = "(//a[.='Checking'])[1]")
    public WebElement checking;

    @FindBy(xpath = "(//a[.='Credit Card'])[1]")
    public WebElement creditCard;

    @FindBy(xpath = "(//a[.='Loan'])[1]")
    public WebElement loan;
}
