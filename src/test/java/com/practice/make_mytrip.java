package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javalib.Javalibb;

public class make_mytrip {
	@Test(dataProvider="getdata")
	public void book_tick(String srcloction,String dstloction) throws Throwable
	{
		
		Javalibb lib = new Javalibb();
		String date = lib.getdate();
		String month = lib.getcurrentmonth();	
		String year = lib.getcurrentyear();
		
		WebDriver driver =new FirefoxDriver();
		driver.manage().deleteAllCookies();
		 WebDriverWait wait = new WebDriverWait(driver,20);
		
		
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Actions act = new Actions(driver);
		act.moveByOffset(5, 5).click().perform();
	        
	     driver.findElement(By.xpath("//span[text()='From']")).click();
	     driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(srcloction);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'"+srcloction+"')]")));
	        
	     driver.findElement(By.xpath("//p[contains(text(),'"+srcloction+"')]")).click();
	      
	      
		     driver.findElement(By.xpath("//span[text()='To']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dstloction);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'"+dstloction+"')]")));
		      driver.findElement(By.xpath("//p[contains(text(),'"+dstloction+"')]")).click();
		      
		      driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();;
		     
	     
	    driver.findElement(By.xpath("//div[contains(@aria-label,' "+month+" "+date+" "+year+"')]")).click();
	    Thread.sleep(3000);
	    driver.close();
	     
	     
	     
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] objarr = new Object[5][2];
		
		
		objarr[0][0] = "Bangalore";
    	objarr[0][1] ="Goa";
		
		objarr[1][0] = "Bangalore";
		objarr[1][1] ="Delhi";
		
  		objarr[2][0] = "Bangalore";
        objarr[2][1] ="Chennai";
		
		objarr[3][0] = "Bangalore";
		objarr[3][1] ="Madurai";
		
		objarr[4][0] = "Bangalore";
		objarr[4][1] ="Mumbai";
		return objarr;

		
		
	}
	

}
