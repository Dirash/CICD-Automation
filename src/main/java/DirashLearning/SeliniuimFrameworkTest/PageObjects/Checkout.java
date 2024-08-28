package DirashLearning.SeliniuimFrameworkTest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DirashLearning.SeliniuimFrameworkTest.abstractComponents.AbstractComponents;

public class Checkout extends AbstractComponents {

	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;

	@FindBy(css = ".action__submit")
	WebElement submit;

	By visibility = By.cssSelector(".ta-results");

	public void SelectCountry(String countryName) {
		Actions act = new Actions(driver);
		act.sendKeys(country, countryName).build().perform();
		ElementVisibility(visibility);

		SelectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
		 
	}

}
