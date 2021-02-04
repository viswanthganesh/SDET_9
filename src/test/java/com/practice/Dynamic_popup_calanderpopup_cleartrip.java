package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javalib.Javalibb;

public class Dynamic_popup_calanderpopup_cleartrip {
	

	@Test(dataProvider = "getdata")
	public void bookticket(String srcloction,String dstloction) {
		
		Javalibb lib = new Javalibb();
		String date = lib.getdate();
		int month = lib.getcurrentmonthint();	
		String year = lib.getcurrentyear();
		
		
		WebDriver driver =new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://www.cleartrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	     driver.findElement(By.id("FromTag")).sendKeys(srcloction);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+srcloction+"']")));
	     driver.findElement(By.xpath("//a[text()='"+srcloction+"']")).click();
	     
	     driver.findElement(By.id("ToTag")).sendKeys(dstloction);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+dstloction+"']")));
	     driver.findElement(By.xpath("//a[text()='"+dstloction+"']")).click();
	     
	     driver.findElement(By.xpath("//td[@data-month='"+month+"' and @data-year='"+year+"']/a[text()='"+date+"']")).click();
	     
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] objarr = new Object[5][2];
		
		
		objarr[0][0] = "Bangalore, IN - Kempegowda International Airport (BLR)";
    	objarr[0][1] ="Goa, IN - Dabolim Airport (GOI)";
		
		objarr[1][0] = "Bangalore, IN - Kempegowda International Airport (BLR)";
		objarr[1][1] ="Annecy, FR - Meythet (NCY)";
		
  		objarr[2][0] = "Bangalore, IN - Kempegowda International Airport (BLR)";
        objarr[2][1] ="Chennai, IN - Chennai Airport (MAA)";
		
		objarr[3][0] = "Bangalore, IN - Kempegowda International Airport (BLR)";
		objarr[3][1] ="Newark, US - Newark Liberty (EWR)";
		
		objarr[4][0] = "Bangalore, IN - Kempegowda International Airport (BLR)";
		objarr[4][1] ="Newcastle, AU - Williamtown (NTL)";
		return objarr;

		
		
	}
	
	

}
