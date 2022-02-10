package com.zerobank.step_definitions;

import com.zerobank.pages.DashBoardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class PurchaseForeignCurrencyStepDefs {

    PurchaseForeignCurrencyPage page = new PurchaseForeignCurrencyPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new LoginPage().login();
        new DashBoardPage().navigateTo("Pay Bills");
        new PayBillsPage().purchaseForeignCurrency.click();

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencies) {
        Select select = new Select(page.currencyDropDown);

        Assert.assertTrue(BrowserUtils.getElementsText(select.getOptions()).containsAll(expectedCurrencies));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        page.amountInputBox.sendKeys("100");
        page.calculateCostsButton.click();

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select = new Select(page.currencyDropDown);
        select.selectByIndex(5);
        page.calculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
    }



}
