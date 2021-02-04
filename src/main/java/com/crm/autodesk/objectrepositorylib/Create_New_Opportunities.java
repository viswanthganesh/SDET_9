package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverCommomLib;

public class Create_New_Opportunities extends WebDriverCommomLib
{
	public Create_New_Opportunities  (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement potentialName;
	
	

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookUp;
	
	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement sales_stageDropDown;
	
	//select[@name="sales_stage"]
	
	
	public WebElement getSales_stageDropDown() {
		return sales_stageDropDown;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	public WebElement getpotentialName() {
		return potentialName;
	}


	public WebElement getOrgLookUp() {
		return orgLookUp;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void create_potential(String potentialName,String orgName,String sales_stage )
	{
		getpotentialName().sendKeys(potentialName);
		orgLookUp.click();
		 //switch control to child
		 
		 switchToWindow("Accounts&action");
		Organization orgpage = new Organization(driver);
		 
		 orgpage.getSearchBox().sendKeys(orgName);
		 orgpage.getSearchBtn().click();
		 waitforelement(driver.findElement(By.xpath("//a[text()='"+orgName+"']")));
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		// switch back to parant
		 
		 switchToWindow("Contacts");
		 selectoption(sales_stage ,sales_stageDropDown);
		 saveBtn.click();
		 
	}
	
}
