package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature", 
glue = { "stepdefinition"}, 
plugin = { "pretty", "html:target/reports.html", "json:target/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests  {

}