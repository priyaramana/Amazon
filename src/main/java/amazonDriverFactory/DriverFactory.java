package amazonDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver setDriver() {
		driver.set(new ChromeDriver());
		return getDriver();
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
}
