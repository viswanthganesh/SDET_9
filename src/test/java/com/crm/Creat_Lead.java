package com.crm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javalib.Javalibb;
import javalib.WebdriverComLib;

public class Creat_Lead 
{

	@Test
	public void create_lead()
	{
		

    Javalibb jLib = new Javalibb();
   WebdriverComLib wLib = new WebdriverComLib();
	
	WebDriver driver = new ChromeDriver();
	
	int RandomNum = jLib.getRandomNumber();
	//commondata for login
	String url="http://localhost:8888";
	String username="admin";
	String password="2307";
	//commondata for create organization
	String leadfirstname="vignesh"+RandomNum;
	String leadlastname="aaa"+RandomNum;
	String companyname="jspiders"+RandomNum;
	String leadsource="Employee";
	String leadindustry= "Banking";
	String leadStatus="Contacted";
	String leadRating="Active";
	
	//login to application
	
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	
	wLib.waitforelement(driver, driver.findElement(By.xpath("//a[text()='Leads']")));
	
	//navigate to leads
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
	//create leads
	
	wLib.waitforelement(driver, driver.findElement(By.xpath("//img[@title='Create Lead...']")));
	driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	
	driver.findElement(By.name("firstname")).sendKeys(leadfirstname);
	driver.findElement(By.name("lastname")).sendKeys(leadlastname);
	driver.findElement(By.name("company")).sendKeys(companyname);
	
	
	
	wLib.selectoptionBytext(leadsource, driver.findElement(By.name("leadsource")));
	wLib.selectoptionBytext(leadindustry, driver.findElement(By.name("industry")));
	wLib.selectoptionBytext(leadStatus, driver.findElement(By.name("leadstatus")));
	wLib.selectoptionBytext(leadRating,  driver.findElement(By.name("rating")));
	
	
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
    // verify the created lead
	wLib.waitforelementtovisibil(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
	String actLeadName= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	boolean actstatus = actLeadName.contains(leadfirstname);
	Assert.assertTrue(actstatus);
	
	//create product
	//a[text()='Products']
	
	//signout 
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
}





}

	
	
	
	

