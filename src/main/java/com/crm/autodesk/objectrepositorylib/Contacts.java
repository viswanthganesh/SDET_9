package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts
{
	public Contacts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath="//img[@alt='Create Contact...']")
   private WebElement CreateContacts;
   
   @FindBy(name="search_text")
	private WebElement searchBox;
	
	@FindBy(name="search_field")
	private WebElement InDropedown;
	
	@FindBy (name="search")
	private WebElement searchBtn;

	public WebElement getCreateContacts() {
		return CreateContacts;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getInDropedown() {
		return InDropedown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
}
