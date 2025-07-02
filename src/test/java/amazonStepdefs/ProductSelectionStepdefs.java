package amazonStepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import amazonDriverFactory.DriverFactory;
import amazonPages.ProductSearchPage;
import amazonPages.ProductSelectionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSelectionStepdefs {

	WebDriver driver;
	static Logger logger = Logger.getLogger(ProductSelectionStepdefs.class);
	ProductSelectionPage productselectpge;
	ProductSearchPage productsearchpge;
	
	@Given("User is on product page")
	public void user_is_on_product_page() {
	    driver = DriverFactory.getDriver();
	    productsearchpge = new ProductSearchPage(driver);
	    productselectpge = new ProductSelectionPage(driver);
	}

	@When("user enters product in search box")
	public void user_enters_product_in_search_box() {
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
	}

	@Then("search results should display")
	public void search_results_should_display() {
		productselectpge.resultDisplay();
	}

	@Then("should be able to select product from search results")
	public void should_be_able_to_select_product_from_search_results() {
		logger.info("should be able to select product from search results");
	}

	@When("user clicks on product")
	public void user_clicks_on_product() {
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productselectpge.selectProduct();
	}

	@Then("product details page should display")
	public void product_details_page_should_display() {
		logger.info("product details page should display");
	}

	@Then("should contain title, price, description")
	public void should_contain_title_price_description() throws InterruptedException {
		productselectpge.titlePriceDescriptionDisplay();
	}

	@Then("it should cotain add to cart button")
	public void it_should_cotain_add_to_cart_button() {
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productselectpge.selectProduct();
		productselectpge.addToCartDisplay();
	}

	@Then("images should display as carousel")
	public void images_should_display_as_carousel() throws InterruptedException {
		//productselectpge.imagesDisplay();
		productselectpge.carouselDisplay();
	}

	@Given("User is on product details page")
	public void user_is_on_product_details_page() {
		driver = DriverFactory.getDriver();
	    productsearchpge = new ProductSearchPage(driver);
	    productselectpge = new ProductSelectionPage(driver);
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productselectpge.selectProduct();
	}

	@When("user enters valid pincode")
	public void user_enters_valid_pincode() throws InterruptedException {
		
		productselectpge.validpincodevalidation();
	}

	@When("clicks on verify")
	public void clicks_on_verify() {
		logger.info("clicks on verify");
	}

	@Then("success message should display")
	public void success_message_should_display() {
	   logger.info("success message should display");
	}

	@When("user enters invalid pincode")
	public void user_enters_invalid_pincode() throws InterruptedException {
		productselectpge.invalidpincodevalidation();
	}
	
	@Then("error message should display")
	public void error_message_should_display() {
		logger.info("error message should display");
	}
}
