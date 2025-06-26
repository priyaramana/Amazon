package amazonHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import amazonDriverFactory.DriverFactory;
import amazonUtils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
