package com.zerobank.step_definitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class FindTransactionsStepDefs {

    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginPage().login();
        new DashBoardPage().navigateTo("Account Activity");
        new AccountActivityPage().findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        findTransactionsPage.fromDate.sendKeys(fromDate);
        findTransactionsPage.toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactionsPage.searchButton.click();
        BrowserUtils.waitFor(2);
        findTransactionsPage.fromDate.clear();
        findTransactionsPage.toDate.clear();
        findTransactionsPage.description.clear();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        List<String> actualElements = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);
        for (String str : actualElements) {
            Assert.assertTrue(str.compareTo(fromDate)>=0 && str.compareTo(toDate)<=0);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        List<String> actualDates = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);
        List<String> expectedDates = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);

        Collections.sort(expectedDates);
        Collections.reverse(expectedDates);
//        for (String expectedDate : expectedDates) {
//            System.out.println("expectedDate = " + expectedDate);
//
//        }
        Assert.assertEquals(expectedDates,actualDates);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String notInclude) {
        List<String> dateElements = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);
        for (String dateElement : dateElements) {
            Assert.assertFalse(dateElement.contains(notInclude));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        findTransactionsPage.description.sendKeys(str.toUpperCase());
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String str) {
        List<String> containsElements = BrowserUtils.getElementsText(findTransactionsPage.descriptionColumnData);
        for (String containsElement : containsElements) {
            Assert.assertTrue(containsElement.contains(str));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String notInclude) {
        List<String> descriptionElements = BrowserUtils.getElementsText(findTransactionsPage.descriptionColumnData);
        for (String descriptionElement : descriptionElements) {
            Assert.assertFalse(descriptionElement.contains(notInclude));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String str) {

        switch (str.toLowerCase()){
            case "deposit":
                Assert.assertTrue(findTransactionsPage.depositColumnData.size()>0);
                break;
            case "withdrawal":
                Assert.assertTrue(findTransactionsPage.withdrawalColumnData.size() > 0);
                break;

        }
    }

    @When("user selects type {string}")
    public void user_selects_type(String typeStr) {
        Select select = new Select(findTransactionsPage.typeDropDown);
        select.selectByVisibleText(typeStr);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {

        switch (string){
            case "Withdrawal":
                for (String str : BrowserUtils.getElementsText(findTransactionsPage.withdrawalColumnData)) {
                    Assert.assertTrue(str.isEmpty());
                }
                break;

            case "Deposit":
                for (String str : BrowserUtils.getElementsText(findTransactionsPage.depositColumnData)) {
                    Assert.assertTrue(str.isEmpty());
                }
                break;
        }

    }


}
