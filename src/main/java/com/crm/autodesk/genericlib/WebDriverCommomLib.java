package com.crm.autodesk.genericlib;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommomLib extends Base_test
{
	
	public String getpagetitile()
	{
		return driver.getTitle();
	}
	public void verify(String actual,String expected,String value)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(value+"is displayed", true);
	}
	
	public void selectoption(WebElement element,int index)
	{
		Select s1 = new Select(element);
		s1.selectByIndex(index);
	}
	public void selectoption(WebElement element,String value)
	{
		Select s1 = new Select(element);
		s1.selectByValue(value);
	}
	
	public void selectoption(String text,WebElement element)
	{
		Select s1 = new Select(element);
		s1.selectByVisibleText(text);
	}
	
	
	
	public void switchtoframe(int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	public void switchtoframe(String attribute)
	{
		driver.switchTo().frame(attribute);
	}
	
	
	public void switchtoframe(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	public void waitforpage(String tittle)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(tittle));
	}
	
	public void mouseover(WebElement element)
	
	{
		Actions ac = new Actions(driver);
		
		ac.moveToElement(element).perform();
	}
	 public void takepagescreenshort(String name) throws Throwable
	 {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		File dist = new File("./screenshort/"+name+".png");
		Files.copy(scr, dist);
	 }
	 public void waitforelement(WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void waitforelementtovisibil(WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void switchToWindow(String partialwindowtitle)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String winId = it.next();
				driver.switchTo().window(winId);
				String winTitle = driver.getTitle();
				if(winTitle.contains(partialwindowtitle))
				{
					System.out.println("window contol has switched");
					break;
				}
			}
		}
		
		
		public void alertaccept()
		{
			driver.switchTo().alert().accept();
		}
		
		public void alertdismis()
		{
			driver.switchTo().alert().dismiss();
		}
		
	 
	
	
	
	
	
	
	

}
