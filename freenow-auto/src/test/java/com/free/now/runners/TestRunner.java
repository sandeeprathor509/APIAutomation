package com.free.now.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        publish = true,
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber/cucumber.json"},
        glue = {"com.free.now.stepdefinitions"},
        tags = "@freenow"
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
