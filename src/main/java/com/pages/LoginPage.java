package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //1.
    private By eamilId = By.id("email");
    private By passId = By.id("passwd");
    private By SignInButtonId = By.id("SubmitLogin");
    private By forgotLink = By.linkText("Forgot your password?");

    //2.

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //3.

    public String getLoginPageTitle(){
      return  driver.getTitle();
    }

    public boolean forgotLinkExist(){
       return driver.findElement(forgotLink).isDisplayed();

    }

    public void enterUserName(String username){
        driver.findElement(eamilId).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passId).sendKeys(password);
    }

    public void ClickOnLoginButton(){
        driver.findElement(SignInButtonId).click();
    }

    public AccountsPage doLogin(String usrName, String pass){
        driver.findElement(eamilId).sendKeys(usrName);
        driver.findElement(passId).sendKeys(pass);
        driver.findElement(SignInButtonId).click();

        return new AccountsPage(driver);
    }

}
