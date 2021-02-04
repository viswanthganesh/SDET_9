package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Practice {
	@Test
	public void opthebrowser()
	{
      WebDriver driver =new FirefoxDriver();
		
		driver.get("https://www.makemytrip.com");
	}

}
