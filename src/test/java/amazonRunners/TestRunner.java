package amazonRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="/Users/lt535j/eclipse-workspace/Amazon/src/test/resources/amazonFeatures/login.feature",
	glue = {"amazonStepdefs","amazonHooks"},
	plugin = {"pretty", "json:target/cucumber.json"},
	monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
