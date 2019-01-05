package com.erk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erk.utilities.Driver;

public class FormPage {

	public FormPage() {

		PageFactory.initElements(Driver.getDriver(), this);

	}

	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement FirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastName;
	
	@FindBy(id = "sex-0")
	public WebElement maleRadioButton;
	
	@FindBy(id = "sex-1")
	public WebElement femaleRadioButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[18]")
	public WebElement yearsofExperience;
	 
	@FindBy(id = "datepicker")
	public WebElement datePicker;
	
	@FindBy(id = "profession-0")
	public WebElement manuelTester;
	
	@FindBy(id = "profession-1")
	public WebElement automationTester;
	
	@FindBy(id = "photo")
	public WebElement inputFile;
	 
	@FindBy(id = "tool-0")
	public WebElement qtpTool;
	
	@FindBy(id = "tool-1")
	public WebElement seleniumIDE;

	@FindBy(id = "tool-2")
	public WebElement seleniumWebdriver;
	
	@FindBy(id = "continents")
	public WebElement continents;
	
	@FindBy(id = "selenium_commands")
	public WebElement seleniumCommands;
	
	@FindBy(id = "submit")
	public WebElement  submitButton;
	
	
	 
	
}
