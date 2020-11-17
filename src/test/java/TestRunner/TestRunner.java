package TestRunner;

import java.io.IOException;

//import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentTest;

import coeur.Reports;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinitions.*;

@CucumberOptions(features = { "Features" }, glue = { "stepDefinitions" }, tags = {"@addingacomponentandeditingit"},monochrome=true,format= {"pretty","html:test-output","json:json_output/results.json"},dryRun=false)


@Test
public class TestRunner extends AbstractTestNGCucumberTests1 {

	
	
}	