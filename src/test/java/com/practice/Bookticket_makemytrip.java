package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javalib.Javalibb;

public class Bookticket_makemytrip 
{
public static void  main(String[] arg ) {
		
		Javalibb lib = new Javalibb();
		String date = lib.getdate();
		int month = lib.getcurrentmonthint();	
		String year = lib.getcurrentyear();
		
		WebDriver driver =new FirefoxDriver();
		driver.manage().deleteAllCookies();
		 WebDriverWait wait = new WebDriverWait(driver,20);
		
		
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Actions act = new Actions(driver);
		act.moveByOffset(5, 5).click().perform();
	        
	     driver.findElement(By.xpath("//span[text()='From']")).click();
	     driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BLR");
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Bengaluru, India']")));
	        
	     driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
	      
	      
		     driver.findElement(By.xpath("//span[text()='To']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("GOI");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Goa, India']")));
		      driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
		     
	     
	    
	     
	     
	     
	}
}
