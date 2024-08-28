package DirashLearning.SeliniuimFrameworkTest.abstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	@FindBy(xpath = "//tr//td[2]")
	List<WebElement> ProductsName;

	public Boolean verifyOrderDisplay(String productName) {

		// List<WebElement> cartProducts =
		// driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = ProductsName.stream().anyMatch(product -> product.getText().equals(productName));
		return match;
	}

}
