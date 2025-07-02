package amazonPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchPage {

	WebDriver driver;
	WebDriverWait wait;
	public ProductSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//input[@role='searchbox']")
	WebElement search;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//h2[text()='Results']")
	WebElement results;
	
	@FindBy(xpath="//span[text()='Brands']/parent::div/following-sibling::ul/span/span/li/span/a/span")
	List<WebElement> brandFilters;
	
	@FindBy(xpath="//div[@data-cy='title-recipe']/a/h2/span")
	WebElement Filterproducts;
	
	@FindBy(xpath="//a[@class='a-dropdown-link']")
	WebElement sortResults;
	
	String searchText = "Iphone";
	
	public void enterProduct() {
		search.sendKeys(searchText);
	}
	
	public void clickSearch() {
		searchIcon.click();
	}
	
	public void resultsDisplay() throws InterruptedException {
		
		Thread.sleep(500);
		results.isDisplayed();
	}
	
	public void searchText() {	
		String title = driver.getTitle();
		if(title.contains(searchText)) {
			System.out.println("Title contain search text");
		}else {
			System.out.println("Title does not contain search text");
		}
	}
	
	public void selectFilter() {
		
		for(WebElement brandFilter: brandFilters) {
		 String brand = brandFilter.getText();
		 if(brand.contains("Apple")) {
			 brandFilter.click();
			 break;
		 }
		}
	}
	
	public void filterProducts() {
		String filterProds = Filterproducts.getText();
		if(filterProds.contains(searchText)) {
			System.out.println("proucts filtered");
		}else {
			System.out.println("products not filtered");
		}
	}
	
	public void sortResults() {
		driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
		String result = sortResults.getText();
		if(result.contains("Price: Low to High")) {
			sortResults.click();
		}
	}
	
}
