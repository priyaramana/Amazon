package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='nav-logo']")
	WebElement logo;
	
	@FindBy(xpath="//input[@role='searchbox']")
	WebElement search;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement carticon;
	
	@FindBy(xpath="//div[@id=\"nav-link-accountList\"]//a[@data-nav-role='signin']")
	WebElement login;
	
	public void titleCheck() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void logoCheck() {
		Assert.assertTrue(logo.isDisplayed());
	}
	
	public void searchPresent() {
		Assert.assertTrue(search.isDisplayed());
	}
	
	public void searchEnabled() {
		Assert.assertTrue(search.isEnabled());
	}
	
	public void cartPresent() {
		Assert.assertTrue(carticon.isDisplayed());
	}
	
	public void signInpresent() {
		Assert.assertTrue(login.isDisplayed());
	}
}
