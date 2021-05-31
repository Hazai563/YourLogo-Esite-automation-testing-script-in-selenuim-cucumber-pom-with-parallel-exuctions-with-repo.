package com.Parallel;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
   private AccountsPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map <String, String>> credList = dataTable.asMaps();
        String username =  credList.get(0).get("username");
        String password =  credList.get(0).get("password");
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(username, password);

    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        accountsPage.getAccountsPageTitle();

    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable secTable) {
           List<String> expAccountSecList = secTable.asList();
           List<String> actualAccountSecList  = accountsPage.getAccountsSectionsList();
           Assert.assertTrue(expAccountSecList.containsAll(actualAccountSecList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expTotalSection) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expTotalSection);
    }


}
