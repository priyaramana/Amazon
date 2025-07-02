package amazonStepdefs;

import org.openqa.selenium.WebDriver;

import amazonDriverFactory.DriverFactory;
import amazonPages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefs {

	WebDriver driver;
	//static Logger logger = Logger.getLogger(LoginStepdefs.class);
	LoginPage loginpge;
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		driver = DriverFactory.getDriver();
		loginpge = new LoginPage(driver);
		
	}

	@When("user clicks on signin in home page")
	public void user_clicks_on_signin_in_home_page() {
	    //logger.info("click signin link");
		loginpge.clickSigninlink();
	}

	@Then("user should redirect to login page")
	public void user_should_redirect_to_login_page() {
	    //logger.info("redirects to login page");
	}

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver = DriverFactory.getDriver();
		loginpge = new LoginPage(driver);
		Thread.sleep(500);
		loginpge.clickSigninlink();
		Thread.sleep(500);
		//logger.info("user is on login page");
	}

	@When("user enter username {string}")
	public void user_enter_username(String user) {
	    loginpge.enterUsername(user);
	}

	@When("clicks on continue")
	public void clicks_on_continue() throws InterruptedException {
		//logger.info("click on continue");
	    loginpge.clickContinue();
	    Thread.sleep(500);
	}

	@Then("user should redirect to password page")
	public void user_should_redirect_to_password_page() {
	   // logger.info("redirect to password page");
	    
	}

	@When("user enters password {string}")
	public void user_enters_password(String pass) {
	    loginpge.enterPassword(pass);
	}

	@When("clicks on signin button in login page")
	public void clicks_on_signin_button_in_login_page() {
	    loginpge.clickSignin();
	}

	@Then("user should redirect to home page")
	public void user_should_redirect_to_home_page() {
	    //logger.info("should redirect to home page");
	}
}
