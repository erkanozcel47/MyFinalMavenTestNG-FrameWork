package com.erk.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.erk.pages.FormPage;
import com.erk.testBase.TestBase;
import com.erk.utilities.BrowserUtilities;
import com.erk.utilities.ConfigurationReader;

public class Tests extends TestBase {

	 
	@Test
	public void scenarioPozitive() {

		extentLogger = report.createTest("My New Test");
		FormPage page = new FormPage();
		extentLogger.info("entering user credentials");
		page.FirstName.sendKeys(ConfigurationReader.getProperty("username"));
		page.lastName.sendKeys(ConfigurationReader.getProperty("password"));
		page.maleRadioButton.click();
		extentLogger.info("click login");
		extentLogger.pass("Verified log out link displayed");
		
		page.yearsofExperience.click();
		page.datePicker.sendKeys(ConfigurationReader.getProperty("Date"));
		page.automationTester.click();
		String filePath= "C:\\Users\\erkan\\OneDrive\\Masaüstü\\text.txt";
		page.inputFile.sendKeys(filePath);
		page.seleniumWebdriver.click();
		Select select= new Select(page.continents);
		select.selectByIndex(5);
		Select commands =new Select(page.seleniumCommands);
		commands.selectByIndex(3);
		page.submitButton.click();
	


	}
	@Ignore
	@Test
	public void testWithAsserts() {
		FormPage page = new FormPage();
		page.FirstName.sendKeys(ConfigurationReader.getProperty("username"));
		page.lastName.sendKeys(ConfigurationReader.getProperty("password"));
		page.maleRadioButton.click();
		//Verifying the male radio button text.
		String actual=page.maleRadioButton.getAttribute("value");
		System.out.println(actual);
		assertEquals(actual, "Male");
		//Verifying the Female radio button text.
		String actual2= page.femaleRadioButton.getAttribute("value");
     	System.out.println(actual2);
     	assertEquals(actual2, "Female");
		//
     	page.yearsofExperience.click();
     	BrowserUtilities util= new BrowserUtilities();
      	System.out.println(BrowserUtilities.getElementsText(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[18]")));
      
     	List<WebElement> list= driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[18]"));
      	List<String> list2= new ArrayList<>();
     	for (WebElement each : list) {
 			list2.add(each.getText()+",");
 		}
     	System.out.println(list2);
 		driver.get("https://www.toolsqa.com/automation-practice-table/#");
 		WebElement table= driver.findElement(By.tagName("table"));
 		System.out.println(table.getText());
 	
		List<WebElement> row = driver.findElements(By.tagName("table"));
		row.size();
		
		List<WebElement> row1 = driver.findElements(By.xpath("//*[@id='content']/table/thead/tr[1]"));
		for (WebElement each : row1) {
			System.out.println(each.getText());
		}
	}

	
	
	
	
	
	
	
	

}
