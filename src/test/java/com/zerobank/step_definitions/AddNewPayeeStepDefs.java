package com.zerobank.step_definitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.DashBoardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new LoginPage().login();
        new DashBoardPage().navigateTo("Pay Bills");
        new PayBillsPage().addNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> expectedInformation) {
        new AddNewPayeePage().payeeNameInputBox.sendKeys(expectedInformation.get("Payee Name"));
        new AddNewPayeePage().payeeAddressInputBox.sendKeys(expectedInformation.get("Payee Address"));
        new AddNewPayeePage().accountInputBox.sendKeys(expectedInformation.get("Account"));
        new AddNewPayeePage().payeeDetailsInputBox.sendKeys(expectedInformation.get("Payee details"));
        new AddNewPayeePage().addButton.click();

    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        Assert.assertEquals(expectedMessage,new PayBillsPage().successMessage.getText());
    }
}
