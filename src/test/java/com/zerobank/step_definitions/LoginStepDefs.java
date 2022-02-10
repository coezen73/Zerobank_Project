package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

/**
 * @author ybilgin
 * @project Zerobank_Project
 */


public class LoginStepDefs {

    @Given("the user logged in")
    public void the_user_logged_in() {
        new LoginPage().login();
    }
    @Given("the user logged in {string} and {string}")
    public void the_user_logged_in(String username, String password) {
        new LoginPage().login(username,password);

    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,new LoginPage().errorMessage.getText());
    }

}
