package amazonDriverFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver setDriver() {
		WebDriverManager.chromedriver().setup();
		// ✅ Set ChromeOptions here
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordChange"); // disables "change password" alert
        options.addArguments("--disable-notifications"); // disables browser notifications
        options.addArguments("--incognito"); // optional, opens browser in incognito mode

        // ✅ Use ChromeDriver with options
        driver.set(new ChromeDriver(options));
        
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
