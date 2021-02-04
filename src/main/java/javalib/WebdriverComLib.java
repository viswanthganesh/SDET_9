package javalib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverComLib 
{

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
	
	public void selectoptionBytext(String text,WebElement element)
	{
		Select s1 = new Select(element);
		s1.selectByVisibleText(text);
	}
	public void waitforelement(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforelementtovisibil(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToWindow(WebDriver driver,String partialwindowtitle)
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
	
	public void alertaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertdismis(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
}
