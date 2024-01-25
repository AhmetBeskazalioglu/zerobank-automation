package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/default-report.html", // to generate default html report
                "json:target/cucumber.json", // to generate json type report
                "rerun:target/rerun.txt" // to generate txt file with failed scenarios only
        },

        features = "src/test/resources/features",
        glue = "com/zerobank/stepdefinitions",
        dryRun = false,
        tags = "@find_transactions1"

)
public class CukesRunner {
}
