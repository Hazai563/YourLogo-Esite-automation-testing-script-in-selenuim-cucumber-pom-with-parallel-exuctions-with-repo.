package com.Parallel;

import com.factory.DriverFactory;
import com.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.access_prop();

    }

    @Before(order = 1)
    public void launchBrowser(){
         String browserName = prop.getProperty("browser");
          driverFactory =  new DriverFactory();
          driver =  driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
         String ScreenShotName =   scenario.getName().replaceAll(" ", "_");
          byte [] ScreenShotPath =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
          scenario.attach(ScreenShotPath, "image/png", ScreenShotName);

        }
    }

}
