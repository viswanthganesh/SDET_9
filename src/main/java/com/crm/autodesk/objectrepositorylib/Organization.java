package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization
{
	public Organization(WebDriver Driver)
	{
		PageFactory.initElements(Driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement orgImage;
	
	@FindBy(name="search_text")
	private WebElement searchBox;
	
	@FindBy(name="search_field")
	private WebElement InDropedown;
	
	@FindBy (name="search")
	private WebElement searchBtn;
	
	public WebElement getOrgImage() {
		return orgImage;
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
