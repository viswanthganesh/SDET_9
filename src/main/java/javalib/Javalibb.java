package javalib;

import java.util.Date;
import java.util.Random;

public class Javalibb
{
	Date dateobj = new Date();
//	public static void main(String[] args) {
//		
//		String currentdate = dateobj.toString();
//		System.out.println(currentdate);
//		String[] arr = currentdate.split(" ");
//		System.out.println(arr);
//		
//		String date =arr[2];
//		int month = dateobj.getMonth();
//		String year = arr[5];
//		System.out.println(date);
//		System.out.println(month);
//		System.out.println(year);
		
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
