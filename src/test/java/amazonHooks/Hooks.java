package amazonHooks;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import amazonDriverFactory.DriverFactory;
import amazonUtils.ConfigReader;
import amazonUtils.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

	WebDriver driver;
	static Logger logger = Logger.getLogger(Hooks.class);
	Properties prop;
	
	@Before
	public void setUp() throws InterruptedException {
		prop = ConfigReader.getProperties();
		DriverFactory.setDriver().get(prop.getProperty("url"));
		Thread.sleep(1000);
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		driver = DriverFactory.getDriver();
		if(scenario.isFailed()) {
			Screenshots.captureScreenshot(driver, scenario.getName());
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed screenshots");
			Allure.addAttachment("Screenshot on failure", new ByteArrayInputStream(screenshot));
		}
		DriverFactory.quitDriver();
	}
}
