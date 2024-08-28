package DirashLearning.SeliniuimFrameworkTest;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DirashLearning.SeliniuimFrameworkTest.PageObjects.CartPage;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.Checkout;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.ConfirmationPage;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.LandingPage;
import DirashLearning.SeliniuimFrameworkTest.PageObjects.Productcatalogue;
import DirashLearning.SeliniuimFrameworkTest.TestComponents.BaseTest;
import DirashLearning.SeliniuimFrameworkTest.abstractComponents.OrderPage;

public class SubmitOrder extends BaseTest  {
	String product_Name = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException
	 {
		// TODO Auto-generated method stub
        
       
		Productcatalogue Productcatalogue= LandingPage.loginApplication(input.get("email"), input.get("password"));
		
		//get the product list 
		
		List<WebElement> products = Productcatalogue.getProductList();
		//get the product addidas
		Productcatalogue.getProductByName(input.get("product"));
		//add to cart 
		Productcatalogue.addProductToCart(input.get("product"));
		//going into cart
		CartPage CartPage = Productcatalogue.goToCart();
		 
		//verifying cart as that product
		Boolean match = CartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		
		//checkout of the cart
		Checkout Checkout = CartPage.checkOut();	
		Checkout.SelectCountry("india");
		ConfirmationPage ConfirmationPage =Checkout.submitOrder();
		
		
	    String confirmMessage = ConfirmationPage.getConfirmMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	   	
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistory() {
		
		Productcatalogue Productcatalogue= LandingPage.loginApplication("dirash@leena.ai", "Dirash@10");
       OrderPage OrderPage = Productcatalogue.goToOrder();
       Assert.assertTrue(OrderPage.verifyOrderDisplay(product_Name));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "dirash@leena.ai");
//		map.put("password", "Dirash@10");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("email", "dirash@leena.ai");
//		map2.put("password", "Dirash@10");
//		map2.put("product", "ZARA COAT 3");
		
		List<HashMap<String, String>> data = converJsonToString(System.getProperty("user.dir")+"//src//test//java//DirashLearning//Data//PurchaseOrder.json");
 		
		return new Object [][] { {data.get(0)},{data.get(1)} };
		
		
	}
	


}
