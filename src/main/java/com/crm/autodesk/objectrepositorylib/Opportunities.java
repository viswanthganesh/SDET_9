package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunities
{
	public Opportunities(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath="//img[@alt='Create Opportunities...']")
   private WebElement Createopportunity;
   
   @FindBy(name="search_text")
	private WebElement searchBox;
	
	public WebElement getopp() {
	return Createopportunity;
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
	@FindBy(name="search_field")
	private WebElement InDropedown;
	
	@FindBy (name="search")
	private WebElement searchBtn;
}
