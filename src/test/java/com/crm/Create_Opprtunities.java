package com.crm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.Base_test;
import com.crm.autodesk.genericlib.Excellutills;
import com.crm.autodesk.genericlib.PropertyFileUtils;
import com.crm.autodesk.genericlib.WebDriverCommomLib;
import com.crm.autodesk.objectrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrepositorylib.Create_New_Opportunities;
import com.crm.autodesk.objectrepositorylib.Home;
import com.crm.autodesk.objectrepositorylib.Login;
import com.crm.autodesk.objectrepositorylib.Opportunities;
import com.crm.autodesk.objectrepositorylib.Opportunities_info;
import com.crm.autodesk.objectrepositorylib.Organization;
import com.crm.autodesk.objectrepositorylib.OrgnizationInfo;

import javalib.Javalibb;

public class Create_Opprtunities extends Base_test
{
	//object creation
		Base_test bLib = new Base_test();
		Excellutills eLib = new Excellutills();
		Javalibb jLib =new Javalibb();
		 PropertyFileUtils pLib = new PropertyFileUtils();
		 WebDriverCommomLib wLib =new WebDriverCommomLib();
		 
		 
		 @Test
		 public void Create_Opprtunity() throws Throwable
		 {
			 /* Common Data */
				int randomNum = jLib.getRandomNumber();
				String USERNAME = pLib.getPropertykeyValue(PRO_path, "username");
				String PASSWORD = pLib.getPropertykeyValue(PRO_path, "password");
				String URL = pLib.getPropertykeyValue(PRO_path, "url");
				String BROWSER = pLib.getPropertykeyValue(PRO_path, "browser");

				/* test Data */	
				

				String  potentialName= eLib.getExcellData(EXCEL_path,"Sheet2","tc_01", "potentialName")+ randomNum;
				String  OrgName= eLib.getExcellData(EXCEL_path,"Sheet2","tc_01", "orgName")+ randomNum;
				String orgType = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "orgType");
				String orgIndustry = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "orgind");
				String orgRating = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "orgrating");

				String Sales_stage1 = eLib.getExcellData(EXCEL_path,"Sheet2","tc_01", "sales_stage");
				String Sales_stage2 = eLib.getExcellData(EXCEL_path,"Sheet2","tc_02", "sales_stage");
				String Sales_stage3 = eLib.getExcellData(EXCEL_path,"Sheet2","tc_03", "sales_stage");

				String Sales_stage4 = eLib.getExcellData(EXCEL_path,"Sheet2","tc_04", "sales_stage");
				
				String Sales_stage5 = eLib.getExcellData(EXCEL_path,"Sheet2","tc_05", "sales_stage");
				String Sales_stage6  = eLib.getExcellData(EXCEL_path, "Sheet2","tc_06", "sales_stage");
				
				bLib.OpenBrowsr();
				//login to app
				Login loginPage = new Login(driver);
				loginPage.login(USERNAME, PASSWORD);
				//navigate to org
				Home HomePage = new Home(driver);
				HomePage.getOrgLink().click();
				//create org 
				Organization orgPage = new Organization(driver);
				 wLib.waitForHTMLDOM(driver);
				orgPage.getOrgImage().click();
				
				CreateNewOrganization CreateOrgPage = new CreateNewOrganization(driver);
				
				 CreateOrgPage.Createorganization(OrgName, orgIndustry, orgType, orgRating);
				 
				 //verify org
				OrgnizationInfo orgInfo = new  OrgnizationInfo(driver);
				String actSuccessfullMsg = orgInfo.getSucessFullMasg().getText();
				 Assert.assertTrue(actSuccessfullMsg.contains(OrgName));
				 //navi to opportunities
				 
				 HomePage.getOpportunitiesLink().click();
				 
				  Opportunities opp = new  Opportunities(driver);
				  opp.getopp().click();
				 
				 //create opp
				 
				Create_New_Opportunities CnP = new  Create_New_Opportunities (driver);
				CnP.create_potential(potentialName, OrgName, Sales_stage1);
				
				//verify opp
				Opportunities_info oppinfo = new Opportunities_info(driver);
				String actSuccessfullMsgopp = oppinfo.getSuccessfullmasage().getText();
				 Assert.assertTrue(actSuccessfullMsg.contains(potentialName));
				
				
				
				 HomePage.getOpportunitiesLink().click();
				 
				  opp.getopp().click();
				 
				 //create opp
				
				
				CnP.create_potential(potentialName, OrgName, Sales_stage2);
				
				String actSuccessfullMsgopp1 = oppinfo.getSuccessfullmasage().getText();
				 Assert.assertTrue(actSuccessfullMsgopp1.contains(potentialName));
				
				 HomePage.getOpportunitiesLink().click();
				 
				 
				  opp.getopp().click();
				 
				 //create opp
				 
				
				CnP.create_potential(potentialName, OrgName, Sales_stage3);
				String actSuccessfullMsgopp2 = oppinfo.getSuccessfullmasage().getText();
				 Assert.assertTrue(actSuccessfullMsgopp2.contains(potentialName));
				
				 HomePage.getOpportunitiesLink().click();
				 
				 
				  opp.getopp().click();
				 
				 //create opp
				 
				
				CnP.create_potential(potentialName, OrgName, Sales_stage4);
				
				String actSuccessfullMsgopp3 = oppinfo.getSuccessfullmasage().getText();
				 Assert.assertTrue(actSuccessfullMsgopp3.contains(potentialName));
				
				 HomePage.getOpportunitiesLink().click();
				
				  opp.getopp().click();
				 
				 //create opp
				 
				
				CnP.create_potential(potentialName, OrgName, Sales_stage5);
				String actSuccessfullMsgopp4 = oppinfo.getSuccessfullmasage().getText();
				 Assert.assertTrue(actSuccessfullMsgopp4.contains(potentialName));
				
				 HomePage.getOpportunitiesLink().click();
				 
				 
				  opp.getopp().click();
				 
				 //create opp
				 
				
				CnP.create_potential(potentialName, OrgName, Sales_stage6);
				String actSuccessfullMsgopp5 = oppinfo.getSuccessfullmasage().getText();
				 Assert.assertTrue(actSuccessfullMsgopp5.contains(potentialName));
				
		 }
				
}
