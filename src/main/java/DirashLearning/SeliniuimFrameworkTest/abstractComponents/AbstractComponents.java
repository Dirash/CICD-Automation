package DirashLearning.SeliniuimFrameworkTest.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DirashLearning.SeliniuimFrameworkTest.PageObjects.CartPage;

public class AbstractComponents {
	WebDriver driver;

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement OrdersButton;
	

	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub\
		this.driver = driver;
	}

	public void ElementVisibility(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void webElementVisibility(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}

	public void ElementDissapear(WebElement findby) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findby));
	}

	public CartPage goToCart() {

		cartButton.click();
		CartPage CartPage = new CartPage(driver);
        return CartPage;

	}
	public OrderPage goToOrder() {

		OrdersButton.click();
		OrderPage OrderPage = new OrderPage(driver);
        return OrderPage;

	}

}
