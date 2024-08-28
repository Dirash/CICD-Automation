package DirashLearning.SeliniumFrameworkTest.StepDefinions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DirashLearning.SeliniuimFrameworkTest.PageObjects.CartPage;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.Checkout;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.ConfirmationPage;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.LandingPage;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.Productcatalogue;
import DirashLearning.SeliniuimFrameworkTest.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{

	public LandingPage LandingPage;
	public Productcatalogue Productcatalogue;
	public ConfirmationPage ConfirmationPage;
	@Given("I landed on Ecommernce page")
	public void I_landed_on_Ecommernce_page() throws IOException {
		LandingPage = LaunchApplication();
		
	}
	
	@Given("^Logged in user name (.+) and password (.+)$")
	public void logged_in_username_password(String username, String password) {
		
		 Productcatalogue= LandingPage.loginApplication(username,password);
		
	}
	
	@When("^I add the product name (.+) to cart$")
	public void I_add_the_product_to_cart(String productName) {
		List<WebElement> products = Productcatalogue.getProductList();
		//get the product addidas
		Productcatalogue.getProductByName(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productname) {
		CartPage CartPage = Productcatalogue.goToCart();
		 
		//verifying cart as that product
		Boolean match = CartPage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		
		//checkout of the cart
		Checkout Checkout = CartPage.checkOut();	
		Checkout.SelectCountry("india");
		 ConfirmationPage =Checkout.submitOrder();
	}

	@Then("{string} is displayed on confirmation page")
	public void message_displayed_confm_page(String string) {
		
		String confirmMessage = ConfirmationPage.getConfirmMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
	@Then("{string} is displayed")
	public void String_is_displayed(String string) {
		
		Assert.assertEquals(string, LandingPage.errorMessage());

	}
}
