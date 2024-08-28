package DirashLearning.SeliniuimFrameworkTest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DirashLearning.SeliniuimFrameworkTest.PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage LandingPage;
	
	public WebDriver initilizeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//DirashLearning//SeliniuimFrameworkTest//resources//GlobalData.properties");
		prop.load(fis);
		//String browsername = prop.getProperty("browser");
		
		String browsername =System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		if(browsername.contains("chrome"))
		{
			
			ChromeOptions options = new ChromeOptions();
			
			if(browsername.contains("headless")) {
				options.addArguments("headless");
				
			}
		 driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440, 900));
		
		}
		
		else if (browsername.equalsIgnoreCase("firefox")){
			
		   // driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")){
			
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException {
		driver = initilizeDriver();
	    LandingPage = new LandingPage(driver);
		LandingPage.goTo();
		return LandingPage;
		
	}
	@AfterMethod(alwaysRun = true)
	public void exitDriver() {
		 driver.quit();
	}
	
	public List<HashMap<String, String>> converJsonToString(String filePath) throws IOException {
		//read json to string
		String jsonContent =FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	   
		//String to Haashmap --> Jackson databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	
	}
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File fis = new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		FileUtils.copyFile(source, fis);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		
		
	}
}
