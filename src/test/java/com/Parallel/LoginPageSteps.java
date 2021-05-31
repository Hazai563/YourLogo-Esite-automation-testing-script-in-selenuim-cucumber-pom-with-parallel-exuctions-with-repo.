package com.Parallel;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private static String title;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver()
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
         title = loginPage.getLoginPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedPageTitle) {
        Assert.assertTrue(title.contains(expectedPageTitle));
    }


    //2.

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.forgotLinkExist());
    }

//3.

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        loginPage.enterUserName(string);
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        loginPage.enterPassword(string);
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.ClickOnLoginButton();
    }




}
