package com.erk.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.erk.utilities.ConfigurationReader;
import com.erk.utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;
	protected Actions actions;

	@BeforeMethod
	public void setUp() {

		driver = Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
	   Driver.closeDriver();
	}

}
