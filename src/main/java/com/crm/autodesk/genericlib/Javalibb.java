package com.crm.autodesk.genericlib;

import java.util.Date;
import java.util.Random;

public class Javalibb
{
	Date dateobj = new Date();
	
		public int getRandomNumber()
		{
			Random rndnum = new Random();
			int randomNum = rndnum.nextInt(10000);
			return randomNum;
		}
	
	
	public String getcurrentsystem_date()
	{
		String currentdate = dateobj.toString();
		return currentdate;
	}
	
	public String getdate()
	{
		String currentdate = dateobj.toString();
		String[] arr = currentdate.split(" ");
		return arr[2];
		
	}
	
	public String getcurrentyear()
	{
		String currentdate = dateobj.toString();
		String[] arr = currentdate.split(" ");
		return arr[5];
		
	}
	public String getcurrentmonth()
	{
		String currentdate = dateobj.toString();
		String[] arr = currentdate.split(" ");
		return arr[1];
		
	}
	public int getcurrentmonthint()
	{
		int month = dateobj.getMonth();
		return month;
		
	}
	

}
