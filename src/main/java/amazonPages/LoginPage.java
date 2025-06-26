package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class LoginPage {

	WebDriver driver;
	static Logger logger = Logger.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement Hellosignin;
	
	@FindBy(xpath="//input[@id='ap_email_login']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Continue;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement submit;
	
	public void clickSigninlink() {
		Hellosignin.click();
	}
	public void enterUsername(String user) {
		Username.sendKeys(user);
		
	}
	public void clickContinue() {
		Continue.click();
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickSignin() {
		submit.click();
	}
}
