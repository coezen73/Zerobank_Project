package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class AccountSummaryStepDefs {

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {

        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);

        Assert.assertEquals(expectedAccountTypes,actualAccountTypes);
    }

    @Then("the user should see the columns under the Credit Account table")
    public void the_user_should_see_the_columns_under_the_Credit_Account_table(List<String> expectedColumns) {

        List<String> actualColumns = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountColumns);

        Assert.assertEquals(expectedColumns,actualColumns);
    }
}
