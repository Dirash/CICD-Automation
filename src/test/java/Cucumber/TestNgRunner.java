package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//mono chrome means convert to readablae format, plugin means where i need to store the data
@CucumberOptions(features="src/test/java/Cucumber",glue="DirashLearning.SeliniumFrameworkTest.StepDefinions",
monochrome = true,tags = "@errorvalidations", plugin = {"html:target/cucumber.html"})
public class TestNgRunner extends AbstractTestNGCucumberTests {
	

}
