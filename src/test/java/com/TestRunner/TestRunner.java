package com.TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"com.esite.stepdefinitions", "com.esite.appHooks"},
        plugin = {"pretty",
                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        }

)
public class TestRunner {

}