package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class AccountActivityStepDefs extends BasePage {


    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountLink) {
        BrowserUtils.waitFor(2);
        switch (accountLink) {
            case "Savings":
                new AccountSummaryPage().savings.click();
                break;
            case "Brokerage":
                new AccountSummaryPage().brokerage.click();
                break;
            case "Checking":
                new AccountSummaryPage().checking.click();
                break;
            case "Credit Card":
                new AccountSummaryPage().creditCard.click();
                break;
            case "Loan":
                new AccountSummaryPage().loan.click();
                break;

        }
    }

    @When("the user navigates to {string} Page")
    public void the_user_navigates_to_Page(String tabName) {
        navigateTo(tabName);
    }

    @Then("Account drop down default option should be {string}")
    public void account_drop_down_default_option_should_be(String expectedDefaultOption) {
        Select select = new Select(new AccountActivityPage().dropDownOption);
        Assert.assertEquals(expectedDefaultOption, select.getFirstSelectedOption().getText());
    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        Select select = new Select(new AccountActivityPage().dropDownOption);

        Assert.assertEquals(expectedOptions, BrowserUtils.getElementsText(select.getOptions()));
    }

    @Then("the user should see the columns under the Transactions table")
    public void the_user_should_see_the_columns_under_the_Transactions_table(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(new AccountActivityPage().transactionsTableColumns);
        Assert.assertEquals(expectedColumns, actualColumns);
    }
}
