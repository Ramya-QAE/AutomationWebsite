package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= "src/test/resources/features", 
					dryRun = false,
					glue = {"com.testStep.scenarios", "com.driver"},
					plugin = {"pretty", "html:target/cucumber-reports/formValidation.html" ,
							"pretty",
					        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				)
public class RunnerClass extends AbstractTestNGCucumberTests  {

}
