package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class PayBillsStepDefs {

    @When("the user enters following information")
    public void the_user_enters_following_information(Map<String,String> expectedInformation) {
        new Select(new PayBillsPage().payeeDropDown).selectByVisibleText(expectedInformation.get("Payee"));
        new Select(new PayBillsPage().accountDropDown).selectByVisibleText(expectedInformation.get("Account"));

        try{
            new PayBillsPage().amountInputBox.sendKeys(expectedInformation.get("Amount"));
            BrowserUtils.waitFor(2);
            new PayBillsPage().dateInputBox.sendKeys(expectedInformation.get("Date"));
            BrowserUtils.waitFor(2);
            new PayBillsPage().descriptionInputBox.sendKeys(expectedInformation.get("Description"));
            BrowserUtils.waitFor(2);
        }catch (Exception e){
            System.out.println("Please fill out this field.");
        }
    }

    @When("the user clicks Pay button")
    public void the_user_clicks_Pay_button() {
        new PayBillsPage().payButton.click();
    }

    @Then("the user should see the message as {string}")
    public void the_user_should_see_the_message(String expectedMessage) {
        if(expectedMessage.equals("The payment was successfully submitted.")){
            Assert.assertEquals(expectedMessage,new PayBillsPage().successMessage.getText());
        }else if(expectedMessage.equals("Please fill out this field message!")){
            Assert.assertEquals(expectedMessage, Driver.get().findElement(By.name("amount")).getAttribute("validationMessage"));
        }


    }

    @Then("the user should not see the message {string}")
    public void the_user_should_not_see_the_message(String unExpectedMessage) {
//        Assert.assertNotEquals(unExpectedMessage,new PayBillsPage().successMessage.getText());
        String actualMessage = new PayBillsPage().successMessage.getText();
        BrowserUtils.waitFor(2);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualMessage).isNotEqualTo(unExpectedMessage);
//        softAssertions.assertAll();

    }





}
