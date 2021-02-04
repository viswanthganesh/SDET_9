package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverCommomLib;

public class CreateContacts extends WebDriverCommomLib
{
	public CreateContacts (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement contLstName;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookUp;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public void createContact(String lastname,String orgName,String serachDropOtp)
	{
		waitforelement(contLstName);
		contLstName.sendKeys(lastname);
		 orgLookUp.click();
		 //switch control to child
		 
		 switchToWindow("Accounts&action");
		Organization orgpage = new Organization(driver);
		 selectoption(serachDropOtp,orgpage.getInDropedown());
		 orgpage.getSearchBox().sendKeys(orgName);
		 orgpage.getSearchBtn().click();
		 waitforelement(driver.findElement(By.xpath("//a[text()='"+orgName+"']")));
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		// switch back to parant
		 
		 switchToWindow("Contacts");
		 saveBtn.click();
		 
		 
	}
	public void createContact(String lastname,String orgName)
	{
		waitforelement(contLstName);
		contLstName.sendKeys(lastname);
		 orgLookUp.click();
		 //switch control to child
		 
		 switchToWindow("Accounts&action");
		Organization orgpage = new Organization(driver);
		 
		 orgpage.getSearchBox().sendKeys(orgName);
		 orgpage.getSearchBtn().click();
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		// switch back to parant
		 
		 switchToWindow("Contacts");
		 saveBtn.click();
		 
		 
	}

}
