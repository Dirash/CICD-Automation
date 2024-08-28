package DirashLearning.SeliniuimFrameworkTest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DirashLearning.SeliniuimFrameworkTest.abstractComponents.AbstractComponents;

public class Productcatalogue extends AbstractComponents {

	// TODO Auto-generated method stub

	WebDriver driver;

	public Productcatalogue(WebDriver driver) {
        super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	@FindBy(css = ".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By findby = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".col-lg-4 button:last-child");
	By toastMessage = By.cssSelector(".toast-message");

	public List<WebElement> getProductList() {
		ElementVisibility(findby);
		return products;
		
	}
	
	public WebElement getProductByName(String productName) {
		

		WebElement prod =getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		getProductByName(productName).findElement(addToCart).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
		ElementVisibility(toastMessage);
		ElementDissapear(spinner);
	}

}
