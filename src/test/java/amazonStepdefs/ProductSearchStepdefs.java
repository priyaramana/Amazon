package amazonStepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import amazonDriverFactory.DriverFactory;
import amazonPages.ProductSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchStepdefs {

	WebDriver driver;
	static Logger logger = Logger.getLogger(ProductSearchStepdefs.class);
	ProductSearchPage productsearchpge;
	
	@Given("User is on product search page")
	public void user_is_on_product_search_page() {
	    driver = DriverFactory.getDriver();
	    productsearchpge = new ProductSearchPage(driver);
	}

	@When("user enters a product name in search bar")
	public void user_enters_a_product_name_in_search_bar() {
		productsearchpge.enterProduct();
	}

	@When("should be able to click on search")
	public void should_be_able_to_click_on_search() {
		productsearchpge.clickSearch();
	}

	@When("user searches for product")
	public void user_searches_for_product() {
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
	}

	@Then("product search results should display")
	public void product_search_results_should_display() throws InterruptedException {
		productsearchpge.resultsDisplay();
	}

	@Then("should contain search text in the title")
	public void should_contain_search_text_in_the_title() {
		productsearchpge.searchText();
	}

	@When("user applies filters")
	public void user_applies_filters() {
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productsearchpge.selectFilter();
	}

	@Then("products that match filters only should get displayed")
	public void products_that_match_filters_only_should_get_displayed() {
		productsearchpge.filterProducts();
	}

	@When("user sorts results by low to high")
	public void user_sorts_results_by_low_to_high() {
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productsearchpge.sortResults();
	}

	@Then("products should display accordingly")
	public void products_should_display_accordingly() {
	    logger.info("products should display accordingly");
	}
}
