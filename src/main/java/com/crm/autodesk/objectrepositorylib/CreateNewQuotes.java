package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverCommomLib;

public class CreateNewQuotes extends WebDriverCommomLib
{
	
	
	
	
	
	public CreateNewQuotes (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement QuotesSub;
	
	
	@FindBy(name="bill_street")
	private WebElement BillStreet;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement BillCheckbox;
	
	@FindBy(xpath="//input[@name='contact_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement contactLookUp;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookUp;
	
	@FindBy(xpath="//img[@title='Products']")
	private WebElement proLookUp;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getQuotesSub() {
		return QuotesSub;
	}

	public WebElement getBillStreet() {
		return BillStreet;
	}

	public WebElement getBillCheckbox() {
		return BillCheckbox;
	}

	public WebElement getContactLookUp() {
		return contactLookUp;
	}

	public WebElement getOrgLookUp() {
		return orgLookUp;
	}

	public WebElement getProLookUp() {
		return proLookUp;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	 
	
	public void createQuotes(String Subject,String billadd,String orgName,String contactlastName,String proname) throws Throwable
	{
		waitforelement(QuotesSub);
		
		
		QuotesSub.sendKeys( Subject);
		waitforelement(orgLookUp);
		getOrgLookUp().click();
	
		 //switch control to child
		 switchToWindow("Accounts&action");
		Organization orgpage = new Organization(driver);
		
		 orgpage.getSearchBox().sendKeys(orgName);
		 orgpage.getSearchBtn().click();
		 waitforelement(driver.findElement(By.xpath("//a[text()='"+orgName+"']")));
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		 alertdismis();
		 //switch back to parent
		 switchToWindow("Quotes");
		 
		
		getContactLookUp().click();
		//switch control to child 
		switchToWindow("Contactss&action");
		Contacts contactpage = new Contacts(driver);
		contactpage.getSearchBox().sendKeys(contactlastName);
		contactpage.getSearchBtn().click();
		waitforelement(driver.findElement(By.xpath("//a[contains(text(),'"+contactlastName+"')]")));
		driver.findElement(By.xpath("//a[contains(text(),'"+contactlastName+"')]")).click();
		alertdismis();
		 //switch back to parent
		switchToWindow("Quotes");
		
		
		
		
		 BillStreet.sendKeys(billadd);
		 BillCheckbox.click();
		 
		 proLookUp.click();
		 //switch to child
		 Products propage = new Products(driver);
		 
		 switchToWindow("Products&action");
		 propage.getSearchBox().sendKeys(proname);
		 propage.getSearchBtn().click();
		 waitforelement(driver.findElement(By.xpath("//a[text()='"+proname+"']")));
		 driver.findElement(By.xpath("//a[text()='"+proname+"']")).click();
		 
		// switch back to parent
		 
		 switchToWindow("Quotes");
		 
		 saveBtn.click();
		 
		 
		 }
	
	
	
}
