package amazonRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features= {
	  "/Users/lt535j/eclipse-workspace/Amazon/src/test/resources/amazonFeatures/login.feature",
	  "/Users/lt535j/eclipse-workspace/Amazon/src/test/resources/amazonFeatures/Home.feature",
	  "/Users/lt535j/eclipse-workspace/Amazon/src/test/resources/amazonFeatures/Productsearcg.feature",
	  "/Users/lt535j/eclipse-workspace/Amazon/src/test/resources/amazonFeatures/productSelectionandDetails.feature",
	  "/Users/lt535j/eclipse-workspace/Amazon/src/test/resources/amazonFeatures/Cart.feature",
	},
	glue = {"amazonStepdefs","amazonHooks"},
	plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
            "html:target/cucumber-reports.html"},
	monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
} 
