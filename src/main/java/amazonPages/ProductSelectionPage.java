package amazonPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductSelectionPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ProductSelectionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	@FindBy(xpath="//input[@role='searchbox']")
	WebElement search;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//h2[text()='Results']")
	WebElement results;
	
	@FindBy(xpath="//div[@data-cy='title-recipe']/a/h2/span")
	WebElement product;
	
	@FindBy(xpath="//div[@id='corePriceDisplay_desktop_feature_div']/div/span/span/span[@class='a-price-whole']")
	WebElement price;
	
	@FindBy(xpath="//div[@id='featurebullets_feature_div']")
	WebElement description;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")
	WebElement AddToCart;
	
	@FindBy(xpath="//ul[@aria-label='Image thumbnails']")
	WebElement Images;
	
	@FindBy(xpath="//div[@class='ivThumb']//div[@class='ivThumbImage']")
	List<WebElement> carousel;
	
	@FindBy(xpath="//div[@id='imgTagWrapperId']")
	WebElement prodimage;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-close']")
	WebElement popClose;
	
	@FindBy(xpath="//div[@id='contextualIngressPtLabel_deliveryShortLine']")
	WebElement deliverMsg;
	
	@FindBy(xpath="//input[@autocomplete='postal-code']")
	WebElement pincode;
	
	@FindBy(xpath="//input[@class='a-button-input' and @type='submit' and @aria-labelledby='GLUXZipUpdate-announce' ]")
	WebElement pinApply;
	
	@FindBy(xpath="//div[text()='Please enter a valid pincode']")
	WebElement errormsg;
	
	String searchtext = "Iphone";
	
	public void enterSearch() {
		search.sendKeys(searchtext);
	}
	
	public void resultDisplay() {
		results.isDisplayed();
	}
	
	public void selectProduct() {
		product.click();
	}
	
	public void titlePriceDescriptionDisplay() throws InterruptedException {
		Thread.sleep(500);
		String title = driver.getTitle();
		System.out.println("title: "+title);
		Assert.assertTrue(price.isDisplayed());
		Assert.assertTrue(description.isDisplayed());
	}
	
	public void addToCartDisplay() {
		Assert.assertTrue(AddToCart.isDisplayed());
	}
	
	public void imagesDisplay() {
		Assert.assertTrue(Images.isDisplayed());
	}
	
	public void carouselDisplay() throws InterruptedException {
		prodimage.click();
		for(WebElement carouselimg: carousel) {
			carouselimg.click();
		}
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(popClose));
		popClose.click();
	}
	
	public void validpincodevalidation() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(deliverMsg));
		deliverMsg.click();
		pincode.sendKeys("560079");
		pinApply.click();
	}
	
	public void invalidpincodevalidation() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='contextualIngressPtLabel_deliveryShortLine']")));
		deliverMsg.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autocomplete='postal-code']")));
		pincode.clear();
		Thread.sleep(500);
		pincode.sendKeys("56007");
		pinApply.click();
		Thread.sleep(500);
		Assert.assertTrue(errormsg.isDisplayed());
	}
}
