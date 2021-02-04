package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfo 
{

	public  ProductInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement SucessFullMasg;

	public WebElement getSucessFullMasg() {
		return SucessFullMasg;
	}
	
	
}
