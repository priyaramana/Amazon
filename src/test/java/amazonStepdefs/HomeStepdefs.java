package amazonStepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import amazonDriverFactory.DriverFactory;
import amazonPages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeStepdefs {

	WebDriver driver;
	static Logger logger = Logger.getLogger(HomeStepdefs.class);
	HomePage homepge;
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    driver = DriverFactory.getDriver();
	    homepge = new HomePage(driver);
	}

	@Then("Expected page title should match actual title")
	public void expected_page_title_should_match_actual_title() {
	    homepge.titleCheck();
	}

	@Then("Amazon logo should be displayed")
	public void amazon_logo_should_be_displayed() {
	    homepge.logoCheck();
	}

	@Then("search box should be present")
	public void search_box_should_be_present() {
	   homepge.searchPresent();
	}

	@Then("search box should be enabled")
	public void search_box_should_be_enabled() {
	    homepge.searchEnabled();
	}

	@Then("cart icon should be visible")
	public void cart_icon_should_be_visible() {
	    homepge.cartPresent();
	}

	@Then("sign-in option should be available")
	public void sign_in_option_should_be_available() {
	    homepge.signInpresent();
	}
}
