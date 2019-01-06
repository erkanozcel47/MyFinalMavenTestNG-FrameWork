package com.erk.testBase;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
import com.erk.utilities.BrowserUtilities;
import com.erk.utilities.ConfigurationReader;
import com.erk.utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;
	protected Actions actions;
	
	
	protected ExtentReports report;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentTest extentLogger;
	
	
	@BeforeTest
	public void reportFiles() {
		report= new ExtentReports();
		String filePath = System.getProperty("user.dir") + "/test-output/report.html";
		htmlReporter = new ExtentHtmlReporter(filePath);
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("ENV", "staging");
		report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));
		htmlReporter.config().setReportName("Web automation Tools");
		
		
	}
	@AfterTest
	public void tearDownTest() {
		report.flush();
	}

	@BeforeMethod
	public void setUp() {

		driver = Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		// checking if the test method failed
		if (result.getStatus() == ITestResult.FAILURE) {
			// get screenshot using the utility method and save the location of the screenshot
			String screenshotLocation = BrowserUtilities.getScreenshot(result.getName());
			
			// capture the name of test method
			extentLogger.fail(result.getName());
			
			// add the screenshot to the report
			extentLogger.addScreenCaptureFromPath(screenshotLocation);
			
			// capture the exception thrown
			extentLogger.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test Case Skipped is " + result.getName());
		}
		Driver.closeDriver();
	}

}
