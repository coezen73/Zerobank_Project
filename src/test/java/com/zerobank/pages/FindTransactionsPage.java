package com.zerobank.pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class FindTransactionsPage extends BasePage {

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement typeDropDown;

    @FindBy(xpath ="//button[@type='submit'] " )
    public WebElement searchButton;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[1]")
    public List<WebElement> dateColumnData;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[2]")
    public List<WebElement> descriptionColumnData;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]")
    public List<WebElement> depositColumnData;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]")
    public List<WebElement> withdrawalColumnData;






}
