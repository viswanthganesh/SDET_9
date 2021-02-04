package com.crm;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javalib.Javalibb;
import javalib.WebdriverComLib;

public class Crm_create_organization
{
	
	

	@Test
	public void create_organization()
	{
		
        Javalibb jlib = new Javalibb();
        WebdriverComLib wLib = new WebdriverComLib();
    	
		
		WebDriver driver = new ChromeDriver();
		
		int RandomNum = jlib.getRandomNumber();
		//commondata for login
		String url="http://localhost:8888";
		String username="admin";
		String password="2307";
		//commondata for create organization
		String orgname="abc"+RandomNum;
		String orgind="Banking";
		String orgtype="Customer";
		String orgrating="Active";
		//commondata for create contact
		String contactFirstName="jspiders"+RandomNum;
		String contactLastName="qspiders"+RandomNum;
		//commondata for create product
		String ProductName="hplaptop"+RandomNum;
		//common data for create quotes
		String SubjecttName="quets for ordered product"+RandomNum;
		String BillingAdd = "5/9,kalayan nager 2nd street,chennai"+RandomNum;
		
		//login to application
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Organizations']")));
		
		//navigate to organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//create organization
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Create Organization...']")));
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement webelement1 = driver.findElement(By.name("industry"));
		Select s1 = new Select(webelement1);
		s1.selectByVisibleText(orgind);
		
		WebElement webelement2 = driver.findElement(By.name("accounttype"));
		Select s2 = new Select(webelement2);
		s2.selectByVisibleText(orgtype);
		
		
		WebElement webelement3 = driver.findElement(By.name("rating"));
		Select s3 = new Select(webelement3);
		s3.selectByVisibleText(orgrating);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify the created organization
		String actOrgName= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		boolean actstatus = actOrgName.contains(orgname);
		Assert.assertTrue(actstatus);
		//navigate to contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//create contact
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Create Contact...']")));
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		driver.findElement(By.name("firstname")).sendKeys(contactFirstName);
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
		
		//get all window sessions id
		
	    wLib.switchToWindow(driver, "Accounts&action");
		
		//switch control to window
		
		
		wLib.waitforelement(driver, driver.findElement(By.name("search_text")));
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
		//again switch back to parant window
		
	    wLib.switchToWindow(driver, "Contacts");
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  //verify the created organization
	  		String actcontactName= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	  		
	  		boolean status = actcontactName.contains(contactFirstName);
	  		Assert.assertTrue(status);
	  		
	  		
	  	//navigate to products
	  		driver.findElement(By.xpath("//a[text()='Products']")).click();
	  		//create products
	  		
	  		wLib.waitforelement(driver, driver.findElement(By.xpath("//img[@title='Create Product...']")));
	  		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	  		driver.findElement(By.name("productname")).sendKeys(ProductName);
	  		
	  	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  //verify the created organization
		  		String actproductName= driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		  		
		  		boolean prostatus = actproductName.contains(ProductName);
		  		Assert.assertTrue(prostatus);
		  		
		  		
			  	//navigate to Quotes
		  		    driver.findElement(By.xpath("//a[text()='More']")).click();
			  		driver.findElement(By.xpath("//a[text()='Quotes']")).click();
			  		
			  		//create quotes
			  		
			  		wLib.waitforelement(driver, driver.findElement(By.xpath("//img[@title='Create Quote...']")));
			  		driver.findElement(By.xpath("//img[@title='Create Quote...']")).click();
			  		
			  	    driver.findElement(By.name("bill_street")).sendKeys(BillingAdd);
			  		driver.findElement(By.name("subject")).sendKeys(SubjecttName);
			  		driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
			  		driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
			  	  //get window handels
			  		wLib.switchToWindow(driver, "Contactss&action");
			  		//switch control to contact lookup
			 
					wLib.waitforelement(driver, driver.findElement(By.name("search_text")));
					driver.findElement(By.name("search_text")).sendKeys(contactLastName);
					driver.findElement(By.name("search")).click();
					wLib.waitforelement(driver, driver.findElement(By.xpath("//a[contains(text(),'"+contactLastName+"')]")));
					driver.findElement(By.xpath("//a[contains(text(),'"+contactLastName+"')]")).click();
					wLib.alertdismis(driver);
					
					//switch back to quotes page
					wLib.switchToWindow(driver, "Quotes");
					
					//click on organisation lookup
					driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
					
					//get all window sessions id
					
				    wLib.switchToWindow(driver, "Accounts&action");
					
					//switch control to organization window
					
					
					wLib.waitforelement(driver, driver.findElement(By.name("search_text")));
					driver.findElement(By.name("search_text")).sendKeys(orgname);
					driver.findElement(By.name("search")).click();
					wLib.waitforelement(driver, driver.findElement(By.xpath("//a[text()='"+orgname+"']")));
					driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
					wLib.alertdismis(driver);
					
					//switch back to quotes page
					wLib.switchToWindow(driver, "Quotes");
					//click on products lookup
					driver.findElement(By.xpath("//img[@title='Products']")).click();
					//switch to product lookup page
					wLib.switchToWindow(driver, "Products&action");
					wLib.waitforelement(driver, driver.findElement(By.name("search_text")));
					driver.findElement(By.name("search_text")).sendKeys(ProductName);
					driver.findElement(By.name("search")).click();
					wLib.waitforelement(driver, driver.findElement(By.xpath("//a[text()='"+ProductName+"']")));
					driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
					//switch back to quotes page
					wLib.switchToWindow(driver, "Quotes");
					
					driver.findElement(By.xpath("//input[@name='qty1']")).sendKeys("2");
					  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					  //verify the created organization
					  		String actQuotesName= driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
					  		
					  		boolean quotesstatus = actQuotesName.contains(SubjecttName);
					  		Assert.assertTrue(quotesstatus);
					
					
					
			  	  
			  		
	  		
	  		//log out from app
	  		
	  		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	  		
	  		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	  		
	  		//close the browser
	  		driver.quit();
	  		
		
		
		
		
	}
	
	
	
	
	
}
