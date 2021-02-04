package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverCommomLib;

public class createNewProduct extends WebDriverCommomLib
{
	public createNewProduct (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement proName;
	
	@FindBy(name="unit_price")
	private WebElement unitPrice;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	public WebElement getproName() {
		return proName;
	}


	public WebElement getUnitPrice() {
		return unitPrice;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateNewProduct(String proname,String unitprice)
	{
		waitforelement(proName);
		getproName().sendKeys(proname);
		getUnitPrice().sendKeys(unitprice);
		saveBtn.click();
	}
	
	
	
	
	
}
