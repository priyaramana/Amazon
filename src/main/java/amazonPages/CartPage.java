package amazonPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")
	WebElement AddToCart;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cart;
	
	@FindBy(xpath="//h3[contains(text(),'Your Amazon Cart is empty')]")
	WebElement emptyCartMsg;
	
	@FindBy(xpath="//button[@data-a-selector='increment']")
	WebElement cartIncrease;
	
	@FindBy(xpath="//ul[@data-name='Active Items']//div[@class='sc-list-item-content']//ul/li/span/a/span/h4/span/span[@class='a-truncate-cut']")
	WebElement cartProductNames;
	
	@FindBy(xpath="//button[@data-a-selector='decrement']")
	WebElement cartDecrease;
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-trash']/parent::button[@data-a-selector='decrement']")
	WebElement cartDelete;
	
	@FindBy(xpath="//button[@class='a-declarative']/following-sibling::div/span[@data-a-selector='value']")
	int cartValue;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement cartCount;
	
	public void addCart() {
		AddToCart.click();
	}
	
	public void cartPage() {
		cart.click();
	}
	
	public void increaseCount() {
		cartIncrease.click();
	}
	
	public void increaseCount2() {
		cartIncrease.click();
		cartIncrease.click();
	}
	public void decreaseCount() {
		 wait.until(ExpectedConditions.visibilityOf(cartDecrease));
		 cartDecrease.click();
		
	}
	
	public void emptyCartmsg() {
		if(cartCount.equals(0))
		Assert.assertTrue(emptyCartMsg.isDisplayed());
	}
}
