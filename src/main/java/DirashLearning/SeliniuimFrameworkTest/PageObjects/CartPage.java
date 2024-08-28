package DirashLearning.SeliniuimFrameworkTest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import DirashLearning.SeliniuimFrameworkTest.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	// TODO Auto-generated method stub

	WebDriver driver;

	public CartPage(WebDriver driver) {
        super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
		
	public Boolean verifyProductDisplay(String productName) {
		

		//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match =cartProducts.stream().anyMatch(product->product.getText().equals(productName));
		return match;
	}
	public Checkout checkOut() {
		
		checkout.click();
		Checkout checkout = new Checkout(driver);
		return checkout;
	}

}
