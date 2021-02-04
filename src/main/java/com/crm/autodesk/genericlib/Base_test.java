package com.crm.autodesk.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base_test implements IAnnotation
{
public static WebDriver driver;

public void OpenBrowsr() throws Throwable
{
	PropertyFileUtils provalue = new PropertyFileUtils();
	String Browser = provalue.getPropertykeyValue(PRO_path, "browser");
	if (Browser.equals("firefox"))
	{     
		driver =new FirefoxDriver();
	}else if (Browser.equals("chrome")){
		System.setProperty(CHROE_key, CHROME_value);
		driver = new ChromeDriver();
	}else if(Browser.equals("ie")) {
		driver = new InternetExplorerDriver();
	}
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	 String appurl = provalue.getPropertykeyValue(PRO_path, "url");
	 driver.get(appurl);
		
		
	}

public void closeBrowser ()
{
	driver.close();
}
}