package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quotes_Info 
{
	public Quotes_Info (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public WebElement getSuccessfullmasage() {
		return successfullmasage;
	}
     @FindBy(xpath="//span[@class='lvtHeaderText']")
      private WebElement successfullmasage;
}
