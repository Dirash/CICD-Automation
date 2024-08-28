package DirashLearning.SeliniuimFrameworkTest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import DirashLearning.SeliniuimFrameworkTest.PageObjects.Productcatalogue;
import DirashLearning.SeliniuimFrameworkTest.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest  {

	@Test(groups = {"errorvalidations"}, retryAnalyzer=DirashLearning.SeliniuimFrameworkTest.TestComponents.Retry.class)
	public void Errorvalidation() throws IOException
	 {
		// TODO Auto-generated method stub
        String product_Name = "ADIDAS ORIGINAL";
       
		Productcatalogue Productcatalogue= LandingPage.loginApplication("dirashsas@leena.ai", "Dira4sh@10");
		LandingPage.errorMessage();
		Assert.assertEquals("Incorrect email or password.", LandingPage.errorMessage());
		
	 }}