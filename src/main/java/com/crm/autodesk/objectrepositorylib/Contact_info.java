package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_info 
{
	public Contact_info (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public WebElement getSuccessfullmasage() {
		return successfullmasage;
	}
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement successfullmasage;
}
