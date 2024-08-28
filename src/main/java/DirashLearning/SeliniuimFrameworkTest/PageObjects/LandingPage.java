package DirashLearning.SeliniuimFrameworkTest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DirashLearning.SeliniuimFrameworkTest.abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	// TODO Auto-generated method stub

	WebDriver driver;

	public LandingPage(WebDriver driver) {
        super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement elePassword;

	@FindBy(id = "login")
	WebElement submit;
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

	}

	public Productcatalogue loginApplication(String username, String password) {
		email.sendKeys(username);
		elePassword.sendKeys(password);
		submit.click();
		Productcatalogue Productcatalogue= new Productcatalogue(driver);
		return Productcatalogue;

	}
	
	public String errorMessage() {
		webElementVisibility(errormessage);
		return errormessage.getText();
	}

}
