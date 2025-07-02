package amazonStepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import amazonDriverFactory.DriverFactory;
import amazonPages.CartPage;
import amazonPages.ProductSearchPage;
import amazonPages.ProductSelectionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepdefs {

	WebDriver driver;
	static Logger logger = Logger.getLogger(CartStepdefs.class);
	CartPage cartpge;
	ProductSearchPage productsearchpge;
	ProductSelectionPage productselectpge;
	
	@Given("User is on cart product details page")
	public void user_is_on_cart_product_details_page() {
	    driver = DriverFactory.getDriver();
	    productsearchpge = new ProductSearchPage(driver);
	    productselectpge = new ProductSelectionPage(driver);
	    cartpge = new CartPage(driver);
	    
	}

	@Then("user should be able to add product to cart on clicking add to cart button")
	public void user_should_be_able_to_add_product_to_cart_on_clicking_add_to_cart_button() throws InterruptedException {
		Thread.sleep(1000);
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productselectpge.selectProduct();
		logger.info("user should be able to add product to cart on clicking add to cart button");
	}

	@When("User clicks on add to cart")
	public void user_clicks_on_add_to_cart() throws InterruptedException {
		Thread.sleep(1000);
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productselectpge.selectProduct();
		cartpge.addCart();
	}

	@Then("product should be added to cart")
	public void product_should_be_added_to_cart() throws InterruptedException {
		
	    logger.info("product should be added to cart");
	}

	@Given("User is on cart page")
	public void user_is_on_cart_page() throws InterruptedException {
		driver = DriverFactory.getDriver();
	    productsearchpge = new ProductSearchPage(driver);
	    productselectpge = new ProductSelectionPage(driver);
	    cartpge = new CartPage(driver);
		Thread.sleep(1000);
		productsearchpge.enterProduct();
		productsearchpge.clickSearch();
		productselectpge.selectProduct();
		
		Thread.sleep(500);	
		
	}

	@When("user clicks on + next to product quantity")
	public void user_clicks_on_next_to_product_quantity() throws InterruptedException {
		Thread.sleep(500);
		cartpge.addCart();
		cartpge.cartPage();
		Thread.sleep(1000);
		cartpge.increaseCount();
		Thread.sleep(500);
	}

	@Then("quantity should get increased by {int}")
	public void quantity_should_get_increased_by(Integer int1) {
		
		logger.info("quantity should get increased");
	}

	@When("quantity is greater than {int}")
	public void quantity_is_greater_than(Integer int1) throws InterruptedException {
		
		Thread.sleep(1000);
	    logger.info("quantity is greater");
	}

	@When("user clicks on minus next to product quantity")
	public void user_clicks_on_minus_next_to_product_quantity() throws InterruptedException {
		Thread.sleep(500);
		cartpge.addCart();
		cartpge.cartPage();
		Thread.sleep(1000);
		cartpge.increaseCount();
		Thread.sleep(1000);
		cartpge.decreaseCount();
		Thread.sleep(1000);
	}

	@Then("quantity should get decreased by {int}")
	public void quantity_should_get_decreased_by(Integer int1) {
	   logger.info("quantity should get decreased");
	}

	@When("no product is added to cart")
	public void no_product_is_added_to_cart() {
		cartpge.cartPage();
	    logger.info("no product is added to cart");
	}

	@Then("cart empty message should display")
	public void cart_empty_message_should_display() {
		cartpge.emptyCartmsg();
	}
}

