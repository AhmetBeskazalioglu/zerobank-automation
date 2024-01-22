package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// This runner is used to run failed scenarios only
@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/failed-default-report.html", // to generate default html report
        },

        features = "@target/rerun.txt",
        glue = "com/zerobank/stepdefinitions"

)
public class FailedTestRunner {
}
